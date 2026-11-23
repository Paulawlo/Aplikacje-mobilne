package pl.edu.pwr.penguin.data

import android.content.Context
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import pl.edu.pwr.penguin.domain.*
import java.time.DayOfWeek
import java.time.LocalDate

@Entity(tableName = "habits")
data class HabitRow(@PrimaryKey val id: String, val name: String, val type: String, val goal: Double,
    val days: String, val archived: Boolean, val nextGoal: Double?, val nextDays: String?, val effectiveDate: String?)

@Entity(tableName = "entries", indices = [Index(value = ["habitId", "date"], unique = true)],
    foreignKeys = [ForeignKey(entity = HabitRow::class, parentColumns = ["id"], childColumns = ["habitId"], onDelete = ForeignKey.RESTRICT)])
data class EntryRow(@PrimaryKey val id: String, val habitId: String, val date: String, val amount: Double,
    val points: Double, val source: String, val verificationStatus: String, val syncStatus: String,
    val habitName: String, val habitUnit: String)

@Entity(tableName = "pending_operations", indices = [Index(value = ["entryId"], unique = true)])
data class PendingOperation(@PrimaryKey val id: String, val entryId: String, val status: String = "WAITING_FOR_BACKEND")

@Dao
abstract class HabitDao {
    @Query("SELECT * FROM habits ORDER BY rowid") abstract fun observeHabits(): Flow<List<HabitRow>>
    @Query("SELECT * FROM entries ORDER BY date, rowid") abstract fun observeEntries(): Flow<List<EntryRow>>
    @Query("SELECT COUNT(*) FROM habits") abstract suspend fun countHabits(): Int
    @Insert(onConflict = OnConflictStrategy.ABORT) abstract suspend fun insertHabit(habit: HabitRow)
    @Update abstract suspend fun updateHabit(habit: HabitRow)
    @Insert(onConflict = OnConflictStrategy.IGNORE) abstract suspend fun insertEntry(entry: EntryRow): Long
    @Insert(onConflict = OnConflictStrategy.ABORT) abstract suspend fun insertPending(operation: PendingOperation)
    @Transaction open suspend fun saveEntry(entry: EntryRow, operation: PendingOperation): Boolean {
        if (insertEntry(entry) == -1L) return false
        insertPending(operation)
        return true
    }
    @Transaction open suspend fun seed(habits: List<HabitRow>) {
        if (countHabits() == 0) habits.forEach { insertHabit(it) }
    }
}

@Database(entities = [HabitRow::class, EntryRow::class, PendingOperation::class], version = 1, exportSchema = false)
abstract class PenguinDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    companion object {
        @Volatile private var instance: PenguinDatabase? = null
        fun get(context: Context): PenguinDatabase = instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(context.applicationContext, PenguinDatabase::class.java, "penguin.db")
                .build().also { instance = it }
        }
    }
}

private fun encodeDays(days: Set<DayOfWeek>): String = days.sortedBy { it.value }.joinToString(",") { it.value.toString() }
private fun decodeDays(value: String): Set<DayOfWeek> = value.split(',').filter { it.isNotEmpty() }.map { DayOfWeek.of(it.toInt()) }.toSet()
fun Habit.toRow() = HabitRow(id, name, type.name, goal, encodeDays(days), archived, nextGoal, nextDays?.let(::encodeDays), effectiveDate?.toString())
fun HabitRow.toHabit() = Habit(id, name, HabitType.valueOf(type), goal, decodeDays(days), archived, nextGoal, nextDays?.let(::decodeDays), effectiveDate?.let(LocalDate::parse))
fun EntryRow.toEntry() = HabitEntry(habitId, LocalDate.parse(date), amount, points, source, verificationStatus, syncStatus, habitName, habitUnit)

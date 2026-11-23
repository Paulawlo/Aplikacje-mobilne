package pl.edu.pwr.penguin.data

import pl.edu.pwr.penguin.domain.Habit
import pl.edu.pwr.penguin.domain.HabitEntry
import java.time.LocalDate

/** Temporary, process-local data source for M4; persistence arrives in M5. */
class DemoRepository {
    private val habits = mutableListOf<Habit>()
    private val entries = mutableListOf<HabitEntry>()
    fun habits(): List<Habit> = habits.toList()
    fun entries(): List<HabitEntry> = entries.toList()
    fun add(habit: Habit) { habits.add(habit) }
    fun replace(habit: Habit) { val i = habits.indexOfFirst { it.id == habit.id }; if (i >= 0) habits[i] = habit }
    fun save(entry: HabitEntry): Boolean {
        if (entries.any { it.habitId == entry.habitId && it.date == entry.date }) return false
        entries.add(entry); return true
    }
    fun hasEntry(id: String, date: LocalDate) = entries.any { it.habitId == id && it.date == date }
}

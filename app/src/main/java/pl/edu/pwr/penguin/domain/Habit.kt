package pl.edu.pwr.penguin.domain

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.UUID

enum class HabitType(val label: String, val unit: String) {
    READING("Czytanie", "stron"), SLEEP("Sen", "godzin"), STEPS("Kroki", "kroków")
}

data class Habit(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val type: HabitType,
    val goal: Double,
    val days: Set<DayOfWeek>,
    val archived: Boolean = false,
    val nextGoal: Double? = null,
    val nextDays: Set<DayOfWeek>? = null,
    val effectiveDate: LocalDate? = null,
)

data class HabitEntry(val habitId: String, val date: LocalDate, val amount: Double, val points: Double, val source: String, val verificationStatus: String = "TEST", val syncStatus: String = "LOCAL", val habitName: String = "", val habitUnit: String = "")

object HabitRules {
    fun isValid(name: String, type: HabitType, goal: Double, days: Set<DayOfWeek>): Boolean =
        name.isNotBlank() && name.trim().length <= 60 && goal.isFinite() && goal > 0 &&
            (type != HabitType.SLEEP || goal in 6.0..24.0) && days.isNotEmpty()

    fun validAmount(type: HabitType, amount: Double): Boolean =
        amount.isFinite() && amount >= 0 && (type != HabitType.SLEEP || amount <= 24)

    fun points(type: HabitType, amount: Double, goal: Double): Double {
        require(validAmount(type, amount) && goal.isFinite() && goal > 0)
        if (type == HabitType.SLEEP && amount < 5.0) return 0.0
        return BigDecimal.valueOf((amount / goal).coerceAtMost(1.0) * 10.0)
            .setScale(1, RoundingMode.HALF_UP).toDouble()
    }

    fun weeklyQualified(earned: Double, possible: Double): Boolean {
        require(earned.isFinite() && possible.isFinite() && possible >= 0 && earned >= 0 && earned <= possible)
        return possible == 0.0 || earned * 4 >= possible * 3
    }

    fun healthDelta(results: List<Pair<Double, Double>>): Double {
        if (results.isEmpty()) return 1.0 // everyone rests
        require(results.all { (earned, possible) -> earned.isFinite() && possible.isFinite() && possible > 0 && earned >= 0 && earned <= possible })
        if (results.any { (earned, possible) -> earned * 4 < possible * 3 }) return -1.0
        if (results.any { (earned, possible) -> earned * 4 == possible * 3 }) return 0.0
        return if (results.all { (earned, possible) -> earned * 10 >= possible * 9 }) 1.5 else 1.0
    }

    fun nextMonday(date: LocalDate): LocalDate = date.plusDays((8 - date.dayOfWeek.value).toLong())
    fun applyScheduled(habit: Habit, date: LocalDate): Habit =
        if (habit.effectiveDate != null && !date.isBefore(habit.effectiveDate)) {
            habit.copy(goal = habit.nextGoal ?: habit.goal, days = habit.nextDays ?: habit.days,
                nextGoal = null, nextDays = null, effectiveDate = null)
        } else habit
}


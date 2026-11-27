package pl.edu.pwr.penguin.domain

import org.junit.Assert.*
import org.junit.Test
import java.time.DayOfWeek
import java.time.LocalDate

class HabitRulesTest {
    @Test fun pointsRespectPartialCapsAndSleepMinimum() {
        assertEquals(8.0, HabitRules.points(HabitType.READING, 4.0, 5.0), 0.001)
        assertEquals(10.0, HabitRules.points(HabitType.STEPS, 6000.0, 4000.0), 0.001)
        assertEquals(0.0, HabitRules.points(HabitType.SLEEP, 4.99, 6.0), 0.001)
        assertEquals(8.3, HabitRules.points(HabitType.SLEEP, 5.0, 6.0), 0.001)
    }
    @Test fun thresholdAndRestDays() {
        assertTrue(HabitRules.weeklyQualified(75.0, 100.0))
        assertFalse(HabitRules.weeklyQualified(74.9, 100.0))
        assertTrue(HabitRules.weeklyQualified(0.0, 0.0))
        assertEquals(1.0, HabitRules.healthDelta(emptyList()), 0.001)
        assertEquals(0.0, HabitRules.healthDelta(listOf(7.5 to 10.0, 9.0 to 10.0)), 0.001)
        assertEquals(-1.0, HabitRules.healthDelta(listOf(7.4 to 10.0, 10.0 to 10.0)), 0.001)
        assertEquals(1.5, HabitRules.healthDelta(listOf(9.0 to 10.0, 10.0 to 10.0)), 0.001)
    }
    @Test fun validationAndMondayChange() {
        assertFalse(HabitRules.isValid("", HabitType.READING, 5.0, setOf(DayOfWeek.MONDAY)))
        assertFalse(HabitRules.isValid("Sen", HabitType.SLEEP, 5.0, setOf(DayOfWeek.MONDAY)))
        assertFalse(HabitRules.validAmount(HabitType.SLEEP, 25.0))
        val monday = LocalDate.of(2026, 11, 23)
        assertEquals(monday, HabitRules.nextMonday(LocalDate.of(2026, 11, 20)))
        assertEquals(monday.plusWeeks(1), HabitRules.nextMonday(monday))
        val habit = Habit(name="Czytanie", type=HabitType.READING, goal=5.0, days=setOf(DayOfWeek.MONDAY), nextGoal=7.0, effectiveDate=monday)
        assertEquals(5.0, HabitRules.applyScheduled(habit, monday.minusDays(1)).goal, 0.001)
        assertEquals(7.0, HabitRules.applyScheduled(habit, monday).goal, 0.001)
    }
}

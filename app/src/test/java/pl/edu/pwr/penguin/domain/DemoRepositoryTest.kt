package pl.edu.pwr.penguin.domain

import org.junit.Assert.*
import org.junit.Test
import pl.edu.pwr.penguin.data.DemoRepository
import java.time.LocalDate

class DemoRepositoryTest {
    @Test fun duplicateEntryIsRejectedAndArchiveKeepsHistory() {
        val repo = DemoRepository()
        val habit = Habit(name = "Czytanie", type = HabitType.READING, goal = 5.0, days = java.time.DayOfWeek.entries.toSet())
        repo.add(habit)
        val entry = HabitEntry(habit.id, LocalDate.of(2026, 11, 20), 5.0, 10.0, "test")
        assertTrue(repo.save(entry))
        assertFalse(repo.save(entry))
        repo.replace(habit.copy(archived = true))
        assertTrue(repo.habits().single().archived)
        assertEquals(listOf(entry), repo.entries())
    }
}

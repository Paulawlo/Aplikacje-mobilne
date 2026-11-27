package pl.edu.pwr.penguin

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import pl.edu.pwr.penguin.data.*
import pl.edu.pwr.penguin.domain.*
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.UUID

enum class Screen { WELCOME, HOME, EDIT, ENTRY, HISTORY, GROUP }

class PenguinViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = PenguinDatabase.get(application).habitDao()
    var screen by mutableStateOf(Screen.WELCOME)
        private set
    var habits by mutableStateOf<List<Habit>>(emptyList())
        private set
    var entries by mutableStateOf<List<HabitEntry>>(emptyList())
        private set
    var selectedId by mutableStateOf<String?>(null)
        private set
    var error by mutableStateOf<String?>(null)
        private set
    var message by mutableStateOf<String?>(null)
        private set
    var busy by mutableStateOf(false)
        private set
    val today: LocalDate get() = LocalDate.now()
    val selected: Habit? get() = habits.find { it.id == selectedId }

    init {
        viewModelScope.launch {
            combine(dao.observeHabits(), dao.observeEntries()) { h, e -> h.map { it.toHabit() } to e.map { it.toEntry() } }
                .collect { (h, e) -> habits = h.map { HabitRules.applyScheduled(it, today) }; entries = e }
        }
    }
    private fun runOperation(block: suspend () -> Unit) {
        if (busy) return
        busy = true
        error = null
        viewModelScope.launch {
            try {
                block()
            } catch (cancelled: CancellationException) {
                throw cancelled
            } catch (_: Exception) {
                error = "Nie udało się zapisać danych. Spróbuj ponownie."
            } finally {
                busy = false
            }
        }
    }
    fun navigate(target: Screen) {
        error = null
        message = null
        screen = target
    }
    fun start() = runOperation {
        val all = DayOfWeek.entries.toSet()
        dao.seed(listOf(Habit(name="Czytanie", type=HabitType.READING, goal=5.0, days=all),
            Habit(name="Sen", type=HabitType.SLEEP, goal=6.0, days=all),
            Habit(name="Kroki", type=HabitType.STEPS, goal=4000.0, days=all)).map { it.toRow() })
        navigate(Screen.HOME)
    }
    fun edit(id: String?) {
        selectedId = id
        navigate(Screen.EDIT)
    }
    fun entry(id: String) {
        selectedId = id
        navigate(Screen.ENTRY)
    }
    fun saveHabit(name: String, type: HabitType, text: String, days: Set<DayOfWeek>) {
        val goal = text.replace(',', '.').toDoubleOrNull()
        if (goal == null || !HabitRules.isValid(name, type, goal, days)) {
            error = "Wpisz nazwę, poprawny cel (sen: 6–24 h) i wybierz co najmniej jeden dzień."
            return
        }
        val old = selected
        runOperation {
            if (old == null) dao.insertHabit(Habit(name=name.trim(), type=type, goal=goal, days=days).toRow())
            else dao.updateHabit(old.copy(name=name.trim(), nextGoal=goal, nextDays=days, effectiveDate=HabitRules.nextMonday(today)).toRow())
            screen = Screen.HOME
            message = if (old == null) "Dodano nawyk." else "Nowy cel i dni zaczną obowiązywać w poniedziałek."
        }
    }
    fun archive(id: String) {
        val habit = habits.find { it.id == id } ?: return
        runOperation { dao.updateHabit(habit.copy(archived=true).toRow()); message = "Nawyk zarchiwizowany; historia pozostaje dostępna." }
    }
    fun saveEntry(text: String) {
        val habit = selected ?: return
        val amount = text.replace(',', '.').toDoubleOrNull()
        if (amount == null || !HabitRules.validAmount(habit.type, amount)) { error = "Podaj poprawny wynik (sen: od 0 do 24 godzin)."; return }
        if (today.dayOfWeek !in habit.days) { error = "Ten nawyk nie jest zaplanowany na dziś."; return }
        val isManual = habit.type == HabitType.SLEEP
        val id = UUID.randomUUID().toString()
        val row = EntryRow(id, habit.id, today.toString(), amount, HabitRules.points(habit.type, amount, habit.goal),
            if (isManual) "Wpis ręczny" else "Wpis testowy bez OCR", if (isManual) "MANUAL" else "UNVERIFIED",
            "LOCAL_ONLY", habit.name, habit.type.unit)
        runOperation {
            val saved = dao.saveEntry(row, PendingOperation(id = UUID.randomUUID().toString(), entryId=id,
                status = if (isManual) "WAITING_FOR_BACKEND" else "WAITING_FOR_VERIFICATION"))
            if (!saved) { error = "Dzisiejszy wynik został już zapisany."; return@runOperation }
            screen = Screen.HOME; message = "Zapisano na urządzeniu. Synchronizacja nie jest jeszcze dostępna."
        }
    }
}


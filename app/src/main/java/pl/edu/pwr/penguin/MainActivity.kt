package pl.edu.pwr.penguin

import android.os.Bundle
import android.content.ActivityNotFoundException
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.FileProvider
import java.io.File
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import pl.edu.pwr.penguin.domain.*
import java.time.DayOfWeek

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { PenguinApp() } }
    }
}

private val dayNames = listOf("Pn", "Wt", "Śr", "Cz", "Pt", "Sb", "Nd")

@Composable
private fun PenguinApp(vm: PenguinViewModel = viewModel()) {
    Scaffold(bottomBar = {
        if (vm.screen in setOf(Screen.HOME, Screen.HISTORY, Screen.GROUP)) {
            NavigationBar {
                listOf(Screen.HOME to "Nawyki", Screen.HISTORY to "Historia", Screen.GROUP to "Grupa").forEach { (screen, label) ->
                    NavigationBarItem(selected = vm.screen == screen, onClick = { vm.navigate(screen) },
                        icon = { Text(label.take(1)) }, label = { Text(label) })
                }
            }
        }
    }) { inner ->
        Column(Modifier.fillMaxSize().padding(inner).verticalScroll(rememberScrollState()).padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            when (vm.screen) {
                Screen.WELCOME -> {
                    Text("Pingwinek", style = MaterialTheme.typography.headlineLarge)
                    Text("Razem budujemy dobre nawyki.", style = MaterialTheme.typography.titleMedium)
                    Notice("Nawyki i wpisy są zapisywane na tym urządzeniu. Synchronizacja nie jest jeszcze dostępna.")
                    Button(onClick = vm::start, enabled = !vm.busy) { Text("Rozpocznij") }
                }
                Screen.HOME -> Home(vm)
                Screen.EDIT -> EditHabit(vm)
                Screen.ENTRY -> EntryScreen(vm)
                Screen.HISTORY -> History(vm)
                Screen.GROUP -> GroupScreen()
            }
        }
    }
}

@Composable
private fun Notice(text: String) {
    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)) {
        Text(text, modifier = Modifier.padding(14.dp), style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
private fun Home(vm: PenguinViewModel) {
    Text("Twoje nawyki", style = MaterialTheme.typography.headlineMedium)
    Notice("Wpisy są zapisywane lokalnie. Nie są jeszcze synchronizowane ani udostępniane znajomym.")
    vm.message?.let { Text(it, color = MaterialTheme.colorScheme.primary) }
    Card {
        Column(Modifier.fillMaxWidth().padding(16.dp)) {
            Text("Wspólny pingwinek", fontWeight = FontWeight.Bold)
            Text("Stan grupy będzie dostępny po podłączeniu synchronizacji.")
        }
    }
    Button(onClick = { vm.edit(null) }) { Text("Dodaj nawyk") }
    val active = vm.habits.filterNot { it.archived }
    if (active.isEmpty()) Text("Brak aktywnych nawyków. Dodaj pierwszy nawyk.")
    active.forEach { habit ->
        Card {
            Column(Modifier.fillMaxWidth().padding(14.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(habit.name, style = MaterialTheme.typography.titleMedium)
                Text("Cel: ${habit.goal} ${habit.type.unit} · ${habit.days.sortedBy { it.value }.joinToString { dayNames[it.value - 1] }}")
                habit.effectiveDate?.let { Text("Nowy cel od $it: ${habit.nextGoal} ${habit.type.unit}") }
                val entry = vm.entries.find { it.habitId == habit.id && it.date == vm.today }
                Text(if (entry != null) "Dzisiaj: ${entry.points} pkt · ${if (entry.verificationStatus == "UNVERIFIED") "test, bez weryfikacji" else "lokalnie"}" else if (vm.today.dayOfWeek in habit.days) "Dzisiaj: do zrobienia" else "Dziś odpoczynek")
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    TextButton(onClick = { vm.entry(habit.id) }) { Text("Wpisz") }
                    TextButton(onClick = { vm.edit(habit.id) }) { Text("Edytuj") }
                    TextButton(onClick = { vm.archive(habit.id) }) { Text("Archiwizuj") }
                }
            }
        }
    }
}

@Composable
private fun EditHabit(vm: PenguinViewModel) {
    val old = vm.selected
    var name by rememberSaveable(old?.id) { mutableStateOf(old?.name ?: "") }
    var typeName by rememberSaveable(old?.id) { mutableStateOf(old?.type?.name ?: HabitType.READING.name) }
    val type = HabitType.valueOf(typeName)
    var goal by rememberSaveable(old?.id) { mutableStateOf((old?.nextGoal ?: old?.goal)?.toString() ?: "") }
    var selectedDays by rememberSaveable(old?.id) { mutableStateOf((old?.nextDays ?: old?.days ?: DayOfWeek.entries.toSet()).map { it.value }) }
    Text(if (old == null) "Nowy nawyk" else "Edytuj nawyk", style = MaterialTheme.typography.headlineMedium)
    OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Nazwa") }, singleLine = true, modifier = Modifier.fillMaxWidth())
    Text("Rodzaj: ${type.label} (${type.unit})")
    if (old == null) HabitType.entries.forEach { t ->
        Row { RadioButton(selected = type == t, onClick = { typeName = t.name }); Text(t.label, Modifier.padding(top = 13.dp)) }
    }
    OutlinedTextField(value = goal, onValueChange = { goal = it }, label = { Text("Cel: ${type.unit}") }, singleLine = true, modifier = Modifier.fillMaxWidth())
    Text("Dni tygodnia")
    DayOfWeek.entries.forEach { day ->
        Row { Checkbox(checked = day.value in selectedDays, onCheckedChange = { checked -> selectedDays = if (checked) selectedDays + day.value else selectedDays - day.value }); Text(dayNames[day.value - 1], Modifier.padding(top = 13.dp)) }
    }
    vm.error?.let { Text(it, color = MaterialTheme.colorScheme.error) }
    Button(enabled = !vm.busy, onClick = { vm.saveHabit(name, type, goal, selectedDays.map(DayOfWeek::of).toSet()) }) { Text("Zapisz") }
    TextButton(onClick = { vm.navigate(Screen.HOME) }) { Text("Anuluj") }
}

@Composable
private fun EntryScreen(vm: PenguinViewModel) {
    val habit = vm.selected ?: return
    var amount by rememberSaveable(habit.id) { mutableStateOf("") }
    val context = LocalContext.current
    var cameraPath by rememberSaveable { mutableStateOf<String?>(null) }
    var cameraMessage by rememberSaveable { mutableStateOf<String?>(null) }
    val camera = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        cameraPath?.let { File(it).delete() }
        cameraPath = null
        cameraMessage = if (success) "Zdjęcie wykonano i usunięto. OCR nie jest jeszcze dostępne, więc zdjęcie nie potwierdza nawyku." else "Zdjęcie anulowano lub nie udało się go zapisać. Spróbuj ponownie."
    }
    Text("Dodaj wynik: ${habit.name}", style = MaterialTheme.typography.headlineMedium)
    Notice(if (habit.type == HabitType.SLEEP) "Wpis ręczny. Mniej niż 5 godzin snu daje 0 punktów." else "Wpis testowy. Zdjęcie można wykonać, ale OCR i potwierdzanie nie są jeszcze dostępne.")
    Text("Dzisiejszy cel: ${habit.goal} ${habit.type.unit}")
    OutlinedButton(onClick = {
        try {
            val folder = File(context.cacheDir, "camera").apply { mkdirs() }
            val file = File.createTempFile("proof_", ".jpg", folder)
            cameraPath = file.absolutePath
            val uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
            camera.launch(uri)
        } catch (_: ActivityNotFoundException) {
            cameraPath?.let { File(it).delete() }; cameraPath = null
            cameraMessage = "Nie znaleziono aplikacji aparatu."
        } catch (_: Exception) {
            cameraPath?.let { File(it).delete() }; cameraPath = null
            cameraMessage = "Nie udało się uruchomić aparatu."
        }
    }, enabled = cameraPath == null) { Text("Zrób zdjęcie") }
    cameraMessage?.let { Text(it) }
    OutlinedTextField(value = amount, onValueChange = { amount = it }, label = { Text("Wynik: ${habit.type.unit}") }, singleLine = true, modifier = Modifier.fillMaxWidth())
    vm.error?.let { Text(it, color = MaterialTheme.colorScheme.error) }
    Button(enabled = !vm.busy, onClick = { vm.saveEntry(amount) }) { Text("Zapisz wynik testowy") }
    TextButton(onClick = { vm.navigate(Screen.HOME) }) { Text("Wróć") }
}

@Composable
private fun History(vm: PenguinViewModel) {
    Text("Historia", style = MaterialTheme.typography.headlineMedium)
    Notice("Historia jest zapisana na tym urządzeniu. Synchronizacja nie jest jeszcze dostępna.")
    if (vm.entries.isEmpty()) Text("Nie ma jeszcze zapisanych wyników.")
    vm.entries.asReversed().forEach { entry ->
        val habit = vm.habits.find { it.id == entry.habitId }
        Card { Column(Modifier.fillMaxWidth().padding(14.dp)) {
            Text(entry.habitName.ifBlank { habit?.name ?: "Nawyk" }, fontWeight = FontWeight.Bold)
            Text("${entry.date} · ${entry.amount} ${entry.habitUnit.ifBlank { habit?.type?.unit ?: "" }} · ${entry.points} pkt")
            Text(entry.source, style = MaterialTheme.typography.bodySmall)
        } }
    }
}

@Composable
private fun GroupScreen() {
    Text("Grupa", style = MaterialTheme.typography.headlineMedium)
    Notice("Grupy, zaproszenia i wspólny stan nie są jeszcze dostępne. Wymagają konfiguracji Firebase oraz bezpiecznego backendu.")
    Text("W przyszłości w grupie będą od 2 do 4 osób. Znajomi zobaczą nazwy nawyków i statusy, bez prywatnych wyników ani zdjęć.")
}





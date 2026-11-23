#set page(paper: "a4", margin: (x: 20mm, y: 17mm), numbering: "1")
#set text(font: "Arial", size: 10pt, lang: "pl")
#set par(leading: 0.6em, justify: true)
#show heading.where(level: 1): set text(size: 17pt, fill: rgb("#173e60"))
#show heading.where(level: 2): set text(size: 11pt, fill: rgb("#176178"))
#set list(spacing: 0.25em)
= Milestone 2 — Architektura i model danych
*Cel:* przygotować prosty projekt techniczny i uruchamialny szkielet aplikacji.

== Kroki
+ Zainstalujcie Android Studio, utwórzcie projekt Kotlin z minSdk 26, zsynchronizujcie Gradle i uruchomcie pustą aplikację na emulatorze lub telefonie. Zapiszcie kroki konfiguracji w README.
+ Przyjmijcie MVVM: ekran Compose pokazuje stan i przekazuje zdarzenia, ViewModel zarządza stanem, a repozytoria udostępniają dane i operacje. Reguły punktacji trzymajcie w osobnych klasach Kotlin.
+ Rozrysujcie dane: użytkownik, grupa 2–4 osób, nawyk, harmonogram, dzienny wpis i wynik analizy. Określcie identyfikatory, właściciela, datę i relacje. Jeden wpis na osobę, nawyk i dzień musi mieć jednoznaczny identyfikator.
+ Zaprojektujcie Room jako lokalną warstwę nad SQLite: encje, DAO, baza i wersja schematu. Zapisujcie historię oraz status synchronizacji. Ustalcie, które dane są trwałe, a które tymczasowe.
+ Zaprojektujcie Firebase Authentication i Firestore dla grupy: struktura dokumentów, dostęp wyłącznie uczestników, tworzenie zaproszenia i jego jednorazowe wykorzystanie przez zaufany backend. Sprawdźcie dostępność usługi i warunki przed decyzją.
+ Określcie źródło prawdy i przepływ offline: wpis lokalny jest oczekujący, po sieci synchronizowany, a po potwierdzeniu widoczny obu osobom. Nie naliczajcie wspólnego wyniku niezależnie na dwóch klientach; zaplanujcie odtwarzalne wyliczenie lub zaufany backend.
+ Zapiszcie krótkie ADR: problem, wybór, alternatywy i konsekwencje dla MVVM, Room, synchronizacji i AI. Uwzględnijcie konfigurację bez publikowania sekretów.

== Narzędzia i dlaczego
*Android Studio/Kotlin/Compose* wspierają natywne Android UI; *Room* upraszcza pracę z wymaganym SQLite; *Firebase* usuwa potrzebę budowy całego serwera, ale wymaga reguł dostępu i sieci.

== Rezultat i kontrola
Szkielet uruchamia się, istnieją schemat danych, przepływ synchronizacji i ADR. Druga osoba z zespołu potrafi odtworzyć uruchomienie.


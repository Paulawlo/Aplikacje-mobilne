#set page(paper: "a4", margin: (x: 20mm, y: 17mm), numbering: "1")
#set text(font: "Arial", size: 10pt, lang: "pl")
#set par(leading: 0.6em, justify: true)
#show heading.where(level: 1): set text(size: 17pt, fill: rgb("#173e60"))
#show heading.where(level: 2): set text(size: 11pt, fill: rgb("#176178"))
#set list(spacing: 0.25em)
= Milestone 0 — Zespół i pomysł
*Cel:* uzgodnić, jaki problem rozwiązujecie, kto wykonuje zadania i gdzie przechowujecie projekt.

== Kroki
+ *Ustalcie skład* 3–4 osób i zapiszcie dane zespołu oraz kanał kontaktu. Na krótkim spotkaniu omówcie dostępność i terminy prowadzącego.
+ *Uzupełnijcie kartę projektu:* problem spadku motywacji, grupa docelowa, dwie osoby realizujące nawyki oraz wspólny awatar. Opiszcie przykładowy dzień użytkownika i spodziewaną korzyść.
+ *Wybierzcie wersję MVP:* jeden awatar, jedna para, kilka typów nawyków i zdjęcie analizowane przez AI. Nie planujcie na start rankingów ani rozbudowanej gry.
+ *Podzielcie odpowiedzialności:* UI i nawigacja; baza i synchronizacja; aparat i AI; testy i dokumentacja. Przy trzech osobach połączcie role. Każdy powinien rozumieć działanie całości.
+ *Załóżcie repozytorium Git* na platformie dostępnej zespołowi, np. GitHub. Dodajcie README, plik ignorujący pliki generowane przez Android Studio i prostą tablicę zadań. Ustalcie gałęzie, przegląd zmian i krótkie spotkania.
+ *Zbierzcie niejasności* do prowadzącego: zasady oddania, terminy i oczekiwany poziom współpracy online. Nie umieszczajcie haseł i kluczy administracyjnych w repozytorium.

== Narzędzia i dlaczego
- *Git + GitHub:* historia zmian i wspólna praca; alternatywą jest inna znana zespołowi platforma Git.
- *Markdown i tablica zadań:* proste do aktualizacji i dostępne dla wszystkich, bez rozbudowanego systemu zarządzania.

== Rezultat i kontrola
Karta pomysłu, lista ról, tablica i repozytorium. Każda osoba potrafi sklonować repozytorium i w jednym zdaniu opisać problem oraz MVP.

#set page(paper: "a4", margin: (x: 20mm, y: 17mm), numbering: "1")
#set text(font: "Arial", size: 10pt, lang: "pl")
#set par(leading: 0.6em, justify: true)
#show heading.where(level: 1): set text(size: 17pt, fill: rgb("#173e60"))
#show heading.where(level: 2): set text(size: 11pt, fill: rgb("#176178"))
#set list(spacing: 0.25em)
= Milestone 3 — UX/UI i prototyp
*Cel:* sprawdzić pełny przebieg korzystania z aplikacji przed rozbudową kodu.

== Kroki
+ Wypiszcie ekrany: start/logowanie, tworzenie lub dołączanie do grupy, lista i formularz nawyków, zdjęcie i wynik, wspólny awatar oraz historia. Narysujcie przejścia między nimi.
+ Przygotujcie najpierw proste szkice na papierze, a następnie, jeśli potrzebny klikalny prototyp, w Figma. Na ekranie awatara pokażcie wkład członków grupy, datę i stan synchronizacji.
+ Rozrysujcie także brak nawyków lub grupy, brak internetu, oczekiwanie na synchronizację, anulowanie zdjęcia, odmowę uprawnień, wynik niepewny i błąd. Przy każdym stanie zaproponujcie następny krok użytkownika.
+ Ustalcie wspólne kolory, typografię, etykiety i rozmiary przycisków. Nie opierajcie informacji wyłącznie na kolorze; sprawdźcie kontrast i czytelność przy większym tekście.
+ Poproście co najmniej jedną osobę spoza zespołu o przejście scenariusza bez podpowiedzi. Zapiszcie, gdzie się zatrzymuje, i poprawcie najważniejsze problemy.
+ Przekażcie szkice implementującym UI i porównajcie je z wymaganiami M1. Nie traktujcie prototypu jako dowodu, że synchronizacja czy AI już działają.

== Narzędzia i dlaczego
- *Papier:* najszybszy do zmiany i niewymagający konfiguracji.
- *Figma lub podobne narzędzie:* przydatne do wspólnego, klikalnego przepływu; nie jest konieczne do uruchomienia aplikacji.
- *Compose i Material:* gotowe elementy ułatwiają zachowanie spójności w implementacji.

== Rezultat i kontrola
Prototyp wszystkich ekranów i stanów, krótka notatka z próby użytkownika oraz lista poprawek. Można wskazać, jak użytkownik wraca do działania po błędzie.


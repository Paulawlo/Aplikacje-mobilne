#set page(paper: "a4", margin: (x: 20mm, y: 17mm), numbering: "1")
#set text(font: "Arial", size: 10pt, lang: "pl")
#set par(leading: 0.6em, justify: true)
#show heading.where(level: 1): set text(size: 17pt, fill: rgb("#173e60"))
#show heading.where(level: 2): set text(size: 11pt, fill: rgb("#176178"))
#set list(spacing: 0.25em)
= Milestone 4 — Rdzeń aplikacji i tryb co-op
*Cel:* uruchomić podstawową ścieżkę dwóch użytkowników na danych testowych i następnie na wspólnych danych.

== Kroki
+ Zbudujcie nawigację i ekrany Compose zgodnie z prototypem. Dla każdego ekranu przygotujcie ViewModel, stan ładowania, wynik i błąd; zweryfikujcie zachowanie po obróceniu ekranu.
+ Dodajcie formularz i listę nawyków: nazwa, wybrane dni, właściciel i typ zdjęcia. Zweryfikujcie niepoprawne dane. Określcie, czy usuwanie archiwizuje nawyk, tak aby zachować historię.
+ Zaimplementujcie reguły M1 jako oddzielne funkcje Kotlin. Na początku użyjcie repozytorium testowego i kontrolowanego wyniku analizy; taka atrapa nie jest gotową funkcją AI.
+ Skonfigurujcie Firebase Authentication, Firestore i projekt dla zespołu. Utwórzcie parę, generujcie zaproszenie i obsłużcie dołączenie. Użycie zaproszenia i członkostwo weryfikujcie w zaufanej części backendu.
+ Ograniczcie odczyt i zapis regułami Firestore do uczestników pary; przetestujcie także obce konto. Użyjcie jednoznacznych identyfikatorów dziennych wpisów i zapobiegajcie wielokrotnemu zaliczeniu.
+ Wyliczajcie wspólny obraz z potwierdzonych wpisów i utrwalonych reguł dnia albo w zaufanej operacji backendowej. Wykonajcie jednoczesne wpisy na dwóch urządzeniach i sprawdźcie zgodność.

== Narzędzia i dlaczego
*Compose + ViewModel* upraszczają UI i jego stan. *Firebase Authentication + Firestore* zapewniają konta i współdzielenie danych bez tworzenia pełnego serwera; reguły i zaufana operacja nadal wymagają implementacji.

== Rezultat i kontrola
Dwa konta łączą się w parę, zarządzają nawykami i widzą zgodny wynik przy połączeniu. Obce konto nie ma dostępu. AI pozostaje atrapą do M6.

# Pingwinek – aplikacje mobilne

Pingwinek to aplikacja na Androida, która ma pomagać w regularnym wykonywaniu nawyków. Docelowo grupa 2–4 osób wspólnie opiekuje się pingwinkiem, którego stan zależy od ich postępów.

## Aktualny stan

- Dodawanie i edycja nawyków (czytanie, sen, kroki).
- Zapisywanie wyników i historii lokalnie w Room (SQLite).
- Naliczanie punktów oraz archiwizacja nawyków.
- Testowe uruchamianie aparatu.

OCR, logowanie, synchronizacja i wspólny stan pingwinka nie są jeszcze gotowe.

## Uruchomienie

Kod aplikacji znajduje się w gałęzi [milestone5](https://github.com/Paulawlo/Aplikacje-mobilne/tree/milestone5), nie w `main`.

1. Pobierz repozytorium i przełącz się na gałąź `milestone5` (`git checkout milestone5`).
2. Otwórz folder projektu w Android Studio.
3. Zainstaluj Android SDK Platform 35 i ustaw Gradle JDK na 17.
4. Uruchom konfigurację `app` na emulatorze API 26 lub nowszym albo na telefonie.

Można również zbudować APK poleceniem `./gradlew :app:assembleDebug` (Windows: `.\gradlew.bat :app:assembleDebug`).

Wcześniejsza wersja została uruchomiona na emulatorze API 26; sprawdzono zapis wyniku po zamknięciu aplikacji. Kompilacja po uzupełnieniu plików w repozytorium wymaga ponownego sprawdzenia.

## Etapy projektu

| Gałąź | Zawartość |
| --- | --- |
| [work-plan](https://github.com/Paulawlo/Aplikacje-mobilne/tree/work-plan) | Plan pracy i założenia |
| [milestone0](https://github.com/Paulawlo/Aplikacje-mobilne/tree/milestone0) | Pomysł |
| [milestone1](https://github.com/Paulawlo/Aplikacje-mobilne/tree/milestone1) | Wymagania |
| [milestone2](https://github.com/Paulawlo/Aplikacje-mobilne/tree/milestone2) | Architektura i model danych |
| [milestone3](https://github.com/Paulawlo/Aplikacje-mobilne/tree/milestone3) | Prototyp i UX |
| [milestone4](https://github.com/Paulawlo/Aplikacje-mobilne/tree/milestone4) | Reguły nawyków i testy |
| [milestone5](https://github.com/Paulawlo/Aplikacje-mobilne/tree/milestone5) | Aktualny kod Android |
| [milestone6](https://github.com/Paulawlo/Aplikacje-mobilne/tree/milestone6) – [milestone8](https://github.com/Paulawlo/Aplikacje-mobilne/tree/milestone8) | Dokumenty kolejnych etapów |

Prototyp HTML jest dostępny w gałęzi milestone5. Nie jest zrzutem ekranu działającej aplikacji.

Projekt nie wymaga obecnie konfiguracji Firebase do uruchomienia lokalnych funkcji. Wstępne reguły Firestore i ich testy znajdują się w milestone2.

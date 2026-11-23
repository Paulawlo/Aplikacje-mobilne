# Aplikacje mobilne — Pingwinek

Szkielet aplikacji Android w Kotlinie i Compose. Projekt jest na wczesnym etapie: nawyki i wpisy są zapisywane lokalnie w Room/SQLite, a aparat można uruchomić testowo. OCR, konta i synchronizacja nie są jeszcze zaimplementowane.

## Uruchomienie

1. Zainstaluj Android Studio oraz Android SDK Platform 35. W ustawieniach Gradle wybierz JDK 17 (np. JDK dołączone do zgodnej wersji Android Studio).
2. Otwórz w Android Studio folder zawierający `settings.gradle.kts`. Pozwól Gradle pobrać zależności i zaakceptuj ewentualne licencje SDK.
3. Utwórz emulator Android API 26 lub nowszy albo podłącz telefon z włączonym debugowaniem USB.
4. Wybierz konfigurację `ap
p` i uruchom aplikację. Po skonfigurowaniu wrappera można też zbudować ją poleceniem `./gradlew :app:assembleDebug` (Windows: `.\gradlew.bat :app:assembleDebug`).

**Stan weryfikacji:** nową wersję z Room zbudowano i uruchomiono na emulatorze API 26, sprawdzając zapis po zamknięciu aplikacji. Z powodu blokady zwykłego katalogu `app/build` aktualny testowy APK znajduje się w `.local-tools/fresh-build/app/outputs/apk/debug/app-debug.apk`. Nie ma jeszcze konfiguracji projektu Firebase.

Opis modelu i decyzji znajduje się w [milestone 2](milestone/milestone2/Architektura%20i%20model%20danych.md). Ustalenia produktu są w [milestone 1](milestone/milestone1/Odpowiedzi%20milestone1.md).

## Lokalne narzędzia na tym komputerze

W katalogu `.local-tools` znajdują się pobrane JDK 17, Android SDK i pamięć Gradle. Katalog oraz `local.properties` są pomijane przez Git. Aby zbudować projekt w PowerShell, można uruchomić:

```powershell
$env:JAVA_HOME = (Resolve-Path '.local-tools\jdk').Path
$env:GRADLE_USER_HOME = (Resolve-Path '.local-tools').Path + '\gradle-home'
.\gradlew.bat :app:assembleDebug
```




## Lokalne testy reguł Firestore

W katalogu `tests/firestore` znajdują się testy wstępnych reguł; reguły obecnie blokują wszystkie zapisy klientów. Nie są wdrożone w chmurze. Testy wymagają Node.js, npm, Javy zgodnej z bieżącym emulatorem oraz internetu przy pierwszym pobraniu zależności:

```powershell
npm.cmd install --prefix tests/firestore
.\tests\firestore\node_modules\.bin\firebase.cmd emulators:exec --project demo-penguin --only firestore "npm.cmd --prefix tests/firestore test"
```

Identyfikator `demo-penguin` jest przeznaczony dla emulatora; do konfiguracji rzeczywistego Firebase potrzebne są osobny projekt i konto. Nie dodawaj do repozytorium kluczy serwisowych ani tokenów. Przed produkcyjnym użyciem trzeba zaimplementować i przetestować autoryzowany backend oraz sposób bezpiecznego zapisu.




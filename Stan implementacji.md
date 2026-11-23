# Milestone 5 — stan realizacji

## Zrobione

- Room/SQLite w wersji 1 przechowuje nawyki, harmonogramy, wpisy oraz status weryfikacji i synchronizacji. Wpis zachowuje nazwę i jednostkę z chwili utworzenia. Baza jest prywatna dla aplikacji, kopia Android Backup jest wyłączona.
- Unikalny indeks `(habitId, date)` zapobiega podwójnemu wpisowi. Zapis wpisu i oczekującej operacji odbywa się w jednej transakcji. Początkowe nawyki są dodawane tylko do pustej bazy; archiwizacja nie usuwa historii.
- Wyniki ręcznie wpisanego snu mają status lokalny. Pozostałe wpisy są testowe i niezweryfikowane; nie mogą być potraktowane jako wynik potwierdzony OCR. Użytkownik widzi, że synchronizacja nie działa.
- Systemowy aparat uruchamiany jest przez `TakePicture` i `FileProvider` dla pliku w pamięci podręcznej. Obsługiwane są anulowanie, brak aplikacji aparatu i wyjątek uruchomienia. Po otrzymaniu wyniku plik jest usuwany. OCR nie jest jeszcze zaimplementowane, więc zdjęcie nie potwierdza nawyku. Jeżeli proces zostanie przerwany podczas działania aparatu, system może zachować plik tymczasowy w pamięci podręcznej do jej oczyszczenia; należy dopracować sprzątanie po przerwaniu.
- APK skompilowano; jednostkowe testy istniejącej logiki przeszły. Na osobnym emulatorze API 26 zapisano czytanie 4/5 stron i po wymuszonym zamknięciu ponownie odczytano wynik 8 punktów.

## Pozostało

- Prawdziwa synchronizacja, autoryzacja, obsługa konfliktów i bezpieczne ponawianie: nie ma podłączonego projektu Firebase ani zaufanego backendu. Tabela oczekujących operacji jest przygotowana, ale nie ma procesu wysyłania; wpisy testowe nie są potwierdzonymi wynikami i nie mogą być automatycznie wysłane jako zweryfikowane.
- OCR i obsługa jego rezultatów należą do M6. Wykonanie zdjęcia jest testowe; potrzebne są testy aparatu na różnych urządzeniach oraz przypadki awarii i przerwania procesu.
- Migracje schematu będą potrzebne dopiero przy kolejnej wersji bazy; nie zastosowano usuwającej dane migracji zastępczej. Potrzebne są testy migracji przy pierwszej zmianie schematu.
- Nie sprawdzono jeszcze restartu całego urządzenia, jednoczesnej pracy na dwóch urządzeniach ani zachowania podczas wysyłania, ponieważ funkcja wysyłania nie istnieje. M5 nie jest w pełni ukończony.

## Budowanie na tym komputerze

Z powodu blokady poprzedniego katalogu `app/build` przez system/OneDrive testową kompilację wykonano do `.local-tools/fresh-build` używając lokalnego skryptu inicjującego `.local-tools/alternate-build.gradle`. To środowisko lokalne nie jest częścią repozytorium. Standardowa konfiguracja projektu pozostaje bez zmiany.

Dodatkowa próba automatyczna uruchomienia aparatu i anulowania na emulatorze nie potwierdziła oczekiwanego komunikatu, dlatego obsługa tego scenariusza nadal wymaga poprawy lub ręcznego sprawdzenia; nie należy traktować jej jako zweryfikowanej.

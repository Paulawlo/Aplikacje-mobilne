# Milestone 4 — stan implementacji

## Gotowe w lokalnym rdzeniu

- Ekrany Compose: rozpoczęcie, nawyki, formularz nawyku, wpis demonstracyjny, historia i informacja o grupie. ViewModel zachowuje stan podczas obrotu; formularze używają stanu zapisywalnego.
- Trzy przykładowe nawyki, dodawanie własnego nawyku z typem, celem i dniami, walidacja nazwy/celu/dni oraz archiwizacja z zachowaniem historii w bieżącej sesji. Wpis jest unikalny dla nawyku i daty.
- Przy edycji nowy cel i dni mają wejść w życie w następny poniedziałek. Dane i planowane zmiany istnieją jedynie w pamięci procesu, więc przepadają po jego zakończeniu; trwały zapis to M5.
- Testowe wpisy dla czytania i kroków są jawnie oznaczone jako symulacja. Sen ma wpis ręczny. Naliczanie punktów i progi w osobnych funkcjach domenowych; testy jednostkowe obejmują granice punktów, 75%, 90%, dzień odpoczynku, zmianę w poniedziałek i duplikat wpisu.
- Na ekranie grupy jawnie zaznaczono, że połączenie nie jest jeszcze dostępne.

## Pozostało do zakończenia M4

- Prawdziwe konta, bezpieczne zaproszenia, grupy 2–4 osób oraz udostępnianie postępu. Brak skonfigurowanego projektu Firebase i zaufanego backendu; reguły Firestore z M2 blokują zapisy klientów. Nie ma jeszcze testu dwóch urządzeń ani zgodnego wspólnego stanu.
- Ankieta, dopasowanie celów, wybór częstotliwości w pierwszym uruchomieniu i widoki szczegółowe zgodne z prototypem. Obecne wartości startowe są przykładami, nie wynikiem ankiety.
- Faktyczne rozliczanie grupy, stan/zdrowienie pingwinka, streak, przedłużenie i zasady pierwszego tygodnia; obecnie zaimplementowane są jedynie wybrane czyste funkcje obliczeniowe.
- Podłączenie repozytorium, czasu i strefy grupy do wspólnego źródła danych; historia powinna przechowywać migawkę nazwy i celu, aby późniejsza zmiana nazwy nie zmieniała opisu dawnych wpisów.
- Sprawdzenie odzyskania po ubiciu procesu i zmianie dnia wymaga trwałej bazy. Weryfikacja aparatu/OCR i reguł dostępu w pełnym przepływie jest w kolejnych etapach.

## Uruchomienie

Zgodnie z instrukcją w README uruchom `:app:testDebugUnitTest` i `:app:assembleDebug`. Nie traktuj przykładowego wpisu jako prawdziwego potwierdzenia wykonania nawyku.


## Wyniki sprawdzenia

- `:app:assembleDebug`: sukces.
- `:app:testDebugUnitTest`: sukces; testy obejmują punktację i warunki graniczne oraz uniknięcie duplikatu i zachowanie historii po archiwizacji w repozytorium demonstracyjnym.
- Android API 26: aplikacja uruchomiła się, a po naciśnięciu „Rozpocznij” potwierdzono ekran nawyków z widocznymi przykładowymi wpisami. Nie jest to pełny test interfejsu ani test synchronizacji.

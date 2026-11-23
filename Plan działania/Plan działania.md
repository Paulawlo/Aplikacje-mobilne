# Plan działania — grywalizacja nawyków w trybie co-op

## Cel i punkt wyjścia

Celem jest aplikacja na Androida, w której dwie osoby realizują własne codzienne nawyki i wspólnie dbają o awatara albo wioskę. Zdjęcie wykonane aparatem jest analizowane przez model rozpoznawania obrazu. Wyniki obojga wpływają na wspólny cel.

Plan opiera się na dokumentach `Założenia projektu.pdf` i `Projekt_Grywalizacja_Nawykow.pdf` z folderu „Założenia projektu + Inspiracje tematu”. W folderze nie ma kodu aplikacji, więc poniższe kroki zakładają rozpoczęcie implementacji od zera, a nie ocenę istniejącego działania.

Wymagania wynikające z materiałów: Android Studio, minimum API 26, Kotlin jako rekomendowany język, MVVM lub uzasadniona alternatywa, trwałe dane w SQLite, co najmniej jeden komponent sprzętowy, uzasadniona funkcja AI/ML, testy oraz dokumentacja i obrona. Karta pomysłu proponuje Kotlin, MVVM, aparat i klasyfikację zdjęć. Zespół ma liczyć 3–4 osoby.

## Decyzje do podjęcia przed implementacją

- [ ] Wybrać jedną formę wspólnego celu: awatar **albo** wioska. Ustalić prostą skalę stanu, np. 0–100, i sposób jej prezentacji.
- [ ] Ustalić, jak dwie osoby połączą konta na osobnych urządzeniach. Rekomendacja: kod zaproszenia, konto użytkownika i wspólny identyfikator pary. Wybrać dostępny backend i sposób uwierzytelniania; lokalne SQLite samo nie synchronizuje urządzeń. Sprawdzić wymagania prowadzącego i dostępność usługi przed wyborem.
- [ ] Zdefiniować reguły dnia: strefę czasową pary, termin rozliczenia, nawyki wymagane danego dnia, wpływ wyniku każdej osoby na stan oraz zasady pominięcia, cofnięcia i przerwania serii. Zapisać przykłady obliczeń.
- [ ] Ograniczyć MVP do kilku rodzajów nawyków, których obiekty model rzeczywiście rozpoznaje. Sprawdzić obsługiwane klasy, licencję, rozmiar, działanie na API 26 i możliwość pracy offline przed uzależnieniem projektu od modelu.
- [ ] Ustalić, co oznacza wynik niepewny lub błędny: ponowne zdjęcie, komunikat i ewentualna jawna ścieżka ręczna. Klasyfikacja nie dowodzi, że czynność została wykonana ani że zdjęcie jest aktualne — nie przedstawiać jej jako pełnego zabezpieczenia przed oszustwem.
- [ ] Ustalić, które dane i zdjęcia są przechowywane lokalnie lub przesyłane, jak długo oraz co dzieje się po usunięciu konta. Preferować niewysyłanie zdjęć, jeśli wystarczy lokalna analiza.

## Kolejność prac

### M0 — zespół i pomysł

- [ ] Uzupełnić kartę projektu: problem, grupa docelowa, proponowane rozwiązanie i skład zespołu.
- [ ] Podzielić odpowiedzialności za produkt i dokumentację, Android/UI, dane i synchronizację oraz aparat/AI i testy. Przy trzech osobach połączyć role; każdy powinien rozumieć całość.
- [ ] Ustalić repozytorium, sposób pracy na gałęziach, przegląd zmian i tablicę zadań.

**Rezultat:** karta projektu, skład, role i wspólne środowisko pracy.

### M1 — problem, wymagania i zakres MVP

- [ ] Opisać użytkownika, jego problem i scenariusz: zaproszenie znajomego, dodanie nawyków, wykonanie zdjęcia, weryfikacja oraz wspólny postęp.
- [ ] Spisać wymagania funkcjonalne: połączenie pary, zarządzanie nawykami, oznaczanie wykonania ze zdjęciem, wynik AI, historia i wspólny stan.
- [ ] Spisać wymagania niefunkcjonalne: API 26+, trwałość danych, obsługa braku internetu i uprawnień, czytelność interfejsu, prywatność oraz odporność na błędy.
- [ ] Dla każdego wymagania określić kryterium akceptacji. Oddzielić funkcje niezbędne od dodatków, np. wielu par, rankingów i powiadomień.
- [ ] Sprawdzić wykonalność rozpoznawania na próbnych zdjęciach i wybrać niewielką listę nawyków do demonstracji.

**Rezultat:** lista wymagań z kryteriami, zakres MVP i potwierdzona wykonalność podstawowego scenariusza AI.

### M2 — architektura, dane i decyzje techniczne

- [ ] Utworzyć projekt Android Studio: Kotlin, minimum API 26, konfiguracja budowania i repozytorium. Uruchomić pustą aplikację na emulatorze lub urządzeniu.
- [ ] Rozdzielić warstwy MVVM: ekran i stan UI, ViewModel, logika domenowa, repozytoria oraz źródła danych. Zdecydować, czy użyć Room jako warstwy nad SQLite, i opisać wybór w ADR.
- [ ] Zaprojektować encje: użytkownik, para, nawyk, harmonogram, wpis wykonania, wynik weryfikacji i stan/historia wspólnego celu. Określić identyfikatory, relacje, daty i ograniczenie jednego zaliczenia na nawyk i dzień.
- [ ] Zaprojektować synchronizację: źródło prawdy dla pary, autoryzację dostępu, kolejkę operacji offline, ponawianie, rozwiązywanie konfliktów i zabezpieczenie przed podwójnym naliczeniem. Wspólny wynik powinien być wyliczany spójnie po stronie autorytatywnej, nawet gdy obie osoby działają równocześnie.
- [ ] Sporządzić ADR dla architektury, bazy, synchronizacji i modelu AI; zapisać alternatywy i powody wyboru. Ustalić zakres danych wrażliwych i sposób konfiguracji sekretów poza repozytorium.

**Rezultat:** schemat danych, opis przepływu danych i synchronizacji, ADR oraz uruchamialny szkielet.

### M3 — UX/UI

- [ ] Przygotować przepływy i prototypy: pierwsze uruchomienie/logowanie, zaproszenie, lista nawyków, dodawanie i edycja, aparat i wynik AI, ekran wspólnego celu oraz historia.
- [ ] Zaprojektować stany: brak pary lub nawyków, ładowanie, brak internetu, odmowa aparatu, niepewny wynik, błąd synchronizacji i ponowienie.
- [ ] Sprawdzić na małym ekranie czytelność, wielkość elementów dotykowych, opisy i kontrast. Przejść scenariusz z potencjalnym użytkownikiem i poprawić prototyp.

**Rezultat:** prototyp kompletnej ścieżki użytkownika i lista poprawek.

### M4 — działający rdzeń MVP

- [ ] Zaimplementować nawigację, ekrany, ViewModele i walidację formularzy.
- [ ] Dodać tworzenie, wyświetlanie, edycję i usuwanie/dezaktywację nawyku; określić wpływ zmian na historię.
- [ ] Zaimplementować reguły dzienne, historię, stan wspólnego celu oraz wyliczenia na danych testowych. Obsłużyć wielokrotne naciśnięcia i odtworzenie ekranu.
- [ ] Dodać tworzenie pary i dołączanie kodem oraz wymianę danych między dwoma kontami za pomocą wybranego backendu. Dostęp do pary ograniczyć do jej uczestników.
- [ ] Sprawdzić pełny przepływ na dwóch urządzeniach lub emulatorach, początkowo z kontrolowanym wynikiem weryfikacji zastępującym AI.

**Rezultat:** działający rdzeń co-op; obie osoby widzą zgodny wspólny stan po synchronizacji.

### M5 — SQLite, aparat i niezawodność

- [ ] Podłączyć trwałe repozytoria SQLite: zapisywać nawyki, wpisy, wynik weryfikacji, historię i lokalną kopię stanu; przygotować wersjonowanie schematu i migracje.
- [ ] Zintegrować aparat, uprawnienia i zapis tymczasowego zdjęcia. Obsłużyć odmowę, anulowanie, brak aparatu i błędy zapisu; po analizie usuwać zdjęcia zgodnie z przyjętą polityką.
- [ ] Wdrożyć uzgodnione działanie offline: pokazać lokalne zmiany i ich status, a po odzyskaniu sieci bezpiecznie wysłać oczekujące operacje. Pokazać użytkownikowi, jeśli stan partnera jest nieaktualny.
- [ ] Sprawdzić restart aplikacji i urządzenia, ponowne wysłanie operacji, jednoczesne działania pary, brak sieci oraz ponowne połączenie.

**Rezultat:** dane przetrwają restart, aparat działa, a synchronizacja nie gubi ani nie powiela zmian w przetestowanych scenariuszach.

### M6 — AI/ML: weryfikacja zdjęcia

- [ ] Zintegrować wybrany model i przygotowanie obrazu zgodnie z jego wymaganiami; przypisać obsługiwane klasy do dostępnych typów nawyków.
- [ ] Ustalić próg pewności na podstawie prób, nie traktując go jako gwarancji prawdy. Obsłużyć wynik pozytywny, negatywny, niepewny i błąd modelu.
- [ ] Po zaakceptowaniu wyniku zapisać wpis i dopiero raz zaktualizować postęp. Zapewnić ponowne wykonanie zdjęcia i czytelne wyjaśnienie decyzji.
- [ ] Przygotować zestaw zdjęć pozytywnych i negatywnych, w różnych warunkach i na różnych urządzeniach. Zanotować liczbę poprawnych wyników oraz błędów obu rodzajów; opisać ograniczenia i wybrany próg.
- [ ] Zmierzyć czas analizy i sprawdzić zachowanie bez internetu oraz przy niedostatecznych zasobach urządzenia, zgodnie z wybraną implementacją.

**Rezultat:** funkcja AI jest częścią rzeczywistego przepływu, ma wyniki testów i opisane ograniczenia.

### M7 — integracja, testy i stabilizacja

- [ ] Wykonać testy jednostkowe reguł punktacji, granic dnia, serii, zmian harmonogramu i zapobiegania duplikatom; testować przypadki brzegowe, a nie tylko ścieżkę poprawną.
- [ ] Przetestować bazę i migracje, integrację synchronizacji, uprawnienia, aparat oraz przepływ UI. Sprawdzić minimum API 26 i nowsze dostępne wersje Androida.
- [ ] Przeprowadzić scenariusz na dwóch urządzeniach: utworzenie pary, dwa nawyki, zdjęcia, wyniki AI, wspólny stan, restart i synchronizacja po utracie sieci.
- [ ] Rejestrować błędy, ustalić priorytety, naprawić blokujące oraz powtórzyć odpowiednie testy. Przygotować wersję release candidate i sprawdzić czystą instalację.

**Rezultat:** lista testów z wynikami i ograniczeniami oraz stabilna wersja demonstracyjna.

### M8 — dokumentacja, demo i obrona

- [ ] Przygotować dokumentację: problem i użytkownik, wymagania funkcjonalne i niefunkcjonalne, MVP, architektura i ADR, model danych, UI/UX, sprzęt, AI/ML, testy, ograniczenia, instrukcja uruchomienia i wkład członków.
- [ ] Przygotować 3–4 diagramy UML wraz ze studiami przypadków, np. przypadków użycia, klas, sekwencji weryfikacji zdjęcia i aktywności synchronizacji. Uzgodnić oczekiwaną interpretację „case studies” z prowadzącym.
- [ ] Opisać konfigurację środowiska, backendu i danych testowych, sposób budowania i uruchomienia oraz wersje i wymagane uprawnienia; nie umieszczać sekretów w repozytorium.
- [ ] Przygotować krótkie demo na dwóch urządzeniach, konta testowe, sieć i alternatywny zapis przebiegu na wypadek awarii. Pokazać także błędny lub niepewny wynik AI.
- [ ] Przećwiczyć obronę: każdy członek wyjaśnia swoje decyzje, działanie kodu, wyniki testów i ograniczenia. Zweryfikować oraz zrozumieć kod wygenerowany z pomocą AI.

**Rezultat:** gotowy produkt, dokumentacja, powtarzalne demo i przygotowany zespół.

## Kryteria ukończenia projektu

- [ ] Czysta instalacja uruchamia się na obsługiwanym urządzeniu; instrukcja pozwala odtworzyć konfigurację.
- [ ] Dwie osoby łączą się w parę i widzą zgodne dane po synchronizacji; dostęp osób spoza pary jest zablokowany.
- [ ] Nawyk można dodać i wykonać, a wpis, historia i wspólny stan pozostają po ponownym uruchomieniu.
- [ ] Aparat i model są użyte w rzeczywistym scenariuszu; błędy i niepewne wyniki są obsłużone i opisane.
- [ ] Rozliczenie dnia oraz ponowienia i konflikty synchronizacji nie powodują podwójnego naliczenia w scenariuszach testowych; użytkownik widzi stan oczekujący na synchronizację.
- [ ] Testy mają zapisane wyniki, znane ograniczenia są jawne, a dokumentacja i demo pokrywają wymagania prowadzącego.

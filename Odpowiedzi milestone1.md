# Milestone 1 — problem, wymagania i zakres MVP

> Dokument roboczy do przeczytania i uzgodnienia przez zespół. Decyzje potwierdzone w rozmowie odróżniono od propozycji i kwestii do ustalenia. Plan dotyczy aplikacji na Androida; projekt rozpoczyna się od założeń, a nie od istniejącej implementacji.

## 1. Problem i użytkownik

### Problem

Wiele osób chciałoby wypracować zdrowe nawyki, takie jak regularny sen, aktywność fizyczna czy czytanie książek. Trudność sprawia utrzymanie ich przez dłuższy czas: cele bywają zbyt ambitne, użytkownicy tracą motywację albo zapominają o zaplanowanych czynnościach. Każda osoba zaczyna przy tym z innego poziomu.

Zwykła lista zadań pokazuje, co zostało zrobione, ale nie zawsze zachęca do regularności. Aplikacja ma wspierać użytkowników przez dopasowanie celów, stopniowe dodawanie nawyków oraz wspólną opiekę nad pingwinkiem.

### Grupa docelowa

Osoby, które chcą stopniowo budować lub utrzymywać korzystne nawyki, potrzebują motywacji i chcą realizować ten cel razem ze znajomymi. Aplikacja może być szczególnie przydatna osobom mającym trudność z regularnością lub preferującym wizualne przedstawienie postępu.

### Przykładowy użytkownik

Studentka chce poprawić regularność snu, więcej chodzić i zacząć czytać. Po pierwszym uruchomieniu odpowiada na pytania o obecne zwyczaje. Aplikacja proponuje jej trzy dopasowane cele. Studentka łączy się ze znajomymi, z którymi opiekuje się jednym pingwinkiem. Każda osoba realizuje własne nawyki; wspólny wysiłek pozwala pingwinkowi rosnąć.

### Cel aplikacji

1. Poznać punkt wyjścia użytkownika i zaproponować możliwe do wykonania cele.
2. Rozpocząć od trzech nawyków i po dwóch tygodniach zaproponować następny.
3. Motywować grupę przez rozwój wspólnego pingwinka i punkty.
4. Umożliwić potwierdzanie nawyków zdjęciem analizowanym przez OCR.
5. Pokazywać znajomym postępy po synchronizacji, zapewniając jednocześnie pracę offline.

### Założenia do sprawdzenia

- Wspólna opieka nad pingwinkiem zachęca do systematyczności.
- Trzy nawyki na początek są osiągalne dla użytkowników.
- Dodanie kolejnego nawyku po dwóch tygodniach jest pomocne, o ile użytkownik może odmówić.
- Wykonywanie zdjęć jest wystarczająco wygodne.
- Ograniczona tolerancja pojedynczych potknięć motywuje, nie powodując nadmiernej presji.

Warto porozmawiać z potencjalnymi użytkownikami i sprawdzić te założenia na prototypie.

## 2. Główny scenariusz korzystania

### Pierwsze uruchomienie

1. Użytkownik otwiera aplikację i poznaje zasady wspólnej opieki nad pingwinkiem.
2. Odpowiada na pytania dotyczące obecnych nawyków i preferencji.
3. Aplikacja proponuje trzy początkowe nawyki: czytanie, sen i kroki, wraz z celami dopasowanymi do odpowiedzi.
4. Użytkownik przegląda propozycje, może zmienić cele i zatwierdza plan.
5. Tworzy grupę lub dołącza do znajomych. Szczegóły zakładania kont i kolejność parowania pozostają do ustalenia.
6. Na ekranie głównym widzi wspólnego pingwinka, swoje nawyki i dostępne postępy grupy.

### Pytania początkowe — propozycja

| Obszar | Pytanie | Przykładowa odpowiedź |
|---|---|---|
| Sen | Ile godzin średnio śpisz w ciągu doby? | Około 6 godzin |
| Sen | Czy Twoje godziny snu są regularne? | Raczej nie |
| Aktywność | Ile kroków średnio robisz dziennie? | Około 4000 |
| Aktywność | Ile treningów wykonujesz tygodniowo? | Dwa |
| Czytanie | Czy obecnie czytasz książki? | Tak, sporadycznie |
| Czytanie | Jak często czytasz? | 1–2 razy w tygodniu |
| Czytanie | Ile stron zwykle czytasz podczas jednej sesji? | Około 10 |
| Preferencje | Nad czym najbardziej chcesz pracować? | Sen i aktywność |

**Propozycja:** dodać odpowiedź „nie wiem” i możliwość późniejszej zmiany celu. Zespół musi jeszcze ustalić, jak konkretne odpowiedzi przekładają się na propozycje. Aplikacja nie powinna przedstawiać celu dotyczącego snu jako indywidualnej porady medycznej.

### Codzienne korzystanie

1. Użytkownik widzi swoje zadania, stan wspólnego pingwinka i udostępnione postępy grupy.
2. Wybiera wykonany nawyk i robi odpowiednie zdjęcie.
3. Aplikacja odczytuje widoczny tekst przez OCR i próbuje porównać go z regułą nawyku.
4. Wyświetla wynik: zaliczenie, niespełnienie warunku albo prośbę o ponowne zdjęcie, gdy wynik jest nieczytelny lub niepewny.
5. Po zaakceptowaniu potwierdzenia zapisuje wpis, przyznaje punkty i aktualizuje wkład użytkownika do wspólnego celu.
6. Jeśli nie ma sieci, zapisuje dostępne lokalnie działania i pokazuje, że zmiany czekają na synchronizację.

### Po dwóch tygodniach

1. Aplikacja informuje, że minęło 14 dni od rozpoczęcia realizacji początkowych nawyków, i pokazuje podsumowanie.
2. Proponuje kolejny nawyk. Użytkownik decyduje, czy go zaakceptować; może pozostać przy dotychczasowych.
3. Moment kolejnej propozycji po odmowie oraz katalog następnych nawyków pozostają do ustalenia.

### Znajomi i praca offline

Użytkownik wysyła lub akceptuje zaproszenie do grupy. Po synchronizacji członkowie widzą uzgodnione postępy i stan jednego wspólnego pingwinka. Bez internetu użytkownik ma dostęp do zapisanych lokalnie danych i może wykonać dostępne lokalnie działania. Po odzyskaniu połączenia oczekujące zmiany są wysyłane. Stan znajomych może być nieaktualny, co aplikacja powinna pokazać.

**Do ustalenia:** maksymalna liczba osób w grupie oraz to, jakie szczegóły widzą znajomi — np. samo wykonanie nawyku czy również dokładną liczbę kroków i godzin snu.

## 3. Wymagania funkcjonalne

### Pierwsze uruchomienie i dopasowanie

| Nr | Wymaganie | Kryterium akceptacji |
|---|---|---|
| F1 | Aplikacja pyta o obecne nawyki użytkownika. | Przy pierwszym uruchomieniu można odpowiedzieć na pytania o sen, aktywność i czytanie. |
| F2 | Aplikacja proponuje trzy początkowe nawyki i cele na podstawie odpowiedzi. | Po ankiecie widoczne są czytanie, sen i kroki wraz z propozycjami celów. |
| F3 | Użytkownik może przejrzeć, zmienić i zatwierdzić cele. | Zmodyfikowane wartości są widoczne przed rozpoczęciem. |
| F4 | Aplikacja zapisuje wybory użytkownika. | Cele są dostępne po ponownym uruchomieniu. |

### Nawyki i historia

| Nr | Wymaganie | Kryterium akceptacji |
|---|---|---|
| F5 | Aplikacja obsługuje czytanie, sen i kroki. | Każdy rodzaj ma cel i możliwość zapisania wyniku. |
| F6 | Użytkownik widzi zadania na dany dzień. | Lista pokazuje zaplanowane nawyki i ich status. |
| F7 | Użytkownik może zmieniać cele i harmonogram. | Zapisana zmiana obowiązuje według ustalonej reguły czasu. |
| F8 | Aplikacja pokazuje historię. | Dostępne są wcześniejsze wyniki oraz dni bez wykonania zaplanowanego nawyku. |
| F9 | Po 14 dniach aplikacja proponuje kolejny nawyk. | Użytkownik widzi propozycję i może ją zaakceptować albo odrzucić lub odłożyć. |

### Wspólny pingwinek i punkty

| Nr | Wymaganie | Kryterium akceptacji |
|---|---|---|
| F10 | Grupa opiekuje się jednym pingwinkiem. | Członkowie grupy widzą ten sam potwierdzony stan po synchronizacji. |
| F11 | Rozwój zależy od realizacji nawyków przez wszystkich członków. | Wkład każdej osoby jest uwzględniany w rozliczeniu według uzgodnionych reguł. |
| F12 | Niezbyt częste potknięcia są tolerowane. | Pojedyncze braki w ramach zatwierdzonego limitu nie pogarszają stanu ani nie blokują rozwoju, zgodnie z regułą rozliczenia. |
| F13 | Zbyt częste niewykonywanie wpływa na pingwinka. | Po przekroczeniu ustalonej tolerancji pingwinek przestaje rosnąć lub choruje według zatwierdzonych zasad. |
| F14 | Użytkownik otrzymuje punkty za zaakceptowane potwierdzenie. | Liczba punktów zmienia się zgodnie z regułami punktacji. |
| F15 | Nie można wielokrotnie punktować tego samego wykonania. | Powtórzenie potwierdzenia nie powoduje ponownego przyznania punktów za ten sam nawyk i okres. |
| F16 | Użytkownicy widzą stan rozliczenia. | Aplikacja wyjaśnia stan pingwinka, wykorzystaną tolerancję i ewentualne oczekiwanie na synchronizację. |

### Zdjęcia i OCR

| Nr | Wymaganie | Kryterium akceptacji |
|---|---|---|
| F17 | Użytkownik wykonuje zdjęcie potwierdzające nawyk. | Może uruchomić aparat z ekranu wybranego nawyku. |
| F18 | OCR odczytuje tekst ze zdjęcia. | Czytelny tekst jest przekazywany do analizy w obsługiwanym scenariuszu. |
| F19 | Aplikacja analizuje odczyt zgodnie z nawykiem. | Dla ustalonego formatu potrafi porównać potrzebny wynik z celem albo poinformować, że nie potrafi go ustalić. |
| F20 | Aplikacja obsługuje nieczytelny lub niepewny wynik. | Użytkownik widzi komunikat i może ponowić zdjęcie. |

### Znajomi i offline

| Nr | Wymaganie | Kryterium akceptacji |
|---|---|---|
| F21 | Użytkownik może zaprosić znajomego lub dołączyć do grupy. | Po zaakceptowaniu zaproszenia uczestnicy widzą tę samą grupę. |
| F22 | Znajomi widzą uzgodnione, udostępnione postępy. | Po synchronizacji grupa widzi aktualne informacje zgodnie z ustawieniami dostępu. |
| F23 | Użytkownik może korzystać z lokalnych danych bez internetu. | Otwiera zapisane nawyki i historię oraz wykonuje dostępne lokalnie działania. |
| F24 | Zmiany offline synchronizują się po połączeniu. | Oczekujące wpisy trafiają do grupy bez powielenia w sprawdzonych scenariuszach. |
| F25 | Stan synchronizacji jest widoczny. | Użytkownik widzi, czy wpis oczekuje, został potwierdzony lub wymaga ponowienia. |

## 4. Wymagania niefunkcjonalne

| Obszar | Wymaganie |
|---|---|
| Platforma | Android, minimum API 26; projekt w Android Studio, Kotlin jako przyjęty język. |
| Architektura | MVVM lub inna uzasadniona architektura; logika punktów i pingwinka oddzielona od ekranów. |
| Trwałość | Lokalne nawyki, historia, punkty i kopia stanu grupy przechowywane w SQLite. |
| Offline | Dostęp do zapisanych danych i lokalna kolejka lub inny uzgodniony mechanizm oczekujących zmian; widoczna informacja o nieaktualnych danych. |
| Synchronizacja | Przesłanie zmian po odzyskaniu sieci, kontrola konfliktów i brak podwójnego naliczenia w testowanych scenariuszach. |
| Sprzęt | Aparat do wykonywania zdjęć potwierdzających. |
| AI/ML | OCR analizuje tekst ze zdjęć; wyniki i ograniczenia są testowane i opisane. |
| Prywatność | Do danych grupy dostęp mają uprawnieni uczestnicy; zakres udostępnianych danych trzeba uzgodnić. |
| Czytelność | Jasne cele, status nawyku, wyjaśnienie wyniku OCR, stanu pingwinka i synchronizacji. |
| Błędy | Obsługa braku sieci i aparatu, anulowania zdjęcia, błędu analizy i nieudanego wysłania danych. |
| Testowalność | Zasady punktacji, rozliczenia grupy i tolerancji można sprawdzić niezależnie od interfejsu. |

## 5. Zasady nawyków, punktów i pingwinka

### 5.1. Dopasowanie początkowych celów

Potwierdzony zakres pierwszych testowanych nawyków to czytanie książek, sen i kroki. Ankieta ma pomóc dopasować cel każdego z nich do aktualnej sytuacji użytkownika.

| Nawyk | Przykładowa odpowiedź | Kierunek propozycji |
|---|---|---|
| Czytanie | Czytam sporadycznie | Krótka, osiągalna sesja kilka dni w tygodniu. |
| Sen | Śpię około 6 godzin | Stopniowy cel związany z długością lub regularnością snu. |
| Kroki | Około 4000 kroków dziennie | Cel dobrany do obecnej średniej. |

Konkretne wartości, częstotliwość oraz sposób obliczenia pozostają do uzgodnienia. Użytkownik powinien móc skorygować propozycję.

### 5.2. Potwierdzenia

| Nawyk | Potwierdzenie przyjęte przez zespół | Co trzeba doprecyzować? |
|---|---|---|
| Czytanie | Zdjęcie przeczytanej strony książki. | Czy celem jest sesja, liczba stron czy inna miara? Jak odróżnić powtórzone zdjęcie? |
| Sen | Zdjęcie podsumowania snu. | Z jakich urządzeń/aplikacji i w jakim formacie? Jak rozpoznać datę i czas snu? |
| Kroki | Zdjęcie licznika kroków. | Jakie liczniki obsłużyć i jak rozpoznać datę oraz wynik? |

OCR odczytuje widoczny tekst, ale samo w sobie nie dowodzi, że strona została przeczytana, dane są aktualne lub zdjęcie autentyczne. Wynik może być błędny przy słabym świetle i różnych formatach. Pierwsza wersja powinna obsługiwać ograniczony, sprawdzony zestaw przykładów i jasno komunikować niepewność.

### 5.3. Punkty — propozycja

- Punkty przyznawane są za zaakceptowane potwierdzenie nawyku.
- Każdy nawyk ma limit punktów za ustalony okres; powtórzenie tego samego potwierdzenia nie zwiększa wyniku ponownie.
- Nieczytelne zdjęcie można powtórzyć.

**Do ustalenia:** liczba punktów, różnice między nawykami, punkty za częściowe wykonanie oraz ewentualna utrata punktów. Należy też zdecydować, czy punkty bezpośrednio sterują rozwojem pingwinka, czy opisują osobny wynik użytkownika.

### 5.4. Wspólny pingwinek i tolerancja potknięć

**Potwierdzona wizja:** grupa ma jednego pingwinka. Jego rozwój wymaga wykonywania nawyków przez wszystkich użytkowników. Pojedyncze potknięcie raz lub dwa nie powinno pogarszać jego stanu ani blokować rozwoju, ale nie może być tolerowane zbyt często.

**Propozycja do zatwierdzenia:** każda osoba ma dwa „dni wyrozumiałości” w ruchomym okresie 14 dni. Dzień wyrozumiałości zużywa się, gdy w danym dniu osoba nie wykona co najmniej jednego zaplanowanego nawyku; kilka braków tej samej osoby tego samego dnia zużywa jeden dzień. Jeśli wszystkie osoby wykonały swoje zadania lub ich braki mieszczą się w dostępnej tolerancji, grupa spełnia warunek rozwoju za ten dzień. Dni bez zaplanowanych nawyków nie zużywają tolerancji. Niewykorzystane dni nie kumulują się poza okres 14 dni.

Przykłady przy tej propozycji:

1. **Wszyscy wykonali zadania:** pingwinek otrzymuje postęp zgodnie z zasadą wzrostu; nikt nie zużywa dnia wyrozumiałości.
2. **Jedna osoba raz nie wykonała jednego z trzech zadań:** zużywa jeden dostępny dzień; przy spełnieniu warunków przez pozostałych rozwój nadal jest możliwy.
3. **Ta sama osoba ma trzeci dzień z brakami w ciągu 14 dni:** nie ma dostępnej tolerancji, więc grupa nie spełnia warunku rozwoju za ten dzień. Osobno trzeba ustalić, kiedy pingwinek zaczyna chorować.
4. **Dwie osoby mają braki tego samego dnia:** każda wykorzystuje własny dostępny dzień; warunek grupy jest spełniony tylko wtedy, gdy każda osoba ma wystarczającą tolerancję lub wykonała swoje zadania.
5. **Osoba nie ma zadań w danym dniu:** nie zużywa tolerancji; wpływ dnia, w którym nikt nie ma zadań, na wzrost pozostaje do ustalenia.

Tolerancja dotyczyłaby wyłącznie rozwoju pingwinka; punkty za niewykonany nawyk nie są automatycznie przyznawane. Rozliczenie oparte jest na potwierdzonych danych: przy braku sieci aplikacja pokazuje stan oczekujący i po synchronizacji przelicza go według tych samych zasad, bez karania za samo opóźnienie sieci.

**Do ustalenia:** czy limit dwóch dni na 14 dni jest odpowiedni, czy tolerancja ma być na osobę czy na grupę, kiedy pingwinek choruje, jak wraca do zdrowia, czy może cofnąć się w rozwoju, jak traktować zmianę składu grupy i przerwę zaplanowaną z wyprzedzeniem. Należy ustalić sposób rozliczenia spóźnionych wpisów i zmian historii, by wynik był jednakowy u wszystkich.

### 5.5. Czas i historia — propozycje do decyzji

- Sen można przypisywać do dnia obudzenia.
- Zmiana celu może obowiązywać od następnego dnia, aby nie zmieniać już rozpoczętego rozliczenia.
- Trzeba określić strefę czasową grupy, granicę dnia, termin przyjmowania spóźnionych wpisów oraz postępowanie przy korekcie błędu OCR.
- Historia powinna zachować reguły i cele obowiązujące w danym dniu, aby późniejsza zmiana nie przeliczała nieoczekiwanie przeszłości.

## 6. Zakres MVP i funkcje późniejsze

### Proponowane MVP

- Ankieta początkowa i możliwość korekty zaproponowanych celów.
- Trzy nawyki: czytanie, sen i kroki.
- Grupa znajomych z jednym pingwinkiem, wspólnym rozwojem i uzgodnioną tolerancją.
- Zdjęcia z OCR dla ograniczonych, wcześniej sprawdzonych formatów.
- Punkty, historia i komunikaty o niepewnych wynikach.
- Propozycja kolejnego nawyku po 14 dniach z decyzją użytkownika.
- Lokalny zapis i podstawowa praca offline, a po połączeniu synchronizacja grupy.

### Do rozważenia później

Rozbudowany sklep i stroje, wiele zwierząt, globalne rankingi, czat, duża biblioteka nawyków, skomplikowane animacje oraz integracje z wieloma urządzeniami i usługami zdrowotnymi.

## 7. Sprawdzenie wykonalności OCR i integracje zdrowotne

### Próba OCR

1. Zebrać po kilka własnych zdjęć strony książki, podsumowania snu i licznika kroków oraz ustalić, co dokładnie trzeba odczytać.
2. Uruchomić na urządzeniu prototyp OCR, np. ML Kit Text Recognition, i sprawdzić zgodność wybranej wersji z API 26.
3. Sprawdzić czytelne zdjęcia oraz zdjęcia ciemne, poruszone i wykonane pod kątem; uwzględnić różne formaty podsumowań.
4. Zanotować liczbę prób, poprawne i błędne odczyty tekstu, liczby i daty, wyniki niepewne oraz czas analizy.
5. Zdecydować, jakie formaty da się obsłużyć w MVP i kiedy należy poprosić o ponowienie. Opisać ograniczenia; zdjęcie strony nie dowodzi czytania.

### Health Connect i Apple Health

Na Androidzie można rozważyć **Health Connect** do odczytu dostępnych danych o krokach i śnie za zgodą użytkownika, jeśli inne urządzenie lub aplikacja zapisuje tam te dane. Health Connect wymaga Androida 9/API 28 lub nowszego i usług Google Play; na Androidzie 14 i nowszym jest częścią systemu. Wymagane przez projekt API 26 pozostaje obsługiwane przez alternatywną ścieżkę zdjęcia/OCR. Dostępność, uprawnienia i brak danych muszą być obsłużone w aplikacji.

Apple Health wykorzystuje HealthKit na urządzeniach Apple. Sama aplikacja Android nie uzyska bezpośredniego dostępu do danych z iPhone’a w prosty sposób; wymagałoby to dodatkowego rozwiązania po stronie Apple i przekazywania danych za zgodą użytkownika.

**Propozycja zakresu:** zdjęcia i OCR jako podstawowa ścieżka, Health Connect jako opcjonalne rozszerzenie dla kroków i snu, jeśli wystarczy czasu. Integracja nie zastępuje wymogu AI/OCR ani potrzeby weryfikacji wykonalności zdjęć.

Źródła: [Health Connect — dostępność](https://developer.android.com/health-and-fitness/health-connect/availability), [Health Connect — dane o śnie](https://developer.android.com/health-and-fitness/health-connect/experiences/sleep), [Apple HealthKit — dostępność](https://developer.apple.com/documentation/healthkit/hkhealthstore/ishealthdataavailable%28%29), [ML Kit — rozpoznawanie tekstu na Androidzie](https://developers.google.com/ml-kit/vision/text-recognition/v2/android).

## 8. Lista decyzji do zatwierdzenia

- [ ] Maksymalna liczba osób w grupie i sposób jej utworzenia.
- [ ] Jakie informacje o nawykach i dane zdrowotne są widoczne dla znajomych.
- [ ] Konkretne cele i algorytm ich doboru z ankiety.
- [ ] Definicja celu czytania oraz obsługiwane formaty podsumowania snu i kroków.
- [ ] Punkty, częściowe wykonanie i relacja punktów do wzrostu pingwinka.
- [ ] Czy przyjąć proponowane dwa dni wyrozumiałości na osobę w ruchomych 14 dniach; zasady choroby i zdrowienia.
- [ ] Strefa czasowa, granica dnia, spóźnione wpisy, zmiana celu i składu grupy.
- [ ] Co dzieje się po odrzuceniu propozycji dodatkowego nawyku.
- [ ] Czy Health Connect znajdzie się w pierwszej wersji, czy w rozszerzeniu.

## 9. Decyzje uzgodnione podczas dalszej rozmowy

Ta sekcja aktualizuje wcześniejsze propozycje i kwestie otwarte w dokumencie. Pozostałe punkty nadal wymagają uzgodnienia.

### Grupa i prywatność

- Grupa liczy **2–4 osoby** i wspólnie opiekuje się jednym pingwinkiem.
- Jedna osoba tworzy grupę, a pozostałe dołączają za pomocą kodu zaproszenia.
- Znajomi widzą nazwy nawyków pozostałych osób oraz informację o ich wykonaniu. Wszyscy widzą stan pingwinka i informację, czy grupa spełniła warunek jego rozwoju.
- Dokładne wartości, takie jak liczba kroków i godzin snu, są prywatne. Zdjęcia są analizowane w aplikacji i nie są pokazywane znajomym.

### Cele i czytanie

- Aplikacja proponuje trzy cele na podstawie ankiety. Użytkownik może je zmienić przed zatwierdzeniem. Sen jest mierzony minimalną liczbą godzin, a kroki minimalną liczbą kroków, w wybrane dni.
- Czytanie jest mierzone liczbą stron w wybrane dni. Początkowa propozycja wynosi **5 stron**; automatyczny cel rośnie o 2 strony co tydzień do maksymalnie 20 stron: 5, 7, 9, 11, 13, 15, 17, 19, 20.
- Użytkownik może sam zwiększyć cel, również powyżej 20 stron. Po ręcznym zwiększeniu automatyczne zwiększenia liczone są od nowej wartości i zatrzymują się na 20; cel ustawiony powyżej 20 nie rośnie automatycznie.
- Użytkownik deklaruje liczbę przeczytanych stron i wykonuje zdjęcie jednej strony jako dodatkowe potwierdzenie. OCR nie dowodzi, że zadeklarowana liczba stron została przeczytana.

### Punkty i tygodniowy wynik grupy

- Za każdy wykonany nawyk użytkownik otrzymuje **10 punktów**. Punkty są osobiste; za niewykonany nawyk nie są odejmowane.
- Wkład każdej osoby liczy się osobno. W ciągu tygodnia każda osoba może zdobyć najwyżej o **1/4 mniej** od maksymalnej liczby punktów możliwej do zdobycia za jej własne zaplanowane nawyki; próg wynosi zatem **co najmniej 75%** indywidualnego maksimum.
- Warunek ochrony pingwinka spełnia grupa, w której każda osoba osiąga swój próg. Wynik jednej osoby nie wyrównuje braków innej.
- Przykład: przy 20 zaplanowanych wykonaniach maksimum wynosi 200 punktów; zdobycie 150 punktów spełnia próg, a 140 — nie.
- Ta zasada zastępuje wcześniejszą propozycję dwóch dni wyrozumiałości w 14 dniach. Szczegóły rozliczania niepełnego tygodnia, tygodnia bez zadań, zmian harmonogramu i wpływu wyniku na wzrost wymagają ustalenia.

### Rozwój, choroba i powrót do zdrowia — uzgodnienia

- W zdrowej grupie próg **co najmniej 75% tygodniowego maksimum każdej osoby** wystarcza, aby pingwinek rósł i nie ucierpiał. Jeśli warunek nie jest spełniony, pingwinek choruje; dokładną zmianę jego wyglądu i tempa wzrostu trzeba jeszcze zaprojektować.
- Aby pingwinek wracał do zdrowia, przez cały kolejny tydzień **każdego dnia każda osoba musi uzyskać ponad 75% swojego dziennego maksimum**. Powrót do zdrowia jest stopniowy: im wyższy wynik, tym szybszy powrót. To inny próg niż w zwykłym rozliczeniu tygodnia: dla zdrowienia jest ściśle ponad 75% dziennie.
- Do ustalenia pozostaje konkretny wzór tempa zdrowienia, sposób traktowania dni bez zaplanowanych zadań i to, co dzieje się, gdy warunek zdrowienia zostanie w którymś dniu przerwany. Do czasu synchronizacji wynik grupy może być nieostateczny.

### Tydzień, dołączenie i zmiany

- Tydzień zaczyna się w poniedziałek o 00:00 i kończy w niedzielę o 23:59. Technicznie najlepiej rozliczać go od poniedziałku 00:00 włącznie do następnego poniedziałku 00:00 wyłącznie.
- Osoba dołączająca w trakcie tygodnia w pierwszym, niepełnym tygodniu może pomagać w rozwoju pingwinka, ale nie może mu zaszkodzić. Dokładny sposób uwzględnienia jej pozytywnego wkładu pozostaje do ustalenia.
- Zmiany celu lub harmonogramu obowiązują od poniedziałku o 00:00, aby nie zmieniać zasad w trakcie rozliczanego tygodnia. Strefa czasowa grupy oraz zasady spóźnionych wpisów wymagają ustalenia.

### Potwierdzenia i częściowe punkty

- Zdjęcia podsumowania snu i licznika kroków powinny zawierać datę. Trzeba ustalić obsługiwane formaty oraz postępowanie, gdy OCR nie odczyta daty lub wyniku.
- Dla snu dostępne jest również ręczne wpisanie liczby przespanych godzin albo godziny zaśnięcia i pobudki, ponieważ nie każdy mierzy sen urządzeniem. Taki wpis trzeba wyraźnie odróżnić od zdjęcia z OCR; szczegółowy sposób przyznawania punktów za wpis ręczny pozostaje do ustalenia.
- Czytanie poniżej wybranego celu daje mniej punktów, proporcjonalnie do zadeklarowanej liczby przeczytanych stron. Dla celu 10 stron i odczytanych 5 stron propozycja obliczenia daje 5 z 10 punktów. Sposób zaokrąglania oraz limit za wynik powyżej celu wymagają ustalenia. Zdjęcie jednej strony pozostaje dodatkowym potwierdzeniem, a nie dowodem liczby przeczytanych stron.

### Kolejny nawyk i integracje

- Po dwóch tygodniach aplikacja może zaproponować **trzy nawyki do wyboru**, dobrane do odpowiedzi z wywiadu. Przykłady wskazane przez zespół to ograniczenie lub rzucenie palenia oraz ograniczenie cukru; konkretne cele wymagają dalszego dopracowania i decyzji użytkownika. Użytkownik wybiera, czy zaakceptować propozycję.
- Health Connect to możliwe rozszerzenie, nie część pierwszej wersji. Podstawowa ścieżka pozostaje oparta na zdjęciach i OCR, z uzgodnioną możliwością ręcznego wpisania snu.

### Doprecyzowanie dziennego zdrowienia i dni odpoczynku

- Pingwinek zaczyna zdrowieć, gdy w ciągu jednego dnia każda osoba osiągnie ponad 75% swojego dziennego maksimum. Im wyższe wyniki, tym szybciej zdrowieje; dokładne tempo pozostaje do ustalenia.
- Według ostatniego ustalenia stan pingwinka pogarsza się, gdy choć jedna osoba osiąga mniej niż 75% dziennego maksimum. Trzeba doprecyzować, czy dotyczy to wszystkich dni, czy tylko okresu choroby/zdrowienia, oraz jak traktować dokładnie 75%; wcześniej uzgodniono również tygodniowy próg 75% i tolerancję potknięć.
- Dzień, w którym użytkownik nie ma zaplanowanych nawyków, jest dniem odpoczynku i uznajemy go za spełniony. Nie obliczamy dla niego procentu z zerowego maksimum.
- Za ręczny wpis czasu snu użytkownik otrzymuje tyle samo punktów, co za wynik potwierdzony zdjęciem. Aplikacja odróżnia źródło wpisu; pozostałe zasady naliczania ustalimy przy szczegółowym projekcie punktacji.
- Nowa zasada rozpoczęcia zdrowienia po jednym dniu doprecyzowuje poprzednią propozycję oczekiwania na cały kolejny tydzień; konieczność ciągłego tygodnia i warunek pełnego wyzdrowienia pozostają do uzgodnienia.

### Potwierdzone połączenie zasad zdrowia

- **Zdrowy pingwinek:** grupa jest rozliczana po całym tygodniu. Pingwinek nie choruje i może rosnąć, jeśli każda osoba osiągnęła co najmniej 75% swojego tygodniowego maksimum. Pojedynczy słabszy dzień nie szkodzi, jeśli tygodniowy próg został osiągnięty.
- **Chory pingwinek:** stan jest oceniany codziennie. Jeśli wszystkie osoby z zaplanowanymi zadaniami uzyskają ponad 75% swojego dziennego maksimum, pingwinek zdrowieje; im wyższe wyniki, tym szybciej. Jeśli choć jedna osoba uzyska poniżej 75%, stan się pogarsza. Jeśli żadna osoba nie jest poniżej 75%, ale co najmniej jedna osiąga dokładnie 75%, stan się nie pogarsza ani nie poprawia. Dni odpoczynku poszczególnych osób uznajemy za spełnione.
- Do ustalenia pozostają wzór tempa zdrowienia, poziom pełnego wyzdrowienia i zachowanie w dniu, w którym wszyscy odpoczywają. Wyniki oczekujące na synchronizację są oznaczone jako nieostateczne.

### Propozycja skali zdrowienia — do zatwierdzenia

Potwierdzona zasada: jeśli przez cały tydzień każdego dnia każda osoba przekracza 75% swojego dziennego maksimum, pingwinek wraca w pełni do zdrowia najpóźniej po tym tygodniu. Dni odpoczynku poszczególnych osób uważa się za spełnione.

Proponowany mechanizm:

- Stan chorego pingwinka przedstawia pasek zdrowia od **0 do 7**. Po zachorowaniu zaczyna się od 0; po osiągnięciu 7 pingwinek jest zdrowy. Pasek nie spada poniżej 0 i nie rośnie powyżej 7.
- W dniu, w którym wszystkie osoby z zaplanowanymi zadaniami przekraczają 75%, pasek wzrasta o 1. Jeśli wszystkie osiągną co najmniej 90%, wzrasta o 1,5. Wynik osoby w dniu odpoczynku nie ogranicza progu.
- Jeśli choć jedna osoba osiągnie mniej niż 75%, pasek spada o 1. Jeśli nikt nie jest poniżej 75%, ale ktoś osiąga dokładnie 75%, pasek się nie zmienia.
- Jeśli wszyscy mają dzień odpoczynku, proponuje się wzrost o 1: taki dzień jest spełniony i nie utrudnia wyzdrowienia w ciągu tygodnia. Wybór ten wymaga zatwierdzenia.
- Siedem spełnionych dni daje co najmniej 7 punktów zdrowia, więc pingwinek wyzdrowieje najpóźniej po tygodniu. Przy wyższych wynikach może wyzdrowieć wcześniej. Przykład: pięć dni z wynikami wszystkich co najmniej 90% daje 7,5 punktu, ograniczone do 7.
- W pierwszym niepełnym tygodniu nowy uczestnik może wnosić pozytywny wkład, ale jego niski wynik nie może pogarszać stanu pingwinka. Szczegółowy sposób uwzględniania jego wkładu oraz rozliczenia po synchronizacji wymagają doprecyzowania.

Próg 90%, wielkość zmian paska i zachowanie przy wspólnym dniu odpoczynku są propozycją, nie zatwierdzoną decyzją.

### Zatwierdzona skala zdrowia, śmierć i przypomnienia

- Zespół zatwierdził przedstawioną wyżej skalę 0–7, próg 90%, zmiany +1, +1,5 i −1 oraz +1 w dniu, w którym wszyscy odpoczywają. Zasady 75% i indywidualnych dni odpoczynku pozostają zgodne z poprzednią sekcją.
- Jeśli zdrowie pingwinka **utrzymuje się na poziomie 0 przez dwa tygodnie**, pingwinek umiera. Sposób naliczania 14 dni, w szczególności to, czy chwilowy wzrost ponad 0 zeruje licznik, wymaga doprecyzowania. Wynik oczekujący na synchronizację nie powinien być prezentowany jako ostateczny.
- Aplikacja **codziennie zachęca do wykonania nawyków**. Propozycja realizacji: przypomnienie lokalne o wybranej godzinie, z możliwością zmiany godziny lub wyłączenia oraz z uwzględnieniem dni odpoczynku. Dostępność powiadomień zależy od ustawień urządzenia i ewentualnej zgody użytkownika.
- Do decyzji pozostaje, co dzieje się po śmierci pingwinka: rozpoczęcie opieki nad nowym pingwinkiem, możliwość przywrócenia poprzedniego lub inna ścieżka; należy też ustalić zachowanie historii, punktów i grupy.

### Po osiągnięciu zera i rozpoczęcie od nowa — uzgodnienia

- Licznik dwóch tygodni zeruje się, gdy zdrowie pingwinka wzrośnie powyżej 0. Jeśli ponownie spadnie do 0, okres liczy się od nowa. Szczegółowy moment rozpoczęcia i zakończenia naliczania dni przy synchronizacji offline zostanie ustalony w projekcie technicznym.
- Po śmierci pingwinka grupa może rozpocząć opiekę nad nowym. Znajomi, grupa, nawyki i historia pozostają zachowane.
- Użytkownicy ponownie odpowiadają na pytania o swoje cele i nawyki; aplikacja proponuje im nieco łatwiejsze cele, które mogą przejrzeć. Przykład: zamiast 10 stron czytania proponuje 5 stron.
- Do doprecyzowania: dokładny sposób wyliczania łagodniejszych celów dla czytania, kroków i snu; czy użytkownik może je edytować przed zatwierdzeniem; zasady punktów i automatycznego wzrostu celu po rozpoczęciu od nowa. Cele snu wymagają osobnego podejścia, aby przypadkowo nie proponować ograniczania potrzebnego odpoczynku.

### Dolna granica celu snu

- Minimalny cel snu ustawiany lub proponowany w aplikacji wynosi **6 godzin**. Przy ponownym dopasowywaniu celów po śmierci pingwinka aplikacja nie proponuje niższego celu.
- Sześć godzin jest przyjętą granicą działania aplikacji, a nie indywidualną rekomendacją zdrowotną. Konkretne reguły proponowania wyższych celów pozostają do ustalenia.

### Korekta propozycji celu snu

Aplikacja proponuje cel snu wynoszący **6 godzin**; nie proponuje automatycznie wyższego celu. Zastępuje to wcześniejszą wzmiankę o ustaleniu sposobu proponowania wyższych celów. Możliwość samodzielnego ustawienia wyższego celu przez użytkownika pozostaje do potwierdzenia.

### Aktualizacja automatycznego celu snu

Aplikacja proponuje początkowo cel snu **6 godzin**, a następnie zwiększa go automatycznie o **30 minut tygodniowo**. To zastępuje poprzedni zapis, że aplikacja nie proponuje wyższego celu. Maksymalna wartość, możliwość ręcznej zmiany i zasady ponownego dopasowania po śmierci pingwinka pozostają do uzgodnienia.

### Cel snu — limit i odstępy między zmianami

- Cel początkowy: 6 godzin. Automatyczny wzrost: o 30 minut do maksymalnie 8 godzin; powyżej 8 godzin użytkownik może zwiększyć cel ręcznie.
- Odstęp między automatycznymi zmianami wydłuża się: pierwsza po 1 tygodniu, następna po kolejnych 2 tygodniach, następna po kolejnych 3 tygodniach itd. Przykładowo: 6 godzin od początku, 6,5 po 1 tygodniu, 7 po 3 tygodniach, 7,5 po 6 tygodniach i 8 po 10 tygodniach.
- Do ustalenia: wpływ ręcznej zmiany celu na licznik kolejnych automatycznych podwyżek oraz to, czy zmiany są niezależne od osiągania celu.

## 10. Zatwierdzone szczegóły punktacji i organizacji

Poniższe zasady zastępują sprzeczne lub niepełne propozycje zapisane wcześniej.

1. **Punkty częściowe:** nawyk daje maksymalnie 10 punktów. Wynik poniżej celu jest liczony proporcjonalnie i zaokrąglany do jednego miejsca po przecinku; ponad cel nie daje więcej niż 10 punktów. Przykład: 4 strony z celu 5 dają 8 punktów.
2. **Sen — wyjątek:** za mniej niż 5 godzin snu użytkownik otrzymuje 0 punktów. Przy co najmniej 5 godzinach wynik jest liczony proporcjonalnie do celu, maksymalnie do 10 punktów. Ta sama reguła dotyczy zdjęcia i ręcznego wpisu. Przy podaniu godziny zaśnięcia i pobudki aplikacja uwzględnia przejście przez północ.
3. **Ręczna zmiana celów:** zaczyna obowiązywać w najbliższy poniedziałek. Po ręcznym zwiększeniu celów czytania lub snu automatyczne zwiększenia liczone są od nowej wartości, z wcześniej ustalonymi limitami. Dla snu następny odstęp zaczyna się w dniu wejścia ręcznej zmiany w życie.
4. **Kroki:** aplikacja proponuje średnią z ankiety zaokrągloną do pełnych 500 kroków; jeśli użytkownik jej nie zna, proponuje 4000. Użytkownik może zmienić cel. W pierwszej wersji nie zwiększa się go automatycznie.
5. **Nowa osoba:** w pierwszym niepełnym tygodniu jej wynik jest widoczny, lecz nie jest wymagany do spełnienia progu grupy. Może pozytywnie wpływać na zdrowienie, ale słabszy wynik nie pogarsza stanu pingwinka. Od kolejnego poniedziałku obowiązują ją zwykłe zasady.
6. **Czwarty nawyk:** po 14 dniach aplikacja pokazuje trzy propozycje zależne od ankiety. Użytkownik wybiera jedną albo odkłada decyzję; po odłożeniu propozycja wraca za tydzień. Wybrany nawyk zaczyna obowiązywać od następnego poniedziałku.
7. **Nowy pingwinek:** po śmierci grupa i historia zostają, użytkownicy ponawiają wywiad. Proponowane łatwiejsze cele to 5 stron czytania, 75% poprzedniego celu kroków i 6 godzin snu. Użytkownik przegląda i może zmienić propozycje przed zatwierdzeniem.
8. **Czas i wpisy:** grupa wybiera strefę czasową przy utworzeniu. Wpis można dodać do końca następnego dnia; późniejsze korekty nie zmieniają automatycznie zamkniętego tygodnia. Wpis offline zachowuje datę wykonania i czeka na synchronizację; do tego czasu wynik grupy jest oznaczany jako oczekujący.
9. **Licznik śmierci:** 14 kolejnych zakończonych dni na poziomie 0; wzrost ponad 0 zeruje licznik. Ostateczne rozliczenie uwzględnia oczekujące wpisy po synchronizacji, aby sam brak sieci nie powodował śmierci pingwinka.
10. **Przypomnienia:** użytkownik wybiera godzinę codziennego przypomnienia i może je wyłączyć. W dniu odpoczynku może otrzymać łagodny komunikat o odpoczynku, z możliwością jego wyłączenia.

Wymaganie doprecyzowania technicznego: ustalić sposób kończenia oczekiwania na wpisy offline i obsługę opóźnionych synchronizacji, aby reguła końca następnego dnia działała przewidywalnie na wszystkich urządzeniach.

### Termin synchronizacji — nowe wymaganie

Jeśli użytkownik nie zsynchronizuje wyników do godziny **23:59**, jego wyniki nie są liczone. Należy ustalić, czy chodzi o 23:59 dnia wykonania nawyku, czy następnego dnia: wcześniejsze ustalenie dopuszczało dodanie wpisu do końca kolejnego dnia. Rozliczenie korzysta z uzgodnionej strefy czasowej grupy. Nie należy stosować wcześniejszego założenia o bezterminowym oczekiwaniu na wpisy offline.

### Termin wpisu i dodatkowy dzień — korekta

- Standardowo wpis dotyczący nawyku trzeba dodać i zsynchronizować **tego samego dnia do 23:59**, według strefy czasowej grupy. Wynik niezsynchronizowany w terminie nie jest liczony, z zastrzeżeniem możliwości wykupienia dodatkowego dnia.
- Istnieje możliwość wykupienia dodatkowego dnia za **14 dni streaka**. Do ustalenia: jak definiować streak, czy 14 dni jest odejmowane po zakupie, kiedy można wykupić przedłużenie i czy dodatkowy dzień dotyczy także synchronizacji.
- Zasada tego samego dnia zastępuje wcześniejszą propozycję zwykłego dodawania wpisów do końca następnego dnia. Sposób przeliczenia wyniku grupy po ewentualnym skorzystaniu z przedłużenia trzeba doprecyzować.

### Potwierdzenie przedłużenia

Wykupienie dodatkowego dnia kosztuje 14 dni streaka: po użyciu są one odejmowane. Przedłużenie daje czas do **23:59 następnego dnia**, w strefie czasowej grupy, zarówno na dodanie wpisu, jak i jego synchronizację. Definicja zdobywania streaka oraz moment, w którym można uruchomić przedłużenie, pozostają do ustalenia.

### Warunek streaka

Streak uprawniający do wykupienia dodatkowego dnia uzyskuje się po 14 dniach z wynikiem powyżej 75% punktów. Do doprecyzowania pozostaje, czy każdy z 14 dni musi być kolejny i przekraczać próg osobno, jak traktować dni odpoczynku oraz co się dzieje po dniu poniżej progu. Wydanie przedłużenia odejmuje 14 dni streaka.

### Potwierdzona zasada streaka

Streak wymaga **14 kolejnych dni** z wynikiem ponad 75% dziennego maksimum. Dzień odpoczynku podtrzymuje serię; dzień z wynikiem dokładnie 75% lub niższym ją przerywa. Wykupienie przedłużenia odejmuje 14 dni streaka. Pozostaje doprecyzować, czy dzień odpoczynku również zwiększa licznik 14 dni oraz kiedy najpóźniej można wykupić przedłużenie.

### Dzień odpoczynku a streak

Dzień odpoczynku zarówno podtrzymuje streak, jak i **zwiększa jego licznik o jeden dzień**. Zastępuje to wcześniejszą wzmiankę o nieustalonym sposobie liczenia dnia odpoczynku.

### Doprecyzowanie: przedłużenie i administratorzy

Przedłużenie za 14 dni streaka można wykupić do 23:59 następnego dnia; obejmuje wszystkie nawyki użytkownika z poprzedniego dnia. Rozliczenie grupy pozostaje nieostateczne do końca okresu przedłużenia. Grupa może mieć kilku administratorów zarządzających zaproszeniami.

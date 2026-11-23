#set page(paper: "a4", margin: (x: 20mm, y: 17mm), numbering: "1")
#set text(font: "Arial", size: 10pt, lang: "pl")
#set par(leading: 0.6em, justify: true)
#show heading.where(level: 1): set text(size: 17pt, fill: rgb("#173e60"))
#show heading.where(level: 2): set text(size: 11pt, fill: rgb("#176178"))
#set list(spacing: 0.25em)
= Milestone 6 — Weryfikacja zdjęć przez AI/ML
*Cel:* dodać użyteczną analizę zdjęcia i uczciwie opisać jej ograniczenia.

== Kroki
+ Wybierzcie gotowe *ML Kit Image Labeling* z modelem dołączonym do aplikacji. Sprawdźcie dokumentację wybranej wersji, zgodność z API 26, licencję, rozmiar i dostępne etykiety. Analiza lokalna ogranicza zależność od sieci i przesyłania zdjęć.
+ Dla każdego typu nawyku przypiszcie etykiety, które rzeczywiście pojawiają się na próbnych zdjęciach. Jeśli model nie rozpoznaje potrzebnych obiektów, zmieńcie zakres MVP albo dopiero wtedy rozważcie model własny.
+ Po otrzymaniu zdjęcia przygotujcie obraz zgodnie z wymaganiami API, uruchomcie klasyfikację poza blokującą pracą UI i pobierzcie etykiety z poziomami pewności. Zwolnijcie zasoby i usuńcie plik tymczasowy po zakończeniu.
+ Zaimplementujcie wynik pozytywny, negatywny, niepewny oraz błąd. Umożliwcie wykonanie zdjęcia ponownie; opisujcie wynik jako wykrycie obiektu, a nie dowód wykonania nawyku.
+ Zbierzcie osobne zdjęcia do doboru progu i do sprawdzenia: pozytywne i negatywne, różne tła i oświetlenie. Zapiszcie liczebność prób, trafienia, fałszywe akceptacje i fałszywe odrzucenia oraz czas analizy. Nie dobierajcie progu wyłącznie na pojedynczym zdjęciu.
+ Po pozytywnym wyniku zapiszcie wpis tylko raz i przekażcie go do synchronizacji. Sprawdźcie brak internetu, błąd modelu oraz ponowne naciśnięcie przycisku. Przygotujcie notatkę o ograniczeniach i wynikach.

== Narzędzia i dlaczego
*ML Kit:* gotowy model na urządzeniu bez własnego trenowania; własny model zwiększa nakład pracy i wymaga danych. Zwykły arkusz wystarczy do zapisania wyników prób i progu.

== Rezultat i kontrola
Zdjęcie przechodzi przez prawdziwy model, aplikacja obsługuje cztery wyniki, a zespół dysponuje zapisanymi testami i potrafi wyjaśnić błędy klasyfikacji.

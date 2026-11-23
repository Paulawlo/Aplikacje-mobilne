#set page(paper: "a4", margin: (x: 20mm, y: 17mm), numbering: "1")
#set text(font: "Arial", size: 10pt, lang: "pl")
#set par(leading: 0.6em, justify: true)
#show heading.where(level: 1): set text(size: 17pt, fill: rgb("#173e60"))
#show heading.where(level: 2): set text(size: 11pt, fill: rgb("#176178"))
#set list(spacing: 0.25em)
= Milestone 1 — Problem, wymagania i MVP
*Cel:* zamienić pomysł w mały, możliwy do sprawdzenia produkt.

== Kroki
+ Opiszcie jednego przykładowego użytkownika, jego trudność z utrzymaniem nawyku i to, jak współpraca ma pomóc. Zanotujcie założenia, których jeszcze nie potwierdziliście.
+ Rozpiszcie główny scenariusz: pierwsze uruchomienie, połączenie pary, dodanie nawyku, zdjęcie, wynik analizy i widok wspólnego postępu. Zaznaczcie, które działania wymagają internetu.
+ Spiszcie wymagania funkcjonalne: para i zaproszenie, nawyki, dzienne wpisy, analiza zdjęcia, historia i awatar. Dla każdego dopiszcie mierzalny warunek odbioru, np. „po restarcie lista nadal zawiera dodany nawyk”.
+ Spiszcie wymagania niefunkcjonalne: Android API 26+, SQLite, sprzęt, AI, dostępność danych po restarcie, obsługa błędów, dostęp tylko członków pary i czytelny UI.
+ Ustalcie zasady punktacji na konkretnych przykładach: strefa czasowa, wymagane nawyki w danym dniu, wynik obu osób, zmiana i usunięcie nawyku, puste dni oraz spóźniony wpis. Zapiszcie oczekiwane wyniki obliczeń.
+ Wybierzcie 2–3 typy zdjęć i wcześnie sprawdźcie, czy gotowy model zwraca użyteczne etykiety. Rozpoznanie butelki nie dowodzi wypicia wody. Jeśli próby zawodzą, zawęźcie typy nawyków przed dalszą implementacją.
+ Podzielcie wymagania na MVP i dodatki; uzgodnijcie z prowadzącym wszelkie niejasne wymagania.

== Narzędzia i dlaczego
- *Markdown lub arkusz:* wymagania i kryteria można łatwo przeglądać oraz powiązać z zadaniami.
- *Prosty prototyp ML Kit:* pozwala sprawdzić wykonalność zdjęć przed budową reszty aplikacji; wyników nie należy traktować jako dowodu prawdziwości czynności.

== Rezultat i kontrola
Lista wymagań i kryteriów, lista funkcji MVP, 2–3 przykłady punktacji oraz notatka z prób AI. Zespół potrafi wskazać, co zostanie zademonstrowane.

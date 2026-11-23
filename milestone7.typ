#set page(paper: "a4", margin: (x: 20mm, y: 17mm), numbering: "1")
#set text(font: "Arial", size: 10pt, lang: "pl")
#set par(leading: 0.6em, justify: true)
#show heading.where(level: 1): set text(size: 17pt, fill: rgb("#173e60"))
#show heading.where(level: 2): set text(size: 11pt, fill: rgb("#176178"))
#set list(spacing: 0.25em)
= Milestone 7 — Integracja, testy i stabilizacja
*Cel:* wykryć błędy przed oddaniem i uzyskać powtarzalną wersję demonstracyjną.

== Kroki
+ Przygotujcie tabelę: wymaganie, scenariusz, dane, oczekiwany wynik, rzeczywisty wynik, urządzenie i status. Najpierw wybierzcie testy obejmujące wszystkie funkcje MVP.
+ Testy jednostkowe Kotlin/JUnit: liczenie wyniku pary, granica dnia i strefa, zmiana harmonogramu, brak aktywnych nawyków, wielokrotny wpis oraz przykłady z M1.
+ Testy bazy: zapis i odczyt, ograniczenie unikalności, restart i migracje. W testach integracji sprawdźcie dwa konta, obce konto, ponowienia, konflikty i równoczesne wpisy. Firestore Emulator ułatwia sprawdzenie reguł; wykonajcie też próbę z rzeczywistą usługą.
+ Ręcznie przejdźcie pełny scenariusz na dwóch urządzeniach: połączenie pary, nawyki, zdjęcia, wynik AI, historia i awatar. Powtórzcie z wyłączoną siecią, po restarcie i po odzyskaniu połączenia.
+ Sprawdźcie API 26 oraz nowszą dostępną wersję Androida, brak aparatu lub anulowanie zdjęcia, mały ekran i większy tekst. Wyniki AI z M6 dołączcie do raportu.
+ Zapiszcie błędy z krokami odtworzenia i priorytetem. Naprawcie blokujące, powtórzcie odpowiednie testy, utwórzcie wersję release candidate i sprawdźcie czystą instalację.

== Narzędzia i dlaczego
*JUnit* szybko sprawdza logikę bez telefonu; *testy Android/Room* sprawdzają urządzenie i bazę; *Firestore Emulator* pozwala kontrolować scenariusze dostępu. Ręczny test dwóch urządzeń sprawdza realny przebieg.

== Rezultat i kontrola
Raport z wynikami i znanymi ograniczeniami, zamknięte błędy blokujące oraz wersja uruchamiana według instrukcji od czystej instalacji.

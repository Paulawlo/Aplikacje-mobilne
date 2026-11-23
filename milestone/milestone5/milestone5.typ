#set page(paper: "a4", margin: (x: 20mm, y: 17mm), numbering: "1")
#set text(font: "Arial", size: 10pt, lang: "pl")
#set par(leading: 0.6em, justify: true)
#show heading.where(level: 1): set text(size: 17pt, fill: rgb("#173e60"))
#show heading.where(level: 2): set text(size: 11pt, fill: rgb("#176178"))
#set list(spacing: 0.25em)
= Milestone 5 — SQLite, aparat i niezawodność
*Cel:* utrwalić dane, wykonać zdjęcie i bezpiecznie obsłużyć utratę połączenia.

== Kroki
+ Zaimplementujcie w Room encje, DAO i repozytorium dla nawyków, wpisów, wyników AI i statusu synchronizacji. Room używa SQLite i ogranicza ręczny kod SQL. Dodajcie ograniczenie unikalności dziennego wpisu.
+ Zapiszcie i odczytajcie dane po zamknięciu aplikacji oraz restarcie urządzenia. Ustalcie wersję schematu; przy późniejszych zmianach przygotujcie i sprawdźcie migracje bez utraty historii.
+ Do zdjęcia wykorzystajcie systemową aplikację aparatu przez `ActivityResultContracts.TakePicture`, tymczasowy plik i URI z FileProvider. To prostsze niż budowa własnego podglądu. Obsłużcie brak aparatu, anulowanie i błąd zapisu; usuńcie zdjęcie po analizie zgodnie z przyjętą polityką.
+ Zdecydujcie, które wpisy aplikacja przechowuje w Room jako oczekujące, a za co odpowiada cache Firestore. Unikajcie dwóch niezależnych kolejek dla tej samej operacji; wynik partnera bez sieci oznaczcie jako potencjalnie nieaktualny.
+ Po odzyskaniu połączenia ponówcie oczekujące operacje z tym samym identyfikatorem, oznaczcie potwierdzenie lub konflikt i pokażcie błąd. Transakcje Firestore wymagają internetu, więc nie ogłaszajcie ich sukcesu offline.
+ Sprawdźcie ponowienia, jednoczesne działania pary, restart w trakcie wysyłki i odrzucenie operacji przez reguły. Dokumentujcie wynik każdego scenariusza.

== Narzędzia i dlaczego
*Room/SQLite* spełnia wymóg trwałej lokalnej bazy; *systemowy aparat* wymaga mniej kodu niż CameraX; *Firestore* pomaga wymieniać dane, lecz nie zastępuje wymaganej lokalnej bazy.

== Rezultat i kontrola
Dane przetrwają restart, zdjęcie wraca do aplikacji, a oczekujące zmiany są widoczne i po synchronizacji nie tworzą duplikatów w testowanych przypadkach.

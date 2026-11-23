#set page(paper: "a4", margin: (x: 20mm, y: 17mm), numbering: "1")
#set text(font: "Arial", size: 10pt, lang: "pl")
#set par(leading: 0.6em, justify: true)
#show heading.where(level: 1): set text(size: 17pt, fill: rgb("#173e60"))
#show heading.where(level: 2): set text(size: 11pt, fill: rgb("#176178"))
#set list(spacing: 0.25em)
= Milestone 8 — Dokumentacja, demo i obrona
*Cel:* przekazać kompletny projekt i pokazać, że zespół rozumie decyzje i ograniczenia.

== Kroki
+ Przygotujcie dokumentację końcową: problem i użytkownik, wymagania funkcjonalne i niefunkcjonalne, zakres MVP, architektura i ADR, model danych, UI/UX, sprzęt, AI/ML, testy, ograniczenia oraz wkład członków.
+ Dodajcie 3–4 diagramy UML, np. przypadków użycia, klas/modelu, sekwencji zdjęcia i aktywności synchronizacji. Przygotujcie wymagane case studies; interpretację tego wymagania uzgodnijcie z prowadzącym.
+ Napiszcie instrukcję od zera: wymagane środowisko, konfiguracja Firebase i kont testowych, sposób dostarczenia konfiguracji bez sekretów, budowanie, uruchomienie, uprawnienia i kroki demonstracji. Poproście inną osobę o jej wykonanie.
+ Przygotujcie dwa urządzenia, działające konta i scenariusz: utworzenie pary, nawyki, zdjęcie, wynik AI i wspólny postęp. Pokażcie też niepewny wynik lub brak sieci; nagrajcie przebieg jako rezerwę.
+ Przećwiczcie krótką prezentację: problem, rozwiązanie, architektura, AI, wyniki testów i ograniczenia. Każda osoba powinna umieć wyjaśnić własny wkład oraz najważniejsze decyzje zespołu.
+ Sprawdźcie zgodność oddawanych plików i terminu z instrukcją prowadzącego. Przejrzyjcie kod z pomocą AI: zespół odpowiada za jego zrozumienie, weryfikację i testy.

== Narzędzia i dlaczego
*Markdown* nadaje się do instrukcji w repozytorium; *PlantUML, diagrams.net lub inne znane narzędzie* przyspiesza diagramy. Proste slajdy i nagranie pomagają w powtarzalnym demo.

== Rezultat i kontrola
Kompletna dokumentacja, instrukcja sprawdzona przez drugą osobę, przygotowane demo oraz zespół gotowy odpowiedzieć na pytania o działanie, testy i ograniczenia.

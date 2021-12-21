## Musterlösung für die Aufgabe "Die Weisen von o, Ω, ω und Θ"

[//]: # (Dauer: 40 min -> Studierende bekommen 3h Zeit)

Es gibt mehrere Notationen für asymptotisches Wachstum bzw. Effizienzklassen, die man allgemein als Landau-Symbole (nach Edmund Landau) bezeichnet, auch wenn Landau streng genommen nur die o- und die O-Notation verwendete.
Die O-Notation haben wir schon in der Vorlesung kennengelernt.
Ihre mathematische Definition lautet:

f ∈ O(g) genau dann wenn ∃ c > 0, ε > 0: ∀ x > ε |f(x)| ≤ c · g(x)

Die Definition der o-Notation lautet dagegen:

f ∈ o(g) genau dann wenn ∀ c > 0: ∃ ε > 0: ∀ x > ε |f(x)| < c · g(x)

Damit ist o(g) eine schärfere obere Schranke als O(g).
Ist eine Funktion in O(g), wächst sie "höchstens so schnell" wie g.
Ist eine Funktion aber in o(g), wächst sie definitiv "langsamer" als g.
Mann könnte noch etwas genauer sagen, dass die Funktion "asymptotisch vernachlässigbar gegenüber g" ist.

Die anderen Notationen lassen sich wie folgt auf o- und O-Notation zurückführen:

* f ∈ Ω(g) genau dann wenn g ∈ O(f)
* f ∈ ω(g) genau dann wenn g ∈ o(f)
* f ∈ Θ(g) genau dann wenn sowohl g ∈ O(f) als auch f ∈ O(g)

Damit ist Ω die Umkehrung von O und besagt, dass eine Funktion in Ω(g) mindestens so schnell wächst wie g.
ω ist entsprechend die Umkehrung von o und besagt, dass eine Funktion in ω(g) definitiv schneller wächst als g.
Θ ist eine Kombination aus einer oberen und einer unteren Schranke.
Hier kann man umgangssprachlich sagen, dass eine Funktion in Θ(g) genauso schnell wächst wie g.

Im normalen Sprachgebrauch wird zwar die O-Notation verwendet, aber die untere Schranke wird meistens mitgedacht.
Es wäre zum Beispiel korrekt zu sagen, dass die Laufzeit von Bubblesort in O(n³) liegt, weil jede Funktion in O(n²) auch in O(n³) oder jeder höheren Klasse enthalten ist.
Das ist jedoch irreführend, da die Laufzeit von Bubblesort eben nicht *genauso schnell* wächst wie n³, sondern wie n².
Korrekter wäre daher die Aussage "Die Laufzeit von Buublesort ist in Θ(n²).".
Aber vermutlich scheuen Informatiker eben zu sehr die schlimmen griechischen Buchstaben, selbst wenn sie von Donald Knuth stammen. 😉

Quellen:

* https://de.wikipedia.org/wiki/Landau-Symbole
* T.H. Cormen, C.E. Leiserson, R.L. Rivest und C. Stein, *Introduction to Algorithms*, 3. Ausgabe. Cambrige, MA: MIT Press, 2009.
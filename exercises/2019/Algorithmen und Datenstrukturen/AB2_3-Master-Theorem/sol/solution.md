## Musterlösung für die Aufgabe "Das Master-Theorem"

[//]: # (Dauer: 35 min -> Studierende bekommen 2:30h Zeit)

Das Master-Theorem betrifft die Laufzeit von rekursiven Algorithmen, die die folgende Form haben:

T(n) = aT(n/b) + f(n)

Dabei sind a und b ganzzahlige positive Konstanten und f(n) irgendeine Funktion.
T(n) beschreibt die Laufzeit des Algorithmus, wenn dieser das Problem in a Teilprobleme der größe n/b aufteilt.
Streng genommen müsste man hier noch unterscheiden ob n/b auf- oder abgerundet wird, aber das Master-Theorem gilt in beiden Fällen.
Die Funktion f(n) repräsentiert hier den Aufwand, der durch das Aufteilen der Probleme und das Zusammenfügen der Lösungen der Teilprobleme ensteht.

Das Master-Theorem gibt in bestimmten Fällen an, in welcher Effizienzklasse T(n) für konkrete a, b und f(n) liegt:

1. Falls f(n) in O(n^(log_b(a) - epsilon)) ist (für irgendein epsilon > 0), dann ist T(n) in Θ(n^(log_b(a)))
2. Falls f(n) in Θ(n^(log_b(a))) ist, dann ist T(n) in Θ(log(n) * n^(log_b(a)))
3. Falls f(n) in Ω(n^(log_b(a) + epsilon)) ist (für irgendein epsilon > 0), dann ist T(n) in Θ(f(n))

Im Endeffekt kann man also sagen, dass die wichtige Frage bei solchen Algorithmen ist, ob f(n) schneller wächst als n^log_b(a) oder nicht.
Wächst f(n) schneller, dominiert die Laufzeit von f(n) auch T(n). Wächst es aber langsamer, dominiert der Ausdruck n^log_b(a) - eventuell mit einem zusätzlichen log(n) davor.

Die "Mastermethode" ist die Anwendung des Master-Theorems, um die Laufzeit eines bestimmten Algorithmus zu bestimmen.
Der Algorithmus Mergesort teilt zum Beispiel das Problem eine ganze Liste der Länge n zu sortieren in zwei Teilprobleme (a = 2), in denen jeweils eine Liste der Länge n/2 sortiert werden muss (b = 2).
f(n) beschreibt hier den Aufwand, die Listen zu Teilen und die sortierten Listen wieder Zusammenfügen, was in O(n) - bzw. genauer in Θ(n) möglich ist.
Für die Anwendung des Master-Theorems müssen wir nun log_b(a) bestimmen.
In unserem Fall ist das log_2(2) = 1.

Die Frage ist also, ob f(n) in einer der folgenden drei Laufzeitklassen ist:

1. O(n^(1 - epsilon))
2. Θ(n)
3. Ω(n^(1 + epsilon))

Wie wir eben schon festgestellt haben, trifft Fall 2 zu.
Wir wissen also dank dem Master-Theorem, dass die Laufzeit T(n) von Mergesort in Θ(n * log n) liegt.

Quellen:

* T.H. Cormen, C.E. Leiserson, R.L. Rivest und C. Stein, *Introduction to Algorithms*, 3. Ausgabe. Cambrige, MA: MIT Press, 2009.
* https://de.wikipedia.org/wiki/Master-Theorem (eigentlich nur, um zu schauen, wie das Master-Theorem im Deutschen bezeichnet wird 😉)
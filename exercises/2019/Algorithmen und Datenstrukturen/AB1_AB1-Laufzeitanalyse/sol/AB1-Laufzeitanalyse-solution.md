# Laufzeitanalyse

[//]: # (Dauer: ca 20 Min (2 XP))

## Lösungen

### Aufgabe 1

 Es wird für alle Zahlen `i` zwischen `2` und `n` geprüft, ob `i` `n` teilt.
 Das ist eine Laufzeitkomplexität von O(n).

### Aufgabe 2

Für alle natürliche Zahlen zwischen `start` und `end`
wird der Algorithmus `isPrime` aufgerufen. Dieser hat eine Laufzeitkomplexität
von O(n). Daraus folgt eine Laufzeitkomplexität von O(n) * O(n) = O(n^2).

### Aufgabe 3

Dieser Algorithmus hat einen Konstanten Laufzeitaufwand,
also O(1).

### Aufgabe 4

Laufzeitaufwand zum Iterieren durch die Permutationen: O(n!)
Laufzeitaufwand für die Überprüfung ob eine Permutation sortiert ist: O(n)
Gesamtlaufzeitaufwand: O(n!) * O(n) = O(n*n!)

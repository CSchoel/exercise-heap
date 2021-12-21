---
title: AB1-Laufzeitanalyse
author:
    - AuD-Tutoren
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 2
    - major: computer science
    - institution: Technische Hochschule Mittelhessen
    - course: Algorithmen und Datenstrukturen
lang: de-DE
solution-size: 0
---

## Laufzeitanalyse

 Im folgenden sind einige Algorithmen in Pseudocode gegeben. Bestimmen Sie die möglichst enge, obere Grenze der Laufzeiten und geben Sie diese in der O-Notation an. Begründen Sie außerdem Ihre Entscheidung in 2-3 Sätzen.

### Aufgabe 1.1 - sit numerus primis

Beschreibung: Algorithmus, der prüft ob eine natürliche Zahl `n` eine Primzahl ist.

```
algorithm isPrime(n: int):
  if n < 2 then
    return false

  if n == 2 then
    return true

  for i := 2, 3, .. n - 1
    // i ist ein Teiler von n
    if n % i == 0 then
      return false

  return true
```

### Aufgabe 1.2 - omnia primis

Beschreibung: Algorithmus, der alle Primzahlen in einem angegebenen Bereich der natürlichen Zahlen mithilfe des in 1) genannten Algorithmus `isPrime` bestimmt.

```
algorithm primesInRange(start: int, end: int):
  result = []
  for i := start, ..., end
    if isPrime(i) then
      result.add(i)
  return result
```

### Aufgabe 1.3 - numerus quadratum

Beschreibung: Algorithmus, der eine natürliche Zahl `n` quadriert.

```
algorithm square(n: int):
  return n * n
```

### Aufgabe 1.4 - combinatoris sortere

Beschreibung: Algorithmus, der eine Liste aus Zahlen sortiert. Die Liste wird sortiert, indem für jede Permutation der Liste geprüft wird, ob diese aufsteigent sortiert ist. Ist die entsprechende Permutation sortiert, wird diese zurückgegeben.

```
algorithm isSorted(list: [int])
  for i := 1, ..., list.length() - 1
    if list.get(i - 1) > list.get(i) then
      return false

  return true
```

```
algorithm permutationSort(list: [int])
  for each permut from permutations(list)
    if isSorted(permut) then
      return permut
```

Wobei es eine Funktion `permutations(list: [int]): [[int]]` gibt, die alle Permutationen einer Liste erzeugt. Zur Vereinfachung soll angenommen werden, dass die Komplexität des Aufrufs von `permutations(list)` O(1) ist.

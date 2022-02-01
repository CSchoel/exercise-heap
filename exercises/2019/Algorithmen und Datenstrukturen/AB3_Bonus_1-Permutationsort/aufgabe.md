---
title: aufgabe
author:
    - AuD-Tutoren
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 2
    - major: computer science
    - institution: Technische Hochschule Mittelhessen
    - course: Algorithmen und Datenstrukturen
    - teaches: big O notation
    - requires: loops
    - requires: functions
    - submission: code
    - references: 2f66f9c6-d484-48b2-9417-dcd5f31472ff
lang: de-DE
solution-size: 80
id: 609ca7ef-43b0-4ea0-a60b-1a44582b6a03
---

## Permutationsort

Implementieren Sie den Sortieralgorithmus `Permutationsort`, der Aufgabe  `Laufzeitanalyse`, von `AB1`.

Dem Algorithmus soll eine Liste aus Zahlen übergeben werden. Daraufhin überprüft er jede Permutation der Liste, ob sie aufsteigend sortiert ist und gibt die entsprechende Permutation zurück.

### Hinweise
- > Es dürfen keine Sortieralgorithmen verwendet werden, es muss durch die Permutationen die richtig sortierte Liste gefunden werden!

Der Sortieralgorithmus muss in der Klasse `PermutationSort` im Package `permutationsort` stehen und folgende Signatur haben:

```java
public static void permutationSort(List<Integer> lst)
```

Dieser Pseudocode dient Ihnen als Hilfe:

```
algorithm isSorted(list: List<Integer>)
  for i := 1, 2, ..., list.size - 1
    if list.get(i-1) > list.get(i) then
      return false
  return true
```

```
algorithm permutationSort(list: List<Integer>)
  for permutation from permutations(list)
    if isSorted(permut) then
      list := permut
```

```
algorithm permutations(list: List<Integer>): List<List<Integer>>
  List<List<Integer>> lst := ArrayList<List<Integer>>.new()
  if lst.size <= 1 then
    permutations.add(lst)
  else
    List<Integer> list := ArrayList<Integer>.new(lst)
    int last := list.get(list.size-1)
    List<Integer> rest := list.fromTo(0, list.size-1)
    for permut from permutations(rest)
      for i := 0, 1, ..., permut.size - 1
        List<Integer> permutation = ArrayList<>.new()
        permutation.add(permut)
        permutation.add(i, last)
        permutations.add(permutation)
  return permutations
```
Der obige Pseudocode soll Ihnen nur helfen. Sie müssen den Algorithmus nicht genauso implementieren.

#### Achtung:

Der Algorithmus `permutations` ist in O(n!).
Bei großen Listen ist daher schnell der Arbeitsspeicher überfordert.
Das ist bei dieser Aufgabe erwünscht, achten Sie aber darauf, Ihre Lösung nicht mit zu großen Listen zu testen.

Bspw. werden für eine Liste mit 7 Elementen schon 7! = 5040 Permutationen erzeugt!

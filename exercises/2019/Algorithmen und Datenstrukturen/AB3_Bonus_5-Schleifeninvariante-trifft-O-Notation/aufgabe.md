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
    - requires: loop invariant
    - teaches: loop invariant
    - teaches: proof
    - submission: proof
    - submission: pseudocode
    - teaches: big O notation
    - teaches: algorithm design
lang: de-DE
solution-size: 30
id: 2892411e-afd9-4bc0-b24e-561bd1d50cd1
---

# Schleifeninvariante trifft O-Notation

## Aufgabe 1: Schleifeninvariante auf Korrektheit prüfen

Folgend erhalten Sie eine Schleifeninvariante und einen Algorithmus in Pseudocode. Bitte prüfen Sie die Schleifeninvariante auf Korrektheit. 
Es muss vollständige Induktion angewendet werden.

Schleifeninvariante: prod_j = a[1] · a[2] · ... · a[j] = ∏<sup>j</sup><sub>k = 1</sub> a[k]

#### Pseudocode:

```
algorithm partialProd ( a[1..n]: int[]):
  p[1..n] (:= Array der Länge n)
  int i := 1
  while (i <= n)
    int prod := 1
    int j := 1
    while (j <= i)
      prod := prod · a[j]
      j := j + 1
    p[i] := prod
    i := i + 1
  return p
```

## Aufgabe 2: Groß-O-Einschätzung und Optimierung

### Aufgabe 2.1:
Bitte geben Sie zum o.g. Algorithmus die Laufzeit in Groß-O-Notation an. Hierbei gilt wie üblich die möglichst enge obere Schranke.

### Aufgabe 2.2:
Bitte formulieren Sie den Algorithmus in Pseudocode so um, dass er eine Laufzeit von O(n) aufweist.

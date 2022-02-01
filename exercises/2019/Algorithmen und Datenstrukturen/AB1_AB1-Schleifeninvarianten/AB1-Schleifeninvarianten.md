---
title: AB1-Schleifeninvarianten
author:
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 2
    - major: computer science
    - institution: Technische Hochschule Mittelhessen
    - course: Algorithmen und Datenstrukturen
    - requires: loop invariant
    - submission: proof
    - submission: text
    - teaches: proof
    - teaches: research
    - teaches: loop invariant
    - approved: Christopher Schölzel
lang: de-DE
solution-size: 10
id: 01357edc-1219-4ca6-bb7c-5c45935f121f
---

## Schleifeninvarianten

Thema der Aufgabe sind Schleifeninvarianten und ihre Geltungsbereiche.
Sehen Sie sich den folgenden Pseudocode zum Algorithmus `doSomething` genau an:

```
algorithm doSomething (a, b ∈ ℕ ):
  q := 0
  r := a
  while r >= b
    q = q + 1
    r = r - b
  return r

```

Schleifeninvariante: `q * b + r = a`

### Aufgabe 1: Der Algorithmus

Was macht der Algorithmus?
Warum ist die Schleifeninvariante sinnvoll?

### Aufgabe 2: Der Beweis
Beweisen Sie, dass diese Schleifeninvariante für den Pseudocodealgorithmus `doSomething` gilt.

__Hinweis:__
> Prüfen Sie die Gültigkeit der Schleifeninvariante vor dem Ersten, vor dem i-ten (i-1) sowie zum i-ten Schleifendurchlauf.

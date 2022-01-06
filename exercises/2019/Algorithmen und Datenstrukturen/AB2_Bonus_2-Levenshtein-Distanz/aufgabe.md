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
lang: de-DE
solution-size: 0
id: 20cc1f8a-f10b-4e51-9335-ff8247e6b88b
---

# Levenshtein-Distanz

Die Levenshtein-Distanz (auch Edit-Distanz) beschreibt, um wie viele Zeichen sich zwei Worte unterscheiden. Dazu wird eine Matrix aufgespannt, die buchstabenweise alle Teilwörter gegenüberstellt.

Jede Zelle dieser Matrix beschreibt, wie viele Änderungen man von einem Teilwort des ersten Wortes vornehmen müsste, um ein Teilwort des zweiten Wortes zu erreichen. Dies wird als Distanz bezeichnet. Die Levenshtein-Distanz zwischen zwei Wörtern ist die Anzahl der Schritte, die benötigt werden, um vom kompletten ersten Wort auf das zweite Wort zu kommen. Dies ist aus der Matrix ablesbar.

Schreiben sie ein Programm, das die Distanzen zwischen Wörtern aus einer Eingabemenge berechnen kann.

### Aufgabe:

Sie erhalten eine Eingabe, die aus einer beliebigen Anzahl an Zeilen besteht, in denen jeweils zwei Wörter stehen. Die Wörter sind durch Semikola getrennt. Schreiben sie ein Programm, dass die Levenshtein-Distanz implementiert.

Ihre Ausgabe muss die gleiche Anzahl an Zeilen beinhalten, wobei in jeder Zeile die Levenshtein-Distanz zwischen den dazugehörigen Wörtern aus der Eingabe steht.

### Hinweise:

- Es gelten die üblichen Vorgaben für IO-Aufgaben.
- Groß- und Kleinschreibung werden nicht beachtet (d.h. "Hallo" und "hallo" sind gleich).
- Es gibt nur Buchstaben aus dem ASCII-Zeichensatz und keine Sonderzeichen.
- Die Nutzung von Vorgefertigten Implementationen der Levenshtein-Distanz (z.B. Bibliotheksfunktionen) ist natürlich nicht gestattet.
- Die Ausgabezeilen haben die gleiche Reihenfolge, wie die Eingabezeilen.

### Beispiel:

Input:

```
Hallo;Holla
Hallo;hallo
Welt;Elt
Levenshtein;Meilenstein
Algomantik;Algorithmik
```

Output:

```
2
0
1
4
5
```

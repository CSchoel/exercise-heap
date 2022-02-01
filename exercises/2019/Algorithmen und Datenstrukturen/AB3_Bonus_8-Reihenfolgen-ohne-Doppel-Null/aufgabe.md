---
title: Reihenfolgen ohne Doppel-Null
author:
    - AuD-Tutoren
    - Christopher Schölzel
keywords:
    - language: any
    - semester: 2
    - major: computer science
    - institution: Technische Hochschule Mittelhessen
    - course: Algorithmen und Datenstrukturen
    - requires: algorithm design
    - teaches: algorithm design
    - requires: recursion
    - requires: functions
    - submission: code
    - submission: program output
lang: de-DE
solution-size: 19
id: fafbad35-fe8c-44f1-9fe0-d06581ea3bb7
---

### Aufgabenstellung

Schreiben Sie eine rekursive Funktion `f(a, b)` in der von Ihnen gewählten Programmiersprache. Diese soll die **Anzahl** der *erlaubten* Reihenfolgen für angegebene `a` (die Anzahl von Nullen) und `b` (die Anzahl von Einsen) zurückliefern.
Die gesuchten Reihenfolgen bestehen aus Nullen und Einsen. Zwei aufeinanderfolgende Nullen sind in diesen Reihenfolgen nicht erlaubt. 

**Beispiele erlaubter Reihenfolgen:**  

- `11111`
- `1`
- `0`
- `1010`
- `0111`
- ...

**Beispiele nicht erlaubter Reihenfolgen:**  

- `00000`
- `00`
- `1001`
- `10100`
- ...

Die Reihenfolge `10100` beispielsweise ist nicht erlaubt, da sie am Ende zwei direkt aufeinanderfolgende Nullen enthält.

`a` und `b` werden von uns generiert. Ihr Input könnte z.B. so aussehen:

```
12;20
15;17
12;19
```

`a` und `b` werden durch ein `;` getrennt angezeigt. Die erste Zahl ist `a` und die zweite `b`.

Ihre Antwort sollte dann wie folgt aussehen:

```
293930
816
125970
```

#### Hinweise

* Geben Sie Ihren Code mit ab. Die Quelldatei reicht hierbei.
* Achten Sie darauf, dass die Anzahl der Zeilen des von uns generierten Inputs mit der Anzahl der Zeilen Ihrer Ausgabe übereinstimmt. In jeder Zeile sollte genau eine Zahl stehen.
* Zeichnen Sie einen Binärbaum, in dem jede Kante 0 oder 1 entspricht (jeder Knoten stellt eine Reihenfolge dar). Was stellen die Blätter, deren Weg von der Wurzel `a` Null-Kanten und `b` Eins-Kanten enthält, dar? Dies dient nur als Hilfestellung und ist nicht Teil der Abgabe.
* Schauen wir ein anderes Beispiel an: `a = 1, b = 2`, die Länge der gesuchten Reihenfolgen ist also `3`. An der ersten Stelle der Reihenfolge kann entweder Null oder Eins stehen. Der Rest der Reihenfolge hat die Länge `2` und kann als ein Problem mit den Parametern `a = 0, b = 2` bzw. `a = 1, b = 1` betrachtet werden. Auf diese Weise wird die Aufgabe in zwei einfacheren Aufgaben zerlegt, die man durch Rekursion implementieren kann.

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
    - requires: arrays
    - requires: array list
    - requires: two-dimensional arrays
    - requires: functions
    - requires: classes
    - requires: backtracking
    - teaches: backtracking
    - requires: algorithm design
    - teaches: algorithm design
    - submission: code
lang: de-DE
solution-size: 60
id: 426393a7-375c-4c3e-98ed-f0fb78dc4186
---

# Damenproblem

Beim (n-)Damenproblem geht es darum, eine bestimmte Anzahl Damen auf einem Schachfeld bestimmter Größe zu positionieren, dass sie sich nicht gegenseitig schlagen könnten. Es ist ein klassisches Beispiel für ein Problem, das sich relativ einfach mit Hilfe von Backtracking lösen lässt.

## Aufgabe:

Schreiben Sie eine Methode `public static List<Coordinate> place(int nDamen, int nSize)`. Diese Methode erhält die Anzahl (`nDamen`) an Figuren (Damen) und die Seitenlänge des quadratischen Spielfeldes (`nSize`). Die Methode gibt eine Liste von `Coordinate`-Objekten (s.u.) zurück, die die Koordinaten aller platzierten Figuren enthält.

Schreiben sie zusätzlich die Hilfsfunktion `public static boolean canPlace(int[][] field, Coordinate position)`. Diese Funktion erhält ein Spielfeld als 2D-Array (`field`) und die Position, an der eine Figur platziert werden soll (`position`). Sie gibt einen boolean zurück, der besagt, ob sich die Figur an der Stelle platzieren lässt. Auf dem Spielfeld gilt eine Position als besetzt, wenn der Wert an dieser Stelle größer als `0` ist.

## Formalia:

- Die Methoden `place` und `canPlace` sind Teil der Klasse `Damenproblem` im Package `damenproblem`.
- Nutzen Sie für Ihre Lösung Backtracking.
- Kann keine Lösung gefunden werden, gibt `place()` eine leere Liste zurück.
- Für die Spielfiguren (Damen) gelten die normalen Bewegungsregeln für Damen im Schach: Sie können sich beliebig weit horizontal, Vertikal und Diagonal auf dem Feld bewegen.

### Codevorgabe

Die Klasse `Coordinate` ist vorgegeben:

```java
package damenproblem;

import java.util.Objects;

public class Coordinate {
    public final int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("{%d, %d}", x, y);
    }
}
```

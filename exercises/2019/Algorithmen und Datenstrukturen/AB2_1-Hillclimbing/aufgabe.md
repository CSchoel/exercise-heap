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
    - teaches: greed
    - requires: algorithm design
    - requires: arrays
    - requires: classes
    - requires: list
    - submission: code
lang: de-DE
solution-size: 70
id: d9d73143-a351-4631-8046-2aaaa3d6ec67
---

# Hillclimbing

Schreiben Sie eine Methode, die einen gierigen Algorithmus zum Hill Climbing implementiert: Gegeben ist eine 2D-Karte (2D-Array) mit Höhenlevels. Der Algorithmus startet an einem beliebigen Punkt auf dieser Karte und soll den "Gipfel" erklimmen. Der Algorithmus darf in jedem Schritt nur die vier benachbarten Felder betrachten (D-Nachbarschaft). In jedem Schritt muss der Algorithmus den höchsten Nachbarn wählen und sich auf diesen fortbewegen, wenn er höher ist als die aktuelle Position (wenn es auf diese Art nicht weitergeht ist der Algorithmus fertig).

Nutzen Sie einen einfachen Listener, um die Schritte des Algorithmus nachzuverfolgen. Dieser besteht hauptsächlich aus einer Callback-Methode, die in jedem Schritt gerufen wird.


#### Hinweise:
> - In der .jar mit den Unit-Tests finden Sie eine Methode, mit der Sie Karten generieren können.
> - Die Schnittstellen der zu implementierenden Klassen (siehe unten) sind mit Javadoc-Kommentaren versehen. Nutzen Sie diese als informelle Richtlinie.


Folgende Formalia sollen eingehalten werden:
- Implementieren Sie die Methode `climb(...)` aus der Klasse `Hillclimber` (siehe Codevorgaben).
- Implementieren Sie die Methoden `climbCallback(...)` und `getPath()` der Klasse `ClimbListener`.
- Für jeden Schritt den der Algorithmus geht muss genau einmal `ClimbListener.climbCallback(...)` aufgerufen werden.
- Wenn die `climb(...)` Methode durchgelaufen ist, muss die von `getPath()` zurückgegebene Liste alle durchlaufenen Koordinaten enthalten (inklusive Start- und Endpunkt).
- Die beiden zu implementierenden Klassen müssen im package `hillclimbing` liegen.
- Bei gleichwertigen benachbarten Feldern ist es Ihnen überlassen, welches Sie wählen. Ihre Entscheidung sollte nur konsistent sein.


Die Skelette der beiden zu implementierenden Klassen sehen so aus:

```java
public class Hillclimber {

    private int[][] hill;

    public Hillclimber(int[][] hill) {
        this.hill = hill;
    }

    /**
     * Implements a greedy algorithm to "climb" a 2d-array with height levels.
     *
     * @param start         the starting point
     * @param climbListener a listener whose climbCallback method is called for each position the climbing algorithm is on
     * @return the top of the hill
     */
    public Coordinate climb(Coordinate start, ClimbListener climbListener) {
        return null;
    }
}
```

```java
public class ClimbListener {

    /**
     * Returns all positions stored by the climbCallback method. The output is sorted chronologically by the time of insertion.
     *
     * @return the list of positions
     */
    public List<Coordinate> getPath() {
        return null;
    }

    /**
     * To be used in the hillclimbing exercise. This function must be called for each step the solving algorithm takes.
     * The argument is stored in an internal datastructure that can be read by using the getPath() method.
     *
     * @param newPosition the position to store
     */
    public void climbCallback(Coordinate newPosition) {
    }
}
```
Die Klasse `Coordinate` ist bereits implementiert, Sie müssen sie nur benutzen:

```java
package hillclimbing;

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
}

```

---
title: AB5-Bonus-HashCode-klar
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
id: 2391e47b-a562-450a-8c57-5e5d4141b1c9
---

## HashCode

Erstellen Sie die folgenden drei Klassen und implementieren Sie für jede davon die Methoden `toString`, `equals` und `hashCode`:

### Klasse 1
* Ein `Tile` wird mit einem Konstruktor erstellt, der die folgenden Parameter hat:
  * Einen enum `Tile.Type`, der die Werte `LAND`, `WATER` oder `ROCK` annehmen kann.
  * Einen `String`, der die Region beschreibt in der die Kachel sich befindet.
  * Die x- und die y-Koordinate als `short`. Sie können Annehmen, dass die übergebenen Werte nie größer sein werden als `10000`.

    Zwei `Tile`-Objekte sollten gleich sein, wenn sie die gleiche Region und die gleichen Koordinaten haben.
    Der `Tile.Type` ist dabei egal.

    Die String-Darstellung folgt dem Schema `T(x,y) in Region`, wobei `T` der erste Buchstabe des Typs ist (`L`, `W` oder `R`), `x` und `y` die x- bzw. y-Koordinaten und `Region` der String, der die Region beschreibt.
### Klasse 2
* Ein `Interval` wird mit einem Konstruktor mit den folgenden Parametern erstellt:
  * Zwei `double`s für die untere und obere Grenze des Intervalls.
  * Zwei `booleans`, die bestimmen ob die unter bzw. obere Grenze offen (`true`) oder geschlossen (`false`) ist.

    Zwei `Interval`-Objekte sind gleich, wenn alle vier der oben genannten Parameter gleich sind.

    Die String-Darstellung folgt dem Schema `[min, max]`, wobei `min` die untere und `max` die obere Grenze ist.
    Bei offenen Grenzen werden die Eckigen Klammern `[]` durch runde Klammern `()` ersetzt. Ein halboffenes Intervall, könnte also z.b. so aussehen: `(0.0, 1.4]`.
### Klasse 3
* Ein `Gene` wird mit einem Konstruktor erstellt, der als einzigen Parameter nur einen String übernimmt, der nur aus den Buchstaben `ACGT` (groß oder klein geschrieben) besteht.

    Zwei `Gene`-Objekte sind gleich, wenn ihre Sequenz-Strings gleich sind (unabhängig von der Groß-/Kleinschreibung) oder wenn die eine Sequenz das *Komplement* der anderen darstellt.

    In einem Komplement werden alle Buchstaben nach dem folgenden Schema ersetzt:

    * `A` -> `T`
    * `T` -> `A`
    * `C` -> `G`
    * `G` -> `C`

#### Hinweis: 
**Achtung:** Denken Sie daran, dass die Implementierungen von `equals` und `hashCode` zusammen passen müssen. Versuchen Sie außerdem eine `hashCode`-Implementierung zu finden, die möglichst wenige Kollisionen erzeugt.
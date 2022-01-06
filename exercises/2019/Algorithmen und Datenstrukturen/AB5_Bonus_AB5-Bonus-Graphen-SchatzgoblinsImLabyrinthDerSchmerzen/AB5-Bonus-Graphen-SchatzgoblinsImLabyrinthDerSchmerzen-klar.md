---
title: AB5-Bonus-Graphen-SchatzgoblinsImLabyrinthDerSchmerzen-klar
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
id: 6958dd15-e1fd-4733-88de-8bcc0fe2fef1
---

## Durchsuchung der THM
Sie bekommen von uns Labyrinthe in Form von Graphen vorgegeben. Ihre Aufgabe besteht darin, eine Liste aller Räume auszugeben, welche maximal n Schritte vom Startknoten entfernt sind.

Überlegen Sie sich einen Algorithmus, welcher diese Aufgabe erfüllen kann und implementieren Sie diesen in der Methode `findeDenKommilitonen` in der Klasse `KommilitoneSuche`. Die Methode übernimmt das Labyrinth, die maximale Schrittweite und liefert eine Liste mit den Raumnummern zurück.

Für den besseren Einstieg erhalten Sie Java-Code als Vorgabe zum Herunterladen. Diese finden Sie in den Tests.

Um den Sachverhalt zu verdeutlichen, hier ein Ausschnitt des Labyrinths und die Darstellung dieses als Graph:

![Labyrinth_klein](https://homepages.thm.de/~cslz90/kurse/ad17/static/Labyrinth_klein.png)

### Hinweise: 
 * In der Liste dürfen keine Räume doppelt enthalten sein
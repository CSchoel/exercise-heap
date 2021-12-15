---
title: Bewegung erzeugen
author:
    - Christopher Schölzel
keywords:
    - processing
    - schoolyear-5
    - computer science
    - Technische Hochschule Mittelhessen
    - course-Girl's Day
lang: de-DE
solution-size: 10
source: https://git.thm.de/cslz90/gd-cs
---

# Bewegung erzeugen

Nutze die `setup()` und `draw()` methoden von Processing, um dein Bild aus der [vorherigen Aufgabe](../02_processing_intro/processing_intro.md) zu einer Animation zu machen, die sich langsam über den Bildschirm bewegt.

*Hinweis: Du musst dazu nur deinen geschriebenen Kode an der richtigen Stelle in das unten stehende Codestück einfügen.*

```processing
float x = 0;
void setup() {
    size(800, 600);
}
void draw() {
    x = x + 1;
    translate(x, height/2.0);
    // hier den Code für dein Bild einfügen
}
```
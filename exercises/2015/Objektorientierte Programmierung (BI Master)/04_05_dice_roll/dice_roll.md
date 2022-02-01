---
title: Würfelwurf
author:
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 1
    - major: bioinformatics
    - institution: Technische Hochschule Mittelhessen
    - institution: Justus-Liebig-Universität
    - course: Objektorientierte Programmierung
    - teaches: functions
    - teaches: pseudorandom numbers
    - requires: arithmetic operators
    - submission: code
lang: de-DE
solution-size: 5
source: https://git.thm.de/cslz90/bimoop-cs
id: 33c397fb-251b-4539-93d8-c63e1e6af328
---

# Würfelwurf

Schreiben Sie eine statische Methode `rollDice(int, int)`, wobei ein Aufruf von `rollDice(x,y)` die Augensumme bei einem simulierten Würfelwurf mit `x` `y`-seitigen Würfeln berechnet.

*Hinweis: Zufallszahlen können Sie z.B. mit der Klasse Random wie folgt erzeugen:*

```java
Random r = new Random();
int x = r.nextInt(3); //entweder 0, 1, oder 2
```

---
title: Farben als Integer (Kodierung)
author:
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 1
    - major: computer science
    - subject: bitwise operators
    - subject: computer graphics
    - previous: d948fedb-eec4-4685-8036-23eceac4bcd9
lang: de-DE
solution-size: 10
id: 63727dd0-a1e2-422f-86e6-dd6f56a78d0c
---

In der [letzten Aufgabe](exheap://d948fedb-eec4-4685-8036-23eceac4bcd9) haben Sie aus Farbwerte, die als `int` im [ARGB32](https://en.wikipedia.org/wiki/RGBA_color_model#ARGB32)-Format kodiert waren die einzelnen Farbkanäle extrahiert.

In dieser Aufgabe sollen Sie genau die entgegengesetzte Richtung der Konvertierung programmieren:
Gegeben sind die Werte der Farbkanäle zwischen 0 und 255 in den `int`-Variablen `r`, `g`, und `b`, gesucht ist ein `int`-Wert, dessen erstes Byte nur aus Einsen besteht und deren weitere drei Bytes die Werte von `r`, `g` und `b` enthalten.
Das Ergebnis soll in einer Variable namens `color` gespeichert werden.

Beispiel:

```verbatim
r = 128
g = 186
b = 36

color = 11111111 10000000 10111010 00100100
          alpha    red     green     blue

            =       =        =        =

          255      128      186       36

      = -8340956
```

Testen Sie Ihren Code mit den folgenden Eingaben und ihrem Programm aus der letzten Aufgabe:

* 225, 0, 117
* 255, 188, 17
* 229, 9, 20
* 29, 161, 242

*Tipp: Sie brauchen für die Lösung dieser Aufgabe [bitweise Operatoren](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html), insbesondere `|` (bitweises or) und `<<` (left shift).
Das Aussehen ihrer Zwischenergebnisse können Sie mit der Methode `Integer.toBinaryString(int)` überprüfen.*

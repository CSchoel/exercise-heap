---
title: Farben als Integer
author:
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 1
    - major: computer science
    - subject: bitwise operations
    - subject: computer graphics
lang: de-DE
solution-size: 10
id: d948fedb-eec4-4685-8036-23eceac4bcd9
---

Um Farbwerte zu kodieren werden üblicherweise drei Zahlen zwischen 0 und 255 verwendet, die den Rot-, Grün-, und Blauanteil der Farbe darstellen.
Beispielsweise wäre ein kräftiges Rot in dieser Darstellung `(255, 0, 0)` und ein kräftiges Gelb `(255, 255, 0)` (Rot + Grün bei [additiver Farbmischung](https://de.wikipedia.org/wiki/Additive_Farbmischung)).
Da die 256 möglichen Werte sich perfekt in einem Byte (2⁸ = 256) darstellen lassen, kann man diese drei Zahlen auch kompakt wie folgt in den hinteren drei Bytes eines 32-bit Integer-Werts unterbringen.
Das erste Byte bleibt dabei frei bzw. wird als Maß für die Transparenz (den sogenannten alpha-Wert) verwendet.

```verbatim
-8340956

=

11111111 10000000 10111010 00100100
  alpha    red     green     blue

    =       =        =        =

  255      128      186       36
```

Schreiben Sie ein Java-Programm, das aus einer `int`-Variable `color` die Farbkanäle extrahiert und Sie in drei separaten `int`-Variablen `r`, `g` und `b` speichert.
Ist der Wert von `color` gleich -8340956, sollen also die Werte 128, 186 und 36 in `r`, `g` und `b` stehen.

Probieren Sie ihr Programm mit den folgenden Werten für `color`:

* -2031499
* -17391
* -1767148
* -14835214

Die Werte gehören zu den Logo-Farben bekannter Unternehmen: Eines für Telekommunikation, eine Fastfoodkette, ein soziales Netzwerk, und ein Videostreamingdienst.

*Tipp: Sie brauchen für die Lösung dieser Aufgabe [bitweise Operatoren](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html), insbesondere `&` (bitweises and) und `>>` (right shift).*

*Zusatzinfo: Wenn Sie die errechneten Farbwerte direkt in Java darstellen wollen, gibt es zwei Möglichkeiten dafür.
Die erste ist die Verwendung von [24-bit ANSI escape codes](https://en.wikipedia.org/wiki/ANSI_escape_code#24-bit), falls Ihr Konsolenprogramm diese unterstützt:*

```java
String bgTemplate = "\u001b[48;2;%d;%d;%dm";
String reset = "\u001b[0m";
String output = bgTemplate.formatted(128, 186, 36) + "    " + reset;
System.out.println(output);
```

*Die zweite verwendet die [Standardbiliothek Java Swing](https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/package-summary.html) für die Darstellung von grafischen Benutzerschnittstellen:*

```java
var f = new javax.swing.JFrame();
var c = new java.awt.Color(128, 186, 36);
f.setSize(800, 600);
f.getContentPane().setBackground(c);
f.setVisible(true);
```

*In beiden Beispielen müssen Sie die Zahlen 128, 186, und 36 durch die von Ihnen errechneten Werte für den Rot-, Grün- und Blaukanal ersetzen.*
---
title: Taschenrechner
author:
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 1
    - major: computer science
    - subject: if expression
    - subject: parsing
    - subject: user input
lang: de-DE
solution-size: 10
id: 5fbedcbd-6b32-4634-a1ed-3c0c3c1ae4c6
---

Schreiben Sie ein kleines Taschenrechner-Programm, das eine komplette Rechnung mit Ganzzahlen und einem einzelnen Operatorzeichen als String-Eingabe vom Benutzer einliest und das Ergebnis ausgibt.
Mögliche Eingaben sind zum Beispiel die folgenden:

* `7 + 3`
* `4 - 8`
* `1 / 3`
* `2 * 2`

Bonus: Erlauben Sie auch beliebig viele oder fehlende Leerzeichen zwischen dem Operator oder den Zahlen. (Besondere Schwierigkeit: `7/-3`)

Tipps:

* Das Einlesen von Benutzereingaben funktioniert in Java mit einem [`Scanner`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html) wie folgt:
    ```java
    Scanner sc = new Scanner(System.in);
    String userInput = sc.nextLine();
    ```
* Die Klasse [`String`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html) enthält einige Methoden, die für diese Aufgabe hilfreich sein könnten. Schauen Sie sich insbesondere die Methode [`String.split(String)`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html#split(java.lang.String)) an.

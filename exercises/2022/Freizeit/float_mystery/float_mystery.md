---
title: Mysteriöse Fließkommarechnungen
author:
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 1
    - major: computer science
    - subject: floating point arithmetic
lang: de-DE
solution-size: 20
id: 700844a3-4029-4413-bf52-0aaec8ec78ba
---

Probieren Sie die folgenden Rechnungen mit Fließkommazahlen in Java aus und erklären Sie die Ergebnisse.

*Tipp: Diese Aufgabe erfordert eine selbstständige Recherche.
Ein guter Startpunkt dafür ist die [Dokumentation der Klasse `Double`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Double.html#equivalenceRelation).
Bei manchen Beispielen hilft es auch, sich die Zwischenergebnisse anzuschauen.*

*Tipp für die Freizeit: Zeigen Sie diese Aufgabe erfahrenen Programmierer:innen und wetten Sie, wie viele der Ergebnisse diese ohne Ausprobieren korrekt vorhersagen können. 😉*

## Exaktheit von Ergebnissen

* `0.1f + 0.6f == 0.7f`
* `0.1 + 0.6 == 0.7`
* `0.1 + 0.7 == 0.8`
* `(0.1f + 0.6f) * 1e8f - 0.7f * 1e8f`
* `123456789f + 1 == 123456789f`

## Grenzen des Darstellbaren

* `1.0 / 0.0`
* `1e-200 * 1e-200`
* `-1e200 * 1e200`

## Undefinierte Ergebnisse

* `0.0 / 0.0`
* `0.0 / 0.0 == 0.0 / 0.0`
* `0.0 / 0.0 < 0.0 / 0.0`
* `0.0 / 0.0 > 0.0 / 0.0`
* `1e200 * 1e200 * 0.0`

## Verschiedene Nullen

* `1.0 / -0.0`
* `Double.valueOf(0.0).equals(-0.0)`
* `0.0 == -0.0`

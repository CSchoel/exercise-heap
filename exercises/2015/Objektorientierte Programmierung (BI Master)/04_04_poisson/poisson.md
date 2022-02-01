---
title: Poissonverteilung
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
    - requires: arithmetic operators
    - requries: loops
    - previous: ca3acf1d-e7bd-4a06-b293-b23820dfb16b
    - references: ca3acf1d-e7bd-4a06-b293-b23820dfb16b
    - domain: stochastics
    - submission: code
lang: de-DE
solution-size: 5
source: https://git.thm.de/cslz90/bimoop-cs
id: 8a8c9848-a0b6-4d3b-8c36-608b84568d4c
---

# Poissonverteilung

Schreiben Sie eine Java-Klasse `Poisson`.
Implementieren Sie in dieser Klasse eine Klassenmethode `poissonMass(int, float)`, die die Wahrscheinlichkeitsfunktion der Poissonverteilung (*Pr*(*X*=*k*)) berechnet.
Die Methodenparameter sind dabei der Index *k* und der
Erwartungswert *λ*.

*Sie dürfen zur Berechnung von $k!$ die Fakultätsmethode aus der Klasse `ExtendedMath` verwenden, die sie in [Aufgabe 03](../04_03_factorial/factorial.md) erstellt haben.*

$$Pr(X=k) = \frac{\lambda^k e^{-\lambda}}{k!}$$
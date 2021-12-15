---
title: Poissonverteilung
author:
    - Christopher Schölzel
keywords:
    - java
    - semester-1
    - bioinformatics
    - Technische Hochschule Mittelhessen
    - Justus-Liebig-Universität
    - course-Objektorientierte Programmierung
    - subject-functions
lang: de-DE
solution-size: 5
source: https://git.thm.de/cslz90/bimoop-cs
---

# Poissonverteilung

Schreiben Sie eine Java-Klasse `Poisson`.
Implementieren Sie in dieser Klasse eine Klassenmethode `poissonMass(int, float)`, die die Wahrscheinlichkeitsfunktion der Poissonverteilung (*Pr*(*X*=*k*)) berechnet.
Die Methodenparameter sind dabei der Index *k* und der
Erwartungswert *λ*.

*Sie dürfen zur Berechnung von $k!$ die Fakultätsmethode aus der Klasse `ExtendedMath` verwenden, die sie in [Aufgabe 03](../04_03_factorial/factorial.md) erstellt haben.*

$$Pr(X=k) = \frac{\lambda^k e^{-\lambda}}{k!}$$
---
title: AB1-GreedyAlgorithmus-ChangeMaking-klar
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
id: 846d2ee1-c026-4060-af26-8cc7f83168f2
---

# Change Making

Schreiben Sie einen Algorithmus, welcher das sogenannte ["Change-making problem"](https://en.wikipedia.org/wiki/Change-making_problem) (Geldwechselproblem) umsetzt und folgende Regeln beachtet:

1. Es gibt Münzen im Wert von 50, 20, 10, 5, 2 und 1 Credit(s)
2. Es gibt keine Einschränkung bei der Anzahl der einzelnen Münzen. Jeder Münzbetrag kann beliebig oft eingesetzt werden.
3. Der Zielbetrag muss exakt erreicht werden.
4. Realisieren Sie ihre Lösung als statische Methode `giveChange(int)` in der Klasse `de.thm.mni.aud.commons.changemaking.ChangeMaking`
5. Die Methode nimmt einen Zielbetrag als `int` an gibt und die Aufteilung in Münzen als eine `ArrayList<Integer>` zurück, die die Werte der Münzen enthält.
6. Stellen Sie sicher, dass die Münzwerte in der zurückgegebenen Liste *absteigend sortiert* sind.
7. Es soll der Greedy-Algorithmus verwendet werden, die Anzahl der Münzen ist nicht immer optimal.

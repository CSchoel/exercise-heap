---
title: Einrückung
author:
    - GDI-Tutoren
    - Christopher Schölzel
keywords:
    - language: python
    - semester: 1
    - major: bioinformatics
    - institution: Technische Hochschule Mittelhessen
    - institution: Justus-Liebig-Universität
    - course: Grundlagen der Informatik
lang: de-DE
solution-size: 5
id: 74eab8f0-f4cd-44dc-b466-eea869b33cd9
---

# Einrückung

Schreiben Sie eine Datei namens `indent.py` in der Sie aus dem standard input (`help(input)`) eine ganze positive Zahl auslesen und in der Variable `indent` speichern.
Gibt er eine negative Zahl ein, geben sie die Fehlermeldung `Die Zahl muss positiv sein!` aus.
Ist die Zahl positiv oder null, geben Sie eine Anzahl von Leerzeichen davor aus, die dem Wert der Variable `indent` entspricht, gefolgt von dem Text `eingerückt`.

Beispiel:

Input: 6
Output: `      eingerückt`

Input: 3
Output: `   eingerückt`

*Tipp: Denken Sie daran, dass man auch Strings in Python multiplizieren kann.*
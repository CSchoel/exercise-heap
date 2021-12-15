---
title: Fake Statistics
author:
    - GDI-Tutoren
    - Christopher Schölzel
keywords:
    - python
    - semester-1
    - bioinformatics
    - Technische Hochschule Mittelhessen
    - Justus-Liebig-Universität
    - Grundlagen der Informatik
lang: de-DE
solution-size: 13
---

# Fake Statistics

In dieser Aufgabe geht es darum, dass wir Elemente in einer Liste entfernen wollen und dafür andere hinzufügen möchten.
Ein Dozent ist mit seiner Evaluation unzufrieden und möchte seine Ergebnisse bzw. die der Studenten frisieren.
Die originalen Ergebnisse sind die folgenden:

```python
noten = [0.46, 0.61, 0.75, 1.0, 0.86, 0.38, 0.01, 0.77, 0.21, 0.73, 0.32, 0.99]
```

Er möchte alle Noten unter 50% bzw. 0.50 entfernen, also insgesamt 5. Dafür möchte er dann folgende Noten hinzufügen:
1.0, 1.0, 0.88, 0.90, 0.67.

Für diese Aufgabe musst du keine Schleifen verwenden. Es reicht, die Elemente einzeln mit Python-Befehlen zu entfernen und am Ende der Liste neu hinzuzufügen.

Der Test sucht die geänderte Liste unter dem Variablennamen `noten` in der Datei `faked_statistics.py`.

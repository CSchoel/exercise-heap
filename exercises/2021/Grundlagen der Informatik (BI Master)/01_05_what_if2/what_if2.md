---
title: What_if 2
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
solution-size: 8
id: 90e6c878-94fa-4682-a083-f88c15b4b90e
---

# What_if 2

In dieser Aufgabe geht es darum, zu Prüfen ob das Alter von Mannfred es erlaubt, den neuen John Wick im Kino zu sehen.

Manfreds alter finden wir mit dem folgenden Stück code heraus

```python
import random

age = random.randint(1, 100)
```

Der Film ist FSK 18 eingestuft. Wenn Mannfreds Alter groß genug ist, möchten wir in die Variable `result` den Wert `True` schreiben, ansonsten `False`.
Als zusätzliche Schwierigkeit kommt hinzu, dass das Management des Kinos für das wir arbeiten nicht dafür verantwortlich sein will, dass ältere Zuschauer an einem Herzinfarkt sterben.
Darum soll Mannfred auch dann den Film nicht sehen dürfen, wenn er 82 oder älter ist.

Nennen Sie ihre Quelldatei bitte `age.py`.
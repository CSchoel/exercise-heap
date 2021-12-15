---
title: Substitution Cipher
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
solution-size: 2
---

# Substitution Cipher

Schreibe eine Funktion `subst(message, cipher)` in der Datei `substitution_cipher.py`, die alle Zeichen im String `message` anhand des Dictionaries `cipher` ersetzt. Das heißt du musst jedes Zeichen `c` aus `message` als Schlüssel in `cipher` einsetzen und den zugeordneten Wert (als Zeichen `z`) ermitteln.

Beispiel:

```python
>>> cipher = {'A': 'T', 'C': 'G', 'G' : 'C', 'T': 'A'}
>>> subst("AAGCAGT", cipher)
TTCGTCA
```
---
title: Write CSV
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
solution-size: 9
id: b8761069-25ad-417f-a21e-425722478088
---

# Write CSV

Schreibe eine Funktion `write_csv(fname, strings)` in der Datei `write_csv.py`, die eine Datei, deren Namen in dem Parameter `fname` angegeben ist, erzeugt und zu jedem String in der Liste `strings` eine Zeile der Form `s;n` in die Datei schreibt. Dabei steht `s` für den String aus der Liste und `n` gibt an aus wieviel *unterschiedlichen* Buchstaben `s` besteht.

Für diesen Beispielinput

`["foo", "bar", "oooff"]`

soll die Datei also wie folgt aussehen:

```
foo;2
bar;3
oooff;2
```
---
title: Eigene Map-Funktion
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
solution-size: 10
---

# Eigene Map-Funktion

Die Map-Funktion haben wir in der Vorlesung schon kennengelert, nun möchten wir eine eigene Map-Funktion schreiben.
(diese darf auf keinen Fall map heißen! Vorschlag: my_map)


Die Funktion soll eine Funktion zb. im Form eines Lambda-Ausdrucks übernehmen und ein Iterable-Objekt zb. eine Liste.
Dann soll für jedes Element im Iterable die übergebene Funktion angewendet werden, die Methode soll daraufhin ein neues Iterable zurück geben zb. eine Liste.

Gegeben ist folgende Liste: 
```Python 
l = [1, 2, 3]
```
Der Lambda-Ausdruck soll zu einem Wert 42 Multiplizieren, das Ergebnis der Methode muss in einer Variable names **result** gespeichert werden.
Hinweis: Die Datei soll wie folgte heißen: my_map.py
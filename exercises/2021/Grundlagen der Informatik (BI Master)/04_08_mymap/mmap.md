---
title: Eigene Map-Funktion
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
solution-size: 10
id: dcfb9961-7416-475e-97c0-07c7185918d9
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
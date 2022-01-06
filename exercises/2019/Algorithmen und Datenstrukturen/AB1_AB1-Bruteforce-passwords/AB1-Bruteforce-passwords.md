---
title: AB1-Bruteforce-passwords
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
id: 7aa2d116-27e6-447d-93b5-3e9f2c70f31e
---

# Brutforce Passwoerter

- Bewertungsschema: Abgabe auf Dozentron, Prüfung durch UnitTests

Erzeugen Sie eine ArrayList mit allen möglichen Wörtern mit den folgenden Eigenschaften:
1. Jedes Wort fängt mit "grunz" an.
2. Jedes Wort hat eine Länge von maximal 9 Zeichen.
3. Jedes Wort besteht nur aus den Buchstaben 'a' bis 'z' und 'A' bis 'Z'.

##### Hinweis
> Chars werden in Java intern als Zahlenwerte dargestellt. Können sie dies nutzen, um darüber zu iterieren?

Folgende Formalia sollen eingehalten werden:
- Erstellen Sie eine Klasse `Passwords` in dem package `passwords`.
- Implementieren Sie in der Klasse `Passwords` eine Methode mit der Signatur `public static ArrayList<String> passwords()`. Diese soll alle möglichen Wörter nach oben beschriebenen Regeln erzeugen.

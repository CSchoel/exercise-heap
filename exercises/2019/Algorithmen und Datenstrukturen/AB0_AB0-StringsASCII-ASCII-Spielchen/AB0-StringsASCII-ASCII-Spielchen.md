---
title: AB0-StringsASCII-ASCII-Spielchen
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
---

## ASCII-Spielchen

Sie erhalten eine zweispaltige Tabelle, deren linke Spalte Integer-Werte und deren rechte Spalte Character-Werte beinhaltet.
Die Integer-Werte stehen für eine verschlüsselte Position in einem String. Die Character-Werte sind die Zeichen, aus denen dieser String zusammengesetzt werden soll.
Jede Tabellenzeile beinhaltet also ein Schlüssel-Wert-Paar aus verschlüsselter Position (Schlüssel) und Zeichen (Wert).

Um die verschlüsselten Positionen zu entschlüsseln, muss zuerst jeweils der Integer mit dem ASCII-Wert des zugehörigen Characters addiert werden. Dann müssen diese Werte noch aufsteigend sortiert werden. Die Position der Werte in der sortierten Reihenfolge bestimmt dann die endgültige Position im String.

Implementieren Sie in einer beliebigen Sprache ein Programm, welchem Sie den 'Input' von Dozentron übergeben. Geben Sie ihre Ausgabe dann mit ihrem Code zusammen auf Dozentron ab.

Beispiel:

linke Spalte | rechte Spalte
-------------|--------------
42           |p
7            |k

ASCII-Wert von p => 112

Position von p => 42 + 112 = 154

ASCII-Wert von k => 107

Position von k = 7 + 107 = 114

aufsteigend sortiert: 114, 154

Daraus ergibt sich folgender String: "kp"

Bitte finden Sie zu vorgegebener Tabelle den korrekten String nach den oben genannten Regeln.

Hinweis zur Aufgabe:
- Die Semantik des Strings ergibt keinen Sinn.
- Hierbei handelt es sich um eine Input-Output-Aufgabe auf Dozentron.
- Die Aufgabe kann mit einer beliebigen Programmiersprache gelöst werden.
- Laden Sie ihren Output und Ihren Code auf Dozentron hoch.

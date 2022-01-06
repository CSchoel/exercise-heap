---
title: aufgabe
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
id: 271d3bae-8db7-4e76-9897-e4d494146545
---

# Apothekerwaage

Schreiben sie ein Programm, das einen **Backtracking**-Algorithmus zum Ausgleichen einer Apothekerwaage implementiert. Gegeben ist ein Zielgewicht und eine unendliche Menge Gegengewichte, von denen jeweils beliebig viele benutzt werden dürfen. Die Gegengewichte setzen sich nach folgendem Schema zusammen:

> 0, 2, 7, 20, 70, 200, 700, 2000, ...

Sie sollen nacheinander auf die Waage gelegt werden, bis das Zielgewicht erreicht ist. Wird das Zielgewicht überschritten, muss das letzte Gewicht wieder heruntergenommen und ausgetauscht werden. Führt dies immer noch nicht zum Ziel, müssen zwei Schritte zurückgegangen werden. Finden Sie die **optimale** Kombination an Gewichten, d.h. die Anzahl der benutzten Gegengewichte soll minimal sein.

## Aufgabe:

Sie erhalten als Input eine beliebige Anzahl zufällig generierter, durch Zeilenumbrüche getrennter Gewichte.
Geben Sie im Output-Feld für jede Input-Zeile die optimale Kombination an oben genannten Gegengewichten an und schreiben Sie sie wie im Beispiel (siehe unten) gezeigt auf.

### Bitte beachten:
- Die Ausgabezeilen müssen der Reihenfolge der Eingabezeilen folgen.
- Innerhalb der Ausgabemengen sollte es keine Leerzeichen oder anderen Whitespace geben.
- Es dürfen keine Leerzeilen im Output stehen!
- Bitte reichen Sie Ihren Quellcode zur Korrektheitsprüfung ein.
- Ihr Programm muss Backtracking benutzen!
- Jedes Gegengewicht darf mehrmals verwendet werden.
- Der Generator wird keine Gewichte generieren, die sich nicht mithilfe von Gegengewichten aus dieser Menge lösen lassen.
- Sie müssen die **optimale** Kombination an Gewichten, d.h. die geringst mögliche Anzahl der benutzten Gegengewichte finden.

## Beispiel:

**Generierter Input**:

```  
80
141
0
777
```

**Ihr Output**:  

```
20,20,20,20
70,20,20,20,7,2,2
0
700,70,7
```

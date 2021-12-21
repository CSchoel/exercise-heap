---
title: Morsecode
author:
    - AuD-Tutoren (NK, SE)
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 1
    - major: computer science
    - institution: Technische Hochschule Mittelhessen
    - course: Algorithmen und Datenstrukturen
lang: de-DE
solution-size: 10
source: https://git.thm.de/cslz90/infomagic
id: d53bbddd-5438-4e3e-a5dc-043358defd30
---

# Morsecode

## Aufgabe 1

In der folgenden Aufgabe sollen Sie eine Methode schreiben, die einen String in Morse-Code umwandelt. <br>
Welcher Buchstabe auf welchen Morse-Code abgebildet wird finden Sie hier: [morse-code.txt](http://dozentron.mni.thm.de/groups/attachments/3)

### Beispiel:

```
"AUD ist toll"

'A' => ".-"
'U' => "..-"
'D' => "-.."
' ' => " "
'i' => ".."
's' => "..."
't' => "-"
' ' => " "
't' => "-"
'o' => "---"
'l' => ".-.."
'l' => ".-.."

=> ".-" + "..-" + "-.." + " " + ".." + "..." + "-" + " " + "-" + "---" + ".-.." + ".-.." 
=> ".-..--.. .....- ----.-...-.."
```

Lösen sie die Aufgabe in zwei Schritten, indem sie Zwei Methoden schreiben:
- `public static Map<Character, String> getDictionary(String filePath)` generiert aus einer Datei eine [Java Map](https://docs.oracle.com/javase/7/docs/api/java/util/Map.html), die jeden Buchstaben auf seinen Morse-Code abbildet.
- `public static String encode(String input)` generiert mit Hilfe von `getDictionary` aus einem String seine Repräsentation in Morse-Code.

Beide Methoden sind Teil der Klasse `MorseCode` im Package `morsecode`.

### Hinweise:

> - Zum Parsing eignen sich reguläre Ausdrücke. Ein visueller Editor für reguläre Ausdrücke ist zum Beispiel [regex101](https://regex101.com/).
> - Zwischen Gross- und Kleinschreibung wird nicht unterschieden.
> - Die Datei `morse-code.txt` muss bei der Abgabe nicht der Jar beigefügt werden. Es kann beim Zugriff davon ausgegangen werden, dass sich die Datei im gleichen Verzeichnis befindet. Es kann also direkt auf sie zugegriffen werden.
> - Beim Einlesen der Datei bitte darauf achten, sie im **ASCII-Format** einzulesen, sonst können Fehler auf Dozentron enstehen.

## Aufgabe 2

Je nach dem ob Sie eine `HashMap` oder eine `TreeMap` verwenden, gelten unterschiedliche Einschränkungen für ihre möglichen Schlüssel.
Welche Bedingung müssen Schlüssel einer HashMap erfüllen, welche die Schlüssel einer TreeMap?

### Hinweis:

> Ein Blick in die Java API kann hilfreich sein.

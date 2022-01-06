---
title: AB0-Hangman
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
id: 5a35e328-10bb-4552-9ccf-8f20494cddda
---

# Hilf dem Henker

## Beschreibung
Im Folgenden betrachten wir das Spiel [Galgenmännchen](https://de.wikipedia.org/wiki/Galgenm%C3%A4nnchen).
In unserem Fall kann das Männchen aus beliebig vielen Strichen bestehen. Raten ist nur mit den 26 Buchstaben des lateinischen Alphabets erlaubt.

## Aufgabe 1

Schreiben Sie ein Programm, das prüft, ob ein Spiel für ein gegebenes Wort und eine gegebene Anzahl von Strichen überhaupt verloren werden kann.

Erstellen Sie dazu in Java eine Klasse `Hangman` im package `hangman` mit einem Konstruktor, der das zu erratene Wort und die maximale Anzahl an Strichen übergeben bekommt.
Der Konstruktor sollte wie folgt aussehen:

```java
Hangman(String wordToGuess, int maxLines) { ... }
```

Implementieren Sie außerdem mindestens folgende Methoden:

```java
public String getWord();
public boolean isPossibleToLose();
```

Hierbei ist die Methode `getWord()` ein Getter für die entsprechenden Instanzvariablen. Die Methode `isPossibleToLose()` soll `true` zurückgeben, wenn ein Spiel verloren werden kann.

#### Beispiel:
* Zu erratenes Wort: "algomantik"
* Maximale Anzahl an Strichen: 10

Antwort: Dieses Spiel kann verloren werden.

#### Tipp
Suchen Sie zunächst Beispiele, bei denen ein Spiel nicht verloren werden kann, formulieren Sie dazu eine Regel und versuchen Sie danach, diese in Java umzusetzen.

#### Anmerkungen:
* Achten Sie auf passende Datentypen, sofern diese nicht schon angegeben sind.
* Alle Instanzvariablen und zusätzlichen Methoden sollten auf `private` gesetzt werden.
* Wir nehmen an, dass das Wort nicht leer ist.
* Der Anfangsbuchstabe des gesuchten Wortes ist in unserer Variante nicht bekannt.
* Wir gehen davon aus, dass ein Buchstabe nicht doppelt geraten wird.
* Das Wort gilt erst als erraten, wenn alle Buchstaben erraten wurden.

## Aufgabe 2

Bestimmen Sie, ob bei zufälligem Raten von Buchstaben das Spiel gewonnen wird.

Erweitern Sie dazu die in Aufgabe 1 erstellte Klasse `Hangman` um folgende Methoden:

```java
public int getLineCount();
public char playRandomly();
public boolean isWin();
```

Hierbei ist die Methode `getLineCount()` ein Getter, der die aktuelle Anzahl der Striche zurückgibt. Die Methode `playRandomly()` liefert bei jedem Aufruf einen Buchstaben, der zufällig aus dem Alphabet ausgewählt wird.
Zudem soll sie den internen Zustand der Klasse so verändern, dass mit der Methode `isWin()` dann überprüft werden kann, ob das Spiel gewonnen wurde oder nicht.

#### Anmerkungen:
* Buchstaben dürfen jetzt auch doppelt genannt werden.
* Es wird kein Unterschied zwischen Groß- und Kleinbuchstaben gemacht.
* Achten Sie darauf, dass das Striche-Limit nicht überschritten wird.

## Aufgabe 3

Bestimmen Sie, ob bei strategischem Raten nach Buchstabenhäufigkeit das Spiel gewonnen wird. Sie können sich dabei die Tabelle auf der folgenden Seite zur Hilfe nehmen: [Tabelle Buchstabenhäufigkeit](https://de.wikipedia.org/wiki/Buchstabenh%C3%A4ufigkeit).

Ergänzen Sie die in Aufgabe 2 erweiterte Klasse `Hangman` um folgende Methoden:

```java  
public char playStrategically();
```

Die Methode `playStrategically()` funktioniert entsprechend wie `playRandomly()`, nur dass Buchstaben anhand ihrer Häufigkeit strategisch geraten werden.

#### Bemerkung
Die Methode `isWin()` sollte ein richtiges Ergebnis liefern, egal ob zufällig oder strategisch gespielt wird.

## Aufgabe 4

Erläutern Sie kurz, welche die schwierigsten Wörter für die in Aufgabe 2 (zufällig) und in Aufgabe 3 (nach Buchstabenhäufigkeit) genannten Strategien sind.

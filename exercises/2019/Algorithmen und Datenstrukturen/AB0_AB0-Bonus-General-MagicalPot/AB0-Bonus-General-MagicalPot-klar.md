---
title: AB0-Bonus-General-MagicalPot-klar
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
id: c8e31243-c674-4d77-ad84-0370bf04238a
---

# [Bonus] The magical Pot  

## Aufgabe 1
### Dauer: ca. 15 Min (3 XP)

#### Beschreibung:
Implementieren Sie die Klasse `MagicalPot` mit einem geeigneten Konstruktor, den Attributen aktuelles Volumen, maximales Volumen und Vorratsschrank, sowie folgenden Methoden:
* `brew (volumeWater, recipe)`
* `isOverrun () : boolean`

Hierbei fügt die `brew`-Methode erst `volumeWater` zum aktuellen Füllstand hinzu, dann nach und nach die Zutaten aus `recipe`. Die Methode `isOverrun` gibt, wenn sie Aufgerufen wird, zurück ob das maximale Volumen überschritten wurde. Diese Überprüfung findet erst nach dem brauen statt.


#### Anmerkungen:
* Achten Sie auf die passenden Datentypen, sofern diese nicht schon angegeben sind.
* Das Rezept (`recipe`) kann vorerst eine Liste von beliebig vielen Zutaten sein.
* Als weitere Vereinfachung nehmen wir an, dass der `MagicalPot` eine Map als Vorratsschrank besitzt. Diese map bildet die Zutaten und ihre Auswirkungen auf den Füllstand als Key-Value-Paare ab.
* Die Auswirkung auf den Füllstand ist ein Faktor, keine konkrete Menge. So ist nach hinzufügen von "Krötenwurz" der neue Füllstand = alter Füllstand + Zweifaches des alten Füllstandes.


* Diese Map können Sie nutzen:
	```java
	private Map ingredients = new HashMap();
	ingredients.put("Wolfsmilch", 0.25);
	ingredients.put("Krötenwurz", 2);
	ingredients.put("Sonnenkraut", 0.1);
	ingredients.put("Sesampulver", 3);
	ingredients.put("Schnarchessenz", 0.5);
	ingredients.put("Hasenpfote", 0.7);
	```

# Aufgabe 2
### Dauer: ca. 45 Min. (11 XP)
#### Beschreibung:
Implementieren Sie in Java eine vollständig objektorierte Version des `MagicalPot`.
Zutat (`Ingredient`), Rezept (`Recipe`), Vorratslager (`Stock`) und ihre Eigenschaften sollen nun ebenfalls als Klassen dargestellt werden.
Zusätzlich soll die `brew`-Methode, nach erfolgreichem Brauen, ein Zaubertrank-Objekt (`MagicPotion`) zurückliefern.
Wenn der Zaubertrank misslingt, dann soll eine passende Exception geworfen werden.

#### Anmerkungen:
* Achten Sie bei den jeweiligen Eigenschaften und Methoden auf passende Zugriffsmodifikatoren (public/private), auf public sollte möglichst verzichtet werden.
* Implementieren Sie sinnvolle Getter- und Setter-Methoden

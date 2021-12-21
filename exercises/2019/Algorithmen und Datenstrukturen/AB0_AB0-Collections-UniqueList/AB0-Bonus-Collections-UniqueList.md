---
title: AB0-Bonus-Collections-UniqueList
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

# Eine Diät für Basilisten

## Aufgabe 1: Programmierung
Schreiben sie eine Funktion, die eine Liste an Werten nimmt und mithilfe einen [Sets](http://docs.oracle.com/javase/7/docs/api/java/util/Set.html) eine *neue* Liste generiert, die keine Duplikate enthält. Die Funkion soll folgende Signatur haben: `List<A> distinct(List<A> lst)`

	package uniqueList;

	public class UniqueList {

   		public static <E> List<E> distinct(List<E> lst) {
        	// code here
    	}
	}


## Aufgabe 2: Recherche

1. Was unterscheidet Sets von Listen?
2. Angenommen Sie fügen 5 Zahlen in der Reihenfolge 1,2,3,4,5 einem Set hinzu. In welcher Reihenfolge können die Werte entnommen werden?
3. Aus welchen Gründen müssen Elemente in einem TreeSet vergleichbar (comparable) sein? Was hat das mit der Datenstruktur zu tun?
>Werfen Sie einen Blick in die [Java API](http://docs.oracle.com/javase/7/docs/api/java/util/Set.html).

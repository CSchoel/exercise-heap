---
title: AB4-Strukturgleichheit-klar
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
id: fbcff4a6-e06a-4928-adcb-0fdf7d8d84de
---

# Strukturgleichheit

## Aufgabe 1

Erweitern Sie ihre Lösung aus der Aufgabe "Binäre Suchbäume" um die Methode `isomorph`.

```java
package binarytree;

public class BinaryTree<T> extends ABinaryTree<T> {

  /** check if `this` and `other` are isomorph */
  public <E> boolean isomorph(ABinaryTree<E> other){
    /**TODO*/
  } 
  
}
```

## Hinweise

- Im Allgemeinen sind zwei Graphen isomorph, wenn ihre Struktur **ohne** Berücksichtigung der Knotenbenennung gleich ist.
    - Beispielsweise wären die Bäume für die Werte `( (2) - 3 - (6) )` und `( (1) - 5 - (9) )` strukturgleich.
    - Die Ausdrucksbäume für die Ausdrücke `( (3) - 4 - (6) )` und `( (3) - 4 - ( () - 5 - (9) ) )` sind allerdings nicht strukturgleich.
- Die Tests werden auch die Korrektheit der ursprünglichen Aufgabe vom Aufgabenblatt 4 testen. Sie sollten daher Ihre Aufgabe übernehmen.
- Es empfiehlt sich die Hilfsmethode `private <E> boolean isomorph(ABinaryTreeNode<T> my, ABinaryTreeNode<E> other)`zu verwenden - dies ist allerdings keine Pflicht
- Es ist möglich die Aufgabe in zwei Methoden als Einzeiler aufzuschreiben
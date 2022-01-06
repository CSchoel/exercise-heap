---
title: AB1-DoppeltVerketteterBasilist-klar
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
id: e13cfb69-cf9a-4b5d-8641-60ba4952652c
---

# Doppelt verkettete Liste

## Erklärung

Die doppelt verkettete Liste ("doubly linked list" oder auch "double linked list") ist der einfach verketteten Liste ("single linked list" oder auch nur "linked list") sehr ähnlich. Statt sich nur die Referenz des Nachfolgers zu merken, merkt sich die doppelt verkettete Liste auch die Referenz des Vorgängers. Aus diesem Grund muss auch der Anfang **und** das Ende mit `Nil` markiert werden. Der Vorteil dieser Datenstruktur liegt darin, dass die Traversierung in beide Richtungen möglich wird.

## Aufgabe 1)

Erstellen Sie in Java eine generische Klasse `DoublyLinkedBasilist`, die das Interface `GenericBasilist` aus dem ersten Foliensatz (S. 29) implementiert. Vervollständigen Sie die Methoden unter Zuhilfename einer doppelt verketteten Liste.

Das interface `GenericBasilist` aus dem ersten Foliensatz ist im Folgenden nochmals aufgeführt. Für alle Indizes, die nicht im Bereich Ihrer Liste liegen, sollen Sie eine `java.lang.IndexOutOfBoundsException` werfen. Legen Sie Ihre Klasse `DoublyLinkedBasilist` und das dazugehörige Interface `GenericBasilist` in ein Package `basilist`.

```java
package basilist;

public interface GenericBasilist<E> {
  E get(int idx); // retrieve element
  void set(E el, int idx); // overwrite element
  int size(); // number of elements
  void add(E el); // append to end
  void remove(int idx); // remove at index
  void insert(E el, int idx); // insert at index
}
```

## Aufgabe 2)

Um den Vorteil einer doppelt verketteten Liste auszunutzen, sollen Sie die folgende, veränderte Version des `GenericBasilist` implementieren.

```java
package basilist;

import java.util.function.Function;

public interface GenericBasilist<E> {
  E get(int idx); // retrieve element
  void set(E el, int idx); // overwrite element
  int size(); // number of elements
  void add(E el); // append to end
  void remove(int idx); // remove at index
  void insert(E el, int idx); // insert at index
  <T> GenericBasilist<T> map(Function<E, T> f); // call `f` for each element and return a mapped list
	<T> GenericBasilist<T> reverseMap(Function<E, T> f); // like `map` but traverse in reverse order
}
```

Die Funktion `map` soll hierbei Ihre Liste in der "üblichen" Reihenfolge (von links nach rechts, bzw. vom ersten zum letzten Element) durchlaufen. Damit ein Benutzer Ihrer Liste auch etwas mit den Werten anstellen kann, soll während der Traversierung für jeden Wert die [Funktion f](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html) aufgerufen werden. Der Rückgabewert dieser Funktion soll in einer neuen Liste aufgesammelt werden.

Die Funktion `reverseMap` soll Ihre Liste in umgedrehter Reihenfolge (von rechts nach links, bzw. vom letzten zum ersten Element) durchlaufen. Analog zur Funktion `map` soll für jeden Wert die [Funktion f](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html) aufgerufen werden. Der Rückgabewert dieser Funktion soll in einer neuen Liste aufgesammelt werden. Überlegen Sie sich, wie Sie Ihre Liste möglichst einfach vom letzten bis zum ersten Element durchlaufen können (Machen Sie Gebrauch von der Eigenschaft, dass jedes Listenelement seinen Vorgänger kennt).

#### Ein einfacher Test

Folgender Test sollte Ihrer doppelt verketteten Liste keine Schwierigkeiten bereiten. Achten Sie darauf die Funktion `equals` Ihrer Liste zu implementieren, da sonst der Test mit hoher Sicherheit fehlschlagen wird (Sie sollten wissen warum!).

```java
public static void main(String[] args) {
		GenericBasilist<Integer> zahlen = new DoublyLinkedBasilist();
    IntStream.range(0, 10).forEach(zahlen::add);
		GenericBasilist<String> a = zahlen.map(Object::toString);
		GenericBasilist<String> b = zahlen.reverseMap(Object::toString);
		System.out.printf("Vergleiche %s mit %s ...\n", a, b);
		if (!a.equals(b)) {
        System.err.println("Test fehlgeschlagen!");
			  System.exit(1);
		} else {
			  System.out.println("Test erfolgreich!");
			  System.exit(0);
		}
}
```


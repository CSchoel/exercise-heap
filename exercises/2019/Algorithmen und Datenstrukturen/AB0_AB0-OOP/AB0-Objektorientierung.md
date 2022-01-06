---
title: AB0-Objektorientierung
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
id: 8f99dc3f-b00c-472b-b05f-1fb5be3cc1c3
---

# Objektorientierung

## Aufgabe 1
Definieren Sie im Package `oop` eine Klasse `Person` mit den Attributen `String name`, `String vorname` und `int alter`. Überschreiben Sie die Methoden `equals`, `hashCode` und `toString`. Denken sie daran, dass Attribute normalerweise `private` sind.

>Hinweis: In der Regel ist es keine gute Idee, selbst einen HashCode zu errechnen. Java bietet für eigene hashCode-Implementierungen Hilfsmethoden, wie z.B. `Objects.hash` an.

## Aufgabe 2
Machen Sie die Klasse Person vergleichbar, in dem Sie [Comparable](https://docs.oracle.com/javase/9/docs/api/java/lang/Comparable.html) implementieren. Überlegen Sie sich, anhand welcher
  Eigenschaft eine Person verglichen werden kann.

## Aufgabe 3
Erstellen Sie 2 Subklassen von Person: `Student` und `Professor`.
Ein Student hat zusätzlich eine **Matrikelnummer** (`int matrikelnr`) und ein Professor einen **Titel** (`String titel`).

## Aufgabe 4
### Aufgabe 4.1
Was bewirkt der `final`-Modifizierer vor Klassen?

```java

    public final class Foo {}

```

### Aufgabe 4.2
Im zweiten Beispiel handelt es sich um den `final`-Modifizierer vor einer Methode.

Was bewirkt der `final`-Modifizierer vor Methoden?

```java

    public final void foo();

```

### Aufgabe 4.3
Was bewirkt der `final`-Modifizierer vor Attributen?
```java

    public final int bar = 42;

```

Machen sie alle Attribute in `Person`, `Student` und `Professor` unveränderbar.


## Aufgabe 5
Was bewirkt der `static`-Modifizierer vor **geschachtelten** Klassen?
  Wie würden Instanzen von `Bar` erzeugt werden, wenn das `static` fehlt?

```java

	  public class Foo {
	    static class Bar {
	    }
	  }

```

## Aufgabe 6
Was bewirkt '...' hinter dem generischen Datentypen `A`?

```java

 	List<A> toList(A... args);

```

>Werfen Sie einen Blick in die [ObservableList](https://docs.oracle.com/javase/9/docs/api/javafx/collections/ObservableList.html), um einige Beispiele hierfür zu finden.

## Aufgabe 7
Welche Sichtbarkeit hat die Variable `x` im folgenden Beispiel?  
Welche Probleme können auftreten?

```java

    public class X {
      int x;
    }

```

## Aufgabe 8
Schreiben sie getter für alle Attribute der von ihnen implementierten Klassen.

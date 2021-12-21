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
---

# Zip für Java-Streams

### Vorwort

In vielen funktionalen Programmiersprachen wie z.B. Scala oder Haskell gibt es eine Funktion `zip`. Diese bekommt *zwei* Listen mit gleichem oder unterschiedlichem Typ als Argument übergeben und formt diese zu *einer* Liste. Diese enthält dann Tupel aus den Elementen der jeweiligen Listen mit dem gleichen Index. Der Name "zip" kommt aus dem Englischen und bedeutet "Reißverschluss". Und das ist auch genau, was die Funktion macht, sie arbeitet nach dem *Reißverschlussprinzip*.

**Beispiel:**  

Gegeben sind zwei Listen:

```
{1,3,5,7}
{2,4,6,8}
```

Nach dem Ausführen der Funktion `zip` ergibt sich die folgende Liste:

```
{(1,2),(3,4),(5,6),(7,8)}
```

Als Erweiterung gibt es noch die Funktion `zipWith`, die zusätzlich noch eine Funktion als Argument übergeben bekommt. Diese wird dann auf die Tupel angewendet, sodass aus zwei Listen gleichen oder unterschiedlichen Typs eine Liste wird.

**Beispiel:**  

Gegeben sind die Listen aus obigem Beispiel mit der Funktion "Addieren":

```
(a, b) => a + b
```

Nach dem Ausführen der Funktion `zipWith` ergibt sich die folgende Liste:

```
{3,7,11,15}
```

### Aufgabenstellung

Schreiben Sie eine `zip`- und eine `zipWith`-Methode für Java-Streams. 

1. Da es in Java keine Tupel gibt, erstellen Sie zuerst eine generische Klasse `Tuple<A, B>` mit einem Konstruktor, der die Parameter `A val1` und `B val2` besitzt sowie die Getter-Methoden `A _1()` und `B _2()`, welche den ersten bzw. den zweiten Wert des Tupels zurückgeben. Überschreiben Sie zusätzlich noch die Methode `equals()`. Zwei Tupel sind dann gleich, wenn `val1` von Tupel A mit `val1` von Tupel B übereinstimmt. Das gleiche gilt für `val2`.
2. Erstellen Sie dann eine Klasse `Zipper`, welche die folgenden statischen Methoden implementiert:

```java
static <A, B> Stream<Tuple<A, B>> zip(Stream<A> stream1, Stream<B> stream2) { ... }
static <A, B, C> Stream<C> zipWith(Stream<A> stream1, Stream<B> stream2, BiFunction<A, B, C> biFn) { ... }
```

**Vorgehensweise:**

Die Methoden `zip` und `zipWith` sollen **lazy** implementiert werden. Um das zu erreichen benötigt man einige Klassen und Methoden, die Ihnen eventuell in Ihrem Studium noch nicht über den Weg gelaufen sind. Deshalb gibt es hier eine kleine Hilfestellung, um die Aufgabe dennoch bewältigen zu können:

1. Gegeben: zwei Streams, Ziel: zwei Iteratoren
2. Gegeben: zwei Iteratoren, Ziel: ein Iterator
3. Gegeben: Iterator, Ziel: Spliterator (Es gibt eine Klasse namens `Spliterators`. Diese besitzt eine Methode, die einen Iterator in einen Spliterator umwandeln kann. Dazu werden aber noch zwei weitere Argumente benötigt. Sie können hier zur Vereinfachung `Long.MAX_VALUE` für `size` und `0` für `characteristics` angeben)
4. Gegeben: Spliterator, Ziel: Stream (Es gibt eine Klasse namens `StreamSupport`. Diese besitzt eine Methode, die einen Spliterator in einen Stream umwandeln kann. Dazu wird aber noch ein weiteres Argument benötigt. Sie können hier zur Vereinfachung `false` für `parallel` angeben)

Die Klassen `Tuple` und `Zipper` gehören in ein gemeinsames Package namens `zipper`.

#### Hinweise

* Achten Sie darauf, dass sich die Klassen im richtigen Package befinden.
* Benennen Sie die Methoden genau wie in der Aufgabenstellung beschrieben und achten Sie auf korrekte Typen.
* Bei der Methode `zip` und `zipWith` kann Ihnen die oben beschriebene Vorgehensweise helfen. Nähere Infos zu den dort verwendeten Prinzipien im Vorlesungsskript oder in der Java-Dokumentation zu den entsprechenden Klassen.
* Sind die Streams unterschiedlich lang, zählt die Länge des kürzeren. Der Rest wird verworfen.
* Bei `zipWith` ist es nicht nötig eine komplett neue Methode zu implementieren. Hier kann `zip` verwendet werden.
* Was ist eine BiFunction? Sie haben bereits die funktionale Schnittstelle Function in Arbeitsblatt 0 Aufgabe 2.2 kennengelernt. BiFunction funktioniert dementsprechend mit dem Unterschied, dass ein Argument mehr übergeben wird. Für zusätzliche Infos können Sie auch hier in die [Java-Dokumentation](https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html) schauen.

**Beispiel:**  

```java
BiFunction<String, Integer, String> buyFood = new BiFunction<>() {
    @Override
    String apply(String food, Integer count) {
        return food + ": " + count;
    }
}

```
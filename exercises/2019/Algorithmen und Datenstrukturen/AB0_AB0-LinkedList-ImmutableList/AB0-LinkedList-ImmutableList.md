---
title: AB0-LinkedList-ImmutableList
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
id: 5f12b2d0-dfab-481e-9568-7934890db2ee
---

## LinkedList: ImmutableList

Erinnern Sie sich an ihre Notizen zu Funktionen für diese Aufgabe.

```Scala
-- a custom list type
-- either empty (Nil) or an element and the rest of the list (Cons element tail)
sealed trait LList[E]
case class Nill[E]() extends LList[E]
case class Cons[E](head: E, tail: LList[E]) extends LList[E]) extends LList[E]
```

> Hinweis: `--` leitet in Haskell einen Kommentar ein


### Aufgabe 1.1
Implementieren Sie die oben stehende Haskell Variante einer immutablen, verketteten Liste in Java.
Die Liste sollte sich im Package `linkedlist` befinden und dem folgenden Interface genügen:

```java
public interface ImmutableList<A> {
	/** Prepends elem infront of this list */
	ImmutableList<A> cons(A elem);
	/** Appends elem at the end of this list. */
	ImmutableList<A> append(A elem);
	/** Returns the size of the list. */
	int size();
	/** Returns the element at the index idx. */
	A getAt(int idx) throws IndexOutOfBoundsException;
}
```

**Formalia**
> - Definieren Sie 2 Subklassen, die das Interface `ImmutableList` implementieren und im selben Package liegen. Einmal die leere Liste `Nil` und die nicht-leere Liste `Cons`.
> - Die Liste sollte im Speicher wie folgt aussehen: `[5]->[3]->[10]->Nil`. (Die Zahlen sind Beispielwerte. Elemente, Elementtypen und Längen der Liste sind variabel zu halten.)
> - Beachten Sie, dass auch die Methoden `toString` und `equals` überschrieben werden müssen.  
> - Die Liste soll immutabel sein, d.h. einmal erstellte Objekte dürfen nicht mehr verändert werden. Dadurch fügen `cons` und `append` das Element nicht in das bestehende Objekt ein, sondern erstellen eine neue Liste, die das angefügte Element enthält.

*Beispiel:* Wenn im Speicher `[5]->[3]->Nil` steht, sollte `toString` folgendes zurückgeben: `Cons(5, Cons(3, Nil))`

### Aufgabe 1.2
Erweitern Sie das Interface `ImmutableList` um eine `map()` Methode:

```java
	<B> ImmutableList<B> map(Function<A,B> fn);
```

`map` wendet auf jedes Element der Liste die gegebene Funktion an. Angenommen es gibt eine List `lst` mit dem Inhalt `(1, 2, 4, 5)`.

Dann könnte `map` auf zwei Arten verwendet werden:

```java
ImmutableList<Integer> lst = ...;
//functional (Java 8) style
ImmutableList<Integer> doubled = lst.map(i -> i*2);
//anonymous class alternative
ImmutableList<Integer> doubled = lst.map(new Function<Integer,Integer>(){
	@Override Integer apply(Integer i) {
		return i*2;
	}
});
```
Danach hätte `doubled` den Inhalt `(2, 4, 8, 10)`.
Achte darauf, dass die Liste nach wie vor immutable bleibt.

**Hinweis**
> Der Ausdruck `i -> i*2` ist ein [Closure/Lambda](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html).
Also eine anonyme Funktion, die der Methode `map` übergeben wird.



<!-- TODO: Wir müssen hier beim nächsten Mal darauf hinweisen, dass die Liste immutable sein muss und was das bedeutet. -->

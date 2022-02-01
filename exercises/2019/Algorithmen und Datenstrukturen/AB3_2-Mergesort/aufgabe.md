---
title: aufgabe
author:
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 2
    - major: computer science
    - institution: Technische Hochschule Mittelhessen
    - course: Algorithmen und Datenstrukturen
    - requires: generics
    - requires: classes
    - requires: merge sort
    - requires: functions
    - requires: algorithm design
    - teaches: merge sort
    - teaches: object-oriented design
    - teaches: algorithm design
    - teaches: big O notation
    - submission: code
    - approved: Christopher Schölzel
lang: de-DE
solution-size: 75
id: 2392208b-5263-42f8-a4d1-63cd2f7ebb8e
---

Mergesort ist mit seiner Worst-Case-Laufzeit von O(n log n) einer der schnellsten Sortieralgorithmen und liefert zudem noch eine stabile Sortierung.
Für das Sortieren von Random-Access-Datenstrukturen wie Arrays oder Arraylisten wird zwar meistens eine Quicksort vorgezogen, weil dieser in der Praxis ein wenig schneller ist.
Das gilt aber explizit *nicht* für verkettete Datenstrukturen, in denen der Zugriff nur von einem der beiden Enden möglich ist.

In einer doppelt verketteten Liste lässt sich dieser Algorithmus außerdem auch sehr schön *in-place* implementieren - also mit einem konstanten zusätzlichen Speicherverbrauch von O(1), wobei wir hier den Speicherverbrauch auf dem Stack für die rekursiven Aufrufe vernachlässigen.

## Aufgabe

Implementieren Sie im Paket `de.thm.mni.aud` eine Unterklasse `SortableDLL` der in den Tests enthaltenen Klasse `de.thm.mnu.aud.util.DoublyLinkedList<E>`.
Ihre Klasse soll zusätzlich die `void`-Methode `sort(MergeSortListener<E>)` anbieten, die die Liste mit einem Mergesort sortiert und als optionalen Parameter einen Listener übernimmt, der zur Inspektion verwendet werden kann.
Die Methode darf dabei höchstens ein einziges Objekt vom Typ `DoublyLinkedList.DoublyLinkedNode<E>` erzeugen.
Ansonsten ist kein weiterer Speicherverbauch im Heap erlaubt.

## Tipps

### Sortierbarkeit

Die Inhalte ihrer Liste müssen vergleichbar sein.
Das können Sie am besten mit einer oberen Schranke für den Typparameter realisieren - also indem Sie Ihre Liste wie folgt definieren:

```java
public class SortableDLL<E extends Comparable<E>> extends DoublyLinkedList<E> {
    ...
}
```

Damit ist sichergestellt, dass jedes Element der Liste mit jedem anderen mit Hilfe der Methode `compareTo` verglichen werden kann.

### Codevorgaben

Achten Sie auf Teile der Implementierung von `DoublyLinkedList<E>`, die als `public` oder `protected` deklariert wurden, sowie auf weitere in den Tests enthaltene Hilfsklassen.
Versuchen Sie sich einen Überblick zu verschaffen - Diese können und sollen Sie für Ihre Implementierung verwenden.

* Es muss eine Methode `void sort(MergeSortListener<E>)`und eine Methode `void sort()` vorhanden sein. Hierbei sollte die zweite Methode die Erste aufrufen.
* Die Klasse `DoublyLinkedList.DoublyLinkedNode<E>` repräsentiert innere Knoten.
    Sie können auf deren Variablen `content`, `next` und `prev` direkt zugreifen.
* Die statische Methode `DoublyLinkedList.link(DoublyLinkedList.DoublyLinkedNode<E>, DoublyLinkedList.DoublyLinkedNode<E>)` hilft Ihnen dabei, zwei Knoten der Liste sauber miteinander zu verknüpfen.
    Sie entspricht der Implementierung im Pseudocode der doppelt verketteten Liste aus der Vorlesung.
* Die Klasse `DoublyLinkedList<E>` besitzt einige Klasseninvarianten.
    Mit der Methode `checkClassInvariant()` können sie überprüfen, ob sie aus Versehen beim Sortieren eine dieser Invarianten zerstört haben.
    Von dieser Methode gibt es auch eine Variante, bei der Sie den Start- und Endknoten angeben können, um nur eine beliebige Subliste zu überprüfen.
* Als Implementierung für das Interface `MergeSortListener<E>` existieren ein leerer `MergeSortAdapter<E>`, der keinen zusätzlichen Aufwand erzeugt und ein `MergeSortVisualizer<E>`, der die rekursiven Aufrufe ihrer Mergesortimplementierung als String visualisiert.
    Letzeren können Sie verwenden, um Bugs in ihrem Code zu identifizieren.
* Auch wenn die Aufgabe kompliziert aussieht: Die Musterlösung hat nur etwa 60 Zeilen Code und diese entsprechen im Wesentlichen dem Pseudocode auf den Folien.
* Es ist nötig einen gewissen "Hack" zu benutzen, damit man In-Place arbeitet. Versuchen Sie erst einmal die Aufgabe zu lösen, bevor Sie sich hieran trauen. Wo entsteht der zusätzliche Speicherverbrauch? Wie lässt er sich vermeiden?
* Es ist notwendig einen Listener mitzuführen, schauen Sie sich dessen Interface an. Er wird nur an drei Schlüsselpositionen aufgerufen und stört Sie ansonsten nicht. 
    Ich habe versucht Ihnen mit den Tests und dem vorgegebenen Code so viel Hilfestellungen wie möglich an die Hand zu geben, um die Aufgabe ohne Frust zu bewältigen. :)
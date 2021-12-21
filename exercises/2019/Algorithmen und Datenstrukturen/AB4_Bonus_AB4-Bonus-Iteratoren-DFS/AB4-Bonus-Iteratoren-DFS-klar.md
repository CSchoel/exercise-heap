---
title: AB4-Bonus-Iteratoren-DFS-klar
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

# Der Wettkampf der Iteratoren - Höhenflug der Tiefentaube

### Vorwort

Ein DFS-Iterator (Depth-First-Search-Iterator) traversiert einen Baum nach dem Prinzip der Tiefensuche. D.h. Er verfolgt einen Ast zunächst bis zu seinem Ende, bevor er einen Rückschritt zur nächsten Gabelung macht und von dort aus den nächsten Ast bis zum Ende verfolgt.

### Aufgabe 1

Implementieren sie einen DFS-Iterator, der mindestens die notwendigen Methoden des `Iterator<E>`-Interfaces hat:
- `public boolean hasNext()`
- `public E next()`

Achten sie darauf, dass der Iterator nach dem Prinzip der Tiefensuche arbeitet und schrittweise vorgeht, d.h. bei jedem Schritt den nächsten Knoten berechnet.

### Aufgabe 2

Welche Vorteile bietet ein DFS-Iterator gegenüber einem BFS-Iterator (der nach dem Prinzip der Breitensuche arbeitet)?

[Abgabe Aufgabe 2 in Gildamesh](Link einfügen)

### Formalia:

- Schreiben sie eine Klasse `public class DFSIterator<E> implements Iterator<E>`, die einen DFS-Iterator implementiert.
- Der Iterator soll über einen Baum iterieren, der das Interface `TreeInterface<E>` implementiert.    
  - Sowohl das Interface, als auch eine implementierende Klasse `Tree<E>` finden sie in den Codevorgaben. Ihr Iterator sollte nur die Methoden des Interfaces benutzen (das wird in den Tests geprüft).
  - Dort finden sie außerdem ein "Skelett" für die Iteratorklasse (`DFSIterator`). Nutzen sie dieses.
- Innerhalb des Iterators dürfen sie zur Zwischenspeicherung von Knoten nur eine `Deque<E>` und eine Referenz auf einen Kindindex benutzen.
  - Außerdem dürfen sie von der `Deque` nur die Methoden `addFirst(e)`, `removeFirst()` und `peekFirst()` benutzen. Damit hat sie das Verhalten eines Stacks (die Klasse `Stack` darf nicht verwendet werden, da sie als veraltet gilt).
  - Speichern sie bei der Erstellung des Iterators nicht alle Knoten in der `Deque`. Ihr Iterator muss bei jedem Aufruf von `next()` schrittweise vorgehen.


#### Hinweise:

>- Überlegen sie sich, was sie genau in der `Deque` speichern. Evtl. ist es sinnvoll, eine "Datenklasse" zu erstellen, die zusätzliche Informationen zu einem Knoten enthält.

#### Codevorgabe:

TreeInterface.java
``` Java
package iterators;

import java.util.List;

public interface TreeInterface<E> extends Iterable<E> {

    /**
     * @return the node's content
     */
    public E getContent();

    /**
     * @return a list of the node's children
     */
    public List<TreeInterface<E>> getChildren();

    /**
     * Adds a node to this node's children.
     *
     * @param child the node to add
     */
    public void addChild(TreeInterface<E> child);

    /**
     * Creates a node from a value and adds it to this node's children.
     * This function returns this node to make chaining possible.
     *
     * @param child the value to create the node from
     * @return this node
     */
    public TreeInterface<E> addChild(E child);
}
```

Skelett von DFSIterator.java. Vervollständigen sie dieses.
``` Java
package iterators;

public class DFSIterator<E> implements Iterator<E> {

    public DFSIterator(TreeInterface<E> tree) {
    }

    @Override
    public boolean hasNext() {
    }

    @Override
    public E next() {
    }
}
```

Tree.java
``` Java
package iterators;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Tree<E> implements TreeInterface<E> {
    private final E content;
    private List<TreeInterface<E>> children = new LinkedList<>();

    public Tree(E content) {
        this.content = content;
    }

    public E getContent() {
        return content;
    }

    @Override
    public List<TreeInterface<E>> getChildren() {
        return children;
    }

    @Override
    public void addChild(TreeInterface<E> child) {
        children.add(child);
    }

    @Override
    public TreeInterface<E> addChild(E child) {
        TreeInterface<E> tree = new Tree<>(child);
        addChild(tree);
        return this;
    }

    @Override
    public Iterator<E> iterator() {
        return new DFSIterator<E>(this);
    }
}
```

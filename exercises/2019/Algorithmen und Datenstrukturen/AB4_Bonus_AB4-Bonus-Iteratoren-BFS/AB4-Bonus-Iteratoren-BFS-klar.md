---
title: AB4-Bonus-Iteratoren-BFS-klar
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

# Der Wettkampf der Iteratoren - Der Angriff des Breitenhörnchens

### Einleitung

Ein BFS-Iterator (Breadth-First-Search-Iterator) traversiert einen Baum nach dem Prinzip der Breitensuche. D.h. er besucht zunächst alle Knoten einer Ebene, bevor er eine Ebene tiefer geht.


### Aufgabe 1

Implentieren sie einen BFS-Iterator, der mindestens die notwendigen Methoden des `Iterator<E>` Interfaces hat.
- `public boolean hasNext()`
- `public E next()`

Achten sie darauf, dass der Iterator nach dem Prinzip der Breitensuche arbeitet und schrittweise vorgeht, d.h. bei jedem Schritt den nächsten Knoten berechnet.

### Aufgabe 2

Was für Vorteile bietet ein BFS-Iterator gegenüber einem DFS-Iterator (der nach dem Prinzip der Tiefensuche arbeitet).

## Formalia:

- Schreiben sie eine Klasse `public class BFSIterator<E> implements Iterator<E>`, die einen BFS-Iterator implementiert.
- Der Iterator soll über einen Baum iterieren, der das Interface `TreeInterface<E>` implementiert.    
  - Sowohl das Interface, als auch eine implementierende Klasse `Tree<E>` finden sie in den Codevorgaben. Ihr Iterator sollte nur die Methoden des Interfaces benutzen (das wird in den Tests geprüft).
  - Dort finden sie außerdem ein "Skelett" für die Iteratorklasse (`BFSIterator`). Nutzen sie dieses.
- - Innerhalb des Iterators dürfen sie zur Zwischenspeicherung von Knoten nur eine `Queue<E>`
  - Sie dürfen nur die Methoden `offer(e)`, `poll()` und `peek()` der `Queue` verwenden.
  - Speichern sie bei der Erstellung des Iterators nicht alle Knoten in der `Queue`. Ihr Iterator muss bei jedem Aufruf von `next()` schrittweise vorgehen.

#### Hinweise:

  >- Überlegen sie sich, was sie genau in der `Queue` speichern. Evtl. ist es sinnvoll, eine "Datenklasse" zu erstellen, die zusätzliche Informationen zu einem Knoten enthält.

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

Skelett von BFSIterator.java. Vervollständigen sie dieses.
``` Java
package iterators;

public class BFSIterator<E> implements Iterator<E> {

    public BFSIterator(TreeInterface<E> tree) {
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
        return new BFSIterator<E>(this);
    }
}
```

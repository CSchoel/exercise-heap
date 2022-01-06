---
title: AB4-Bonus-Iteratoren-IDFS-klar
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
id: 7de5ff9e-8cb3-428e-92f3-b951bcba61c0
---

# Der Wettkampf der Iteratoren - Die Rückkehr der Tiefentaube

### Einleitung

Ein IDDFS-Iterator (Iterative-Deepening-Depth-First-Search-Iterator) traversiert einen Baum nach dem Prinzip der beschränkten Tiefensuche mit iterativ wachsender Schranke. Dabei fängt er mit Tiefe von 0 an. Im nächsten Durchlauf führt er eine Tiefensuche bis zur Tiefe 1 aus. Die Tiefe wächst solange, bis der gesamte Baum besucht wurde.

### Aufgabe 1

Implentieren sie einen IDDFS-Iterator, der mindestens die notwendigen Methoden des `Iterator<E>` Interfaces hat.
- `public boolean hasNext()`
- `public E next()`

Achten sie darauf, dass der Iterator nach dem Prinzip der iterativen Tiefensuche arbeitet und schrittweise vorgeht, d.h. bei jedem Schritt den nächsten Knoten berechnet.

#### Aufgabe 2

Was für Vorteile bietet ein IDDFS-Iterator gegenüber einem DFS-Iterator und einem BFS-Iterator.

#### Formalia:

- Schreiben sie eine Klasse `public class IDDFSIterator<E> implements Iterator<E>`, die einen IDDFS-Iterator implementiert.
- Der Iterator soll über einen Baum iterieren, der das Interface `TreeInterface<E>` implementiert.    
  - Sowohl das Interface, als auch eine implementierende Klasse `Tree<E>` finden sie in den Codevorgaben. Ihr Iterator sollte nur die Methoden des Interfaces benutzen (das wird in den Tests geprüft).
  - Dort finden sie außerdem ein "Skelett" für die Iteratorklasse (`IDDFSIterator`). Nutzen sie dieses.
- Innerhalb des Iterators dürfen sie zur Zwischenspeicherung von Knoten nur eine `Deque<E>` und eine Referenz auf einen Kindindex, sowie einen Tiefenzähler benutzen.
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

Skelett von IDDFSIterator.java. Vervollständigen sie dieses.
``` Java
package iterators;

public class IDDFSIterator<E> implements Iterator<E> {

  public IDDFSIterator(TreeInterface<E> tree) {
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
        return new IDDFSIterator<E>(this);
    }
}
```

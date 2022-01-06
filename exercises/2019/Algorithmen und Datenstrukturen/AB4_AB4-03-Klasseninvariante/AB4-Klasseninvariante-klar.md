---
title: AB4-Klasseninvariante-klar
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
id: 03f6ecd8-e83e-43fe-8338-d89b8a6014c3
---

# Klasseninvariante

## Vorwort
Im Folgenden wird der Pseudocode zu einem Binärbaum gegeben.

```
# Definitions for the binary tree

structure BTree<E> { root: BNode<E>, size: int }

algorithm root(this: BTree<E>): BNode<E>
  return copy(this.root)

algorithm isEmpty(this: BTree<E>): boolean
  return this.root == None

algorithm size(this: BTree<E>): int
  return this.size

algorithm add(this: BTree<E>, value: E)
  if isEmpty(this) then
    this.root = singletonNode(value)
    size += 1
  else if addChild(this.root, value) then
    size += 1

# Definitions for nodes of the binary tree

structure BNode<E> { value: E, left: BNode<E>, right: BNode<E> }

algorithm value(this: BNode<E>): E
  return copy(this.value)

algorithm left(this: BNode<E>): BNode<E>
  return copy(this.left)

algorithm right(this: BNode<E>): BNode<E>
  return copy(this.right)

algorithm addChild(this: BNode<E>, value: E): boolean
  if value < value(this) then
    if left(this) = None then
      this.left = singletonNode(value)
      return true
    else
      return addChild(left(this), value)
  else if value > value(this) then
    if right(this) = None then
      this.right = singletonNode(value)
      return true
    else
      return addChild(right(this), value)
  else
    return false

# Helper definitions for creating an empty binary tree
# and a node for the binary tree with a value, but no child
# (i.e. the constructors)

algorithm emptyTree(): BTree<E>
  tree = new BTree<E>
  tree.root = None
  tree.size = 0
  return tree

algorithm singletonNode(value: E): BNode<E>
  node = new BNode<E>
  node.value = value
  node.left  = None
  node.right = None
  return node
```

## Aufgabe 3.1
Beantworten Sie die folgende Fragen: Kann der oben gegebene Binärbaum Elemente doppelt enthalten oder nicht? 
Erläutern Sie ebenfalls, an welchem Ausdruck bzw. an welcher Anweisung sich diese Eigenschaft feststellen lässt.

## Aufgabe 3.2
Sei `node` ein Knoten des Binärbaums `BTree`, dann ist `nodes(node)` die Menge aller Knoten (inklusive `node` selbst) in `node`.
nodes(node) ist definiert als:

![exercise-2](https://homepages.thm.de/~cslz90/kurse/ad18/static/AB4-Klasseninvariante-exercise-2.png)

Beweisen Sie, dass die Klasseninvarianten `1` und `2` stets für alle `BTree` gelten.

Sei `T` ein `BTree`, dann sind die Klasseninvarianten:

#### Klasseninvariante 1

![exercise-2-invariant-1](https://homepages.thm.de/~cslz90/kurse/ad18/static/AB4-Klasseninvariante-exercise-2-invariant-1.png)

**Beschreibung**: Die Anzahl der Werte, die `T` speichert, ist stets die Anzahl der Knoten im selben Baum.

#### Klasseninvariante 2

![exercise-2-invariant-2](https://homepages.thm.de/~cslz90/kurse/ad18/static/AB4-Klasseninvariante-exercise-2-invariant-2.png)

**Beschreibung**: Für alle Knoten `N` in einem beliebigen Binärbaum `T` gilt: Jeder Knoten `A` des linken Teilbaums hat einen kleineren Wert als `N` und jeder Knoten `B` des rechten Teilbaums hat einen größeren Wert als `N`.

### Aufgabe 3.2.1
Beweisen Sie, dass die Klasseninvarianten nach dem Aufruf des Konstruktors gelten. Da der in den Folien verwendete Pseudocode keine "richtigen" Konstruktoren hat, soll im Rahmen dieser Aufgabe die Prozedur `emptyTree()` als Konstruktor angesehen werden.

### Aufgabe 3.2.2
Beweisen Sie, dass die öffentlichen Prozeduren `root(BTree<E>)`, `isEmpty(BTree<E>)`, `size(BTree<E>)` und `add(BTree<E>, E)` nicht gegen die Klasseninvariante verstoßen. Sie dürfen davon ausgehen, dass die Invarianten vor dem Aufruf der Prozeduren gelten.

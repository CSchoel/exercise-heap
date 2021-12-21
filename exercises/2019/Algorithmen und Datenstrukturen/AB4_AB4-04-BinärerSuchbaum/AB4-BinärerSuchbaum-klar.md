---
title: AB4-BinärerSuchbaum-klar
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

# Binärer Suchbaum

## Aufgabe 1)

Realisieren Sie im Package `binarytree` einen binären Suchbaum für alle Datentypen, die vergleichbar sind.
Legen Sie dazu eine Klasse `BinaryTree` in besagtem Package an, die die folgende Schnittstelle implementiert:

```java
package binarytree;

import java.util.Comparator;

public abstract class ABinaryTree<T> {

  protected final Comparator<T> comparator;

  public ABinaryTree(Comparator<T> comparator) {
    this.comparator = comparator;
  }

  /**
   * @return the root node of this tree.
   */
  public abstract ABinaryTreeNode<T> root();

  /**
   * Add a value of type T to this binary tree.
   */
  public abstract void add(T value);

  /**
   * Remove a value of type T from this binary tree.
   */
  public abstract void remove(T value);

  /**
   * Check, if the value of type T exists in this tree.
   */
  public abstract boolean contains(T value);

  /**
   * @return true, if this tree is empty, false otherwise.
   */
  public abstract boolean isEmpty();

  /**
   * The number of elements in this tree.
   */
  public abstract int size();

}
```

Ein einzelner Knoten des `BinaryTree` wird von der Schnittstelle `ABinaryTreeNode` repräsentiert, von der Sie ebenfalls eine Realisierung anfertigen sollen.
Die Schnittstelle dafür wird im Folgenden aufgeführt:

```java
package binarytree;

public abstract class ABinaryTreeNode<T> {

  /**
   * @return the value stored in this node.
   */
  public abstract T value();

  /**
   * @return the left subtree of this node.
   */
  public abstract ABinaryTreeNode<T> left();

  /**
   * @return the right subtree of this node.
   */
  public abstract ABinaryTreeNode<T> right();

}
```

### Hinweise
* Dieser binäre Suchbaum soll keine Elemente doppelt enthalten.
* Nutzen Sie die bereitgestellten JUnit-Tests während Ihrer Arbeit.
* Es darf kein vorgefertigter Baum (der Java-API) verwendet werden.

## Hilfestellungen

Als Hilfestellungen werden im Folgenden für die Methoden `contains`, `add` und `remove` mögliche Implementierungen in Pseudocode vorgegeben.
Bitte beachten Sie, dass im Foliensatz 10 diese Algorithmen in ähnlicher Form vorgegeben wurden.
Die dort aufgeführten Algorithmen sind jedoch für binäre Suchbäume gedacht, die Elemente **mehrfach** enthalten können.

### Pseudocode für `contains` auf Basis von `bsearch`
```java
algorithm bsearch(haystack: BTNode<E>, needle: E)
  if haystack = None then
    return None
  if value(haystack) = needle then
    return haystack
  if value(haystack) > needle then
    return bsearch(right(haystack), needle)
  else
    return bsearch(left(haystack), needle)
```

```java
algorithm contains(haystack: BTNode<E>, needle: E)
  if bsearch(haystack, needle) = None then
    return false
  else
    return true
```

### Pseudocode für `add`
```java
algorithm sortedInsert(tree: BTNode<E>, el: E)
  next: BTNode<E>
  if el < value(tree) then
    next := left(tree)
  else if el > value(tree) then
    next := right(tree)

  if next = None then
    addChild(tree, el)
  else
    sortedInsert(next, el)
```

### Pseudocode für `remove`
```java
algorithm remove(tree: BTree<E>, el: E)
  tempRoot := new BTNode<E>(None, root(tree))
  res := sortedRemove(root(tree), tempRoot, el)
  tree.root := tempRoot.left
  tree.root = None
  return res

algorithm sortedRemove(node: BTNode<E>, parent: BTNode<E>, el: e)
  if value(node) < el then
    return sortedRemove(left(node), node, el)
  if value(node) > el then
    return sortedRemove(right(node), node, el)

  hasLeft := left(node) != None
  hasRight := right(node) != None
  if hasLeft and hasRight then
    minN, minP := findMin(right)
    node.value = minN.value
    sortedRemove(minN, minP, minN.value)
  if hasLeft:
    replace(node, parent, left(node))
  else:
    replace(node, parent, right(node))
  return true

algorithm findMin(node: BTNode<E>)
  if left(node) = None then
    return node
  return findMin(left(node))

algorithm replace(node: BTNode<E>, in: BTNode<E>, with: BTNode<E>)
  if left(in) = node then
    in.left = with
  else
    in.right = with
```

## Aufgabe 2)

Fügen Sie die beiden folgenden Methoden der abstrakten Klasse `ABinaryTree` hinzu und implementieren Sie sie.

```java
/**
 * Return an iterator, which traverses this tree in breadth-first-order.
 */
public abstract java.util.Iterator<T> breadthFirstIterator();

/**
 * Return an iterator, which traverses this tree in depth-first in-order.
 */
public abstract java.util.Iterator<T> depthFirstIterator();
```

### Hinweis
* Der in dieser Aufgabe zu implementierende Iterator muss lediglich die Operationen `hasNext()` und `next()` implementieren. Interessierte Studenten dürfen sich auch gerne an der `remove()`-Operation versuchen. Die Implementierung dieser Operation ist optional und wird deswegen nicht von den UnitTest überprüft.

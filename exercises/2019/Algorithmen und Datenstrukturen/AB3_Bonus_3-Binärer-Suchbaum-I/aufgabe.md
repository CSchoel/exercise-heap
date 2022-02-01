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
    - requires: interfaces
    - requires: classes
    - requires: binary search
    - requires: binary search tree
    - requires: generics
    - teaches: binary search tree
    - teaches: binary search
    - submission: code
lang: de-DE
solution-size: 180
id: 66789e3c-40dd-4af3-b008-04051ab60b5c
---

# Binärer Suchbaum I

Realisieren Sie im Package `binarytree` einen binären Suchbaum. 
Legen Sie dazu eine Klasse `BinaryIntTree` in besagtem Package an, die die folgende Schnittstelle implementiert:

```java
package binarytree;

public abstract class ABinaryIntTree {

  /**
   * @return the root node of this tree.
   */
  public abstract ABinaryIntTreeNode root();

  /**
   * Add an integer value into this binary tree.
   */
  public abstract void add(int value);

  /**
   * Remove an integer value from this binary tree.
   */
  public abstract void remove(int value);

  /**
   * Check, if the integer value exists in this tree.
   */
  public abstract boolean contains(int value);

  /**
   * @return true, if this tree is empty, false otherwise.
   */
  public abstract boolean isEmpty();

  /**
   * @return the number of elements in this tree.
   */
  public abstract int size();

}
```

Ein einzelner Knoten des `BinaryIntTree` wird von der Schnittstelle `ABinaryIntTreeNode` repräsentiert, von der Sie ebenfalls eine Realisierung anfertigen sollen.
Die Schnittstelle dafür wird im Folgenden aufgeführt:

```java
package binarytree;

public abstract class ABinaryIntTreeNode {

  /**
   * @return the value stored in this node.
   */
  public abstract int value();

  /**
   * @return the left subtree of this node.
   */
  public abstract ABinaryIntTreeNode left();

  /**
   * @return the right subtree of this node.
   */
  public abstract ABinaryIntTreeNode right();

}
```

## Hinweise
* Dieser binäre Suchbaum soll keine Elemente doppelt enthalten.
* Nutzen Sie die bereitgestellten JUnit-Tests während Ihrer Arbeit.
* Es darf kein vorgefertigter Baum (der Java-API) verwendet werden.

## Hilfestellungen

Als Hilfestellungen werden im Folgenden für die Methoden `contains`, `add` und `remove` mögliche Implementierungen in Pseudocode vorgegeben.
Bitte beachten Sie, dass im Foliensatz 10 diese Algorithmen in ähnlicher Form vorgegeben wurden.
Die dort aufgeführten Algorithmen sind jedoch für binäre Suchbäume gedacht, die Elemente **mehrfach** enthalten können.

### Pseudocode für `contains` auf Basis von `bsearch`
```scala
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

```scala
algorithm contains(haystack: BTNode<E>, needle: E)
  if bsearch(haystack, needle) = None then
    return false
  else
    return true
```

### Pseudocode für `add`
```scala
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
```scala
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

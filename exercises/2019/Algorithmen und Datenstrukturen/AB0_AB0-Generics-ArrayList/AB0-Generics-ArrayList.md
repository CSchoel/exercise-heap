---
title: AB0-Generics-ArrayList
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

# ArrayList
## Aufgabe

Erstellen Sie in Java eine generische Klasse `GenericArrayList` in einem Package `arraylist` mit einem Konstruktor, der die Kapazität des GenericArrayBasilist übergeben bekommt.
Implementieren Sie das folgende generische Interface GenericList und vervollständigen Sie die Methoden:

```java
public interface GenericList<E> {
    E get(int idx);              // retrieve element at index
    void set(E el, int idx);     // overwrite element at index
    int size();                  // get number of elements
    void add(E el);              // append to end
    void remove(int idx);        // remove at index
    void insert(E el, int idx);  // insert at index
}
```

(Für Hilfe: Siehe Foliensatz 1)

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
    - submission: code
    - requires: array list
    - teaches: array list
    - requires: classes
    - requires: functions
lang: de-DE
solution-size: 65
id: f2f5cb8f-69dc-460c-85ce-8cf1c5188bb7
---

# ArrayList

## Aufgabe

Erstellen Sie in Java eine generische Klasse `GenericArrayList` in einem Package `arraylist` mit einem Konstruktor, der die Kapazität der Liste übergeben bekommt.
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

---
title: AB5-Dijkstra-Wegfindung-QueueHinweise
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
id: ca89f321-5312-4cda-a739-54e789e88db9
---

#### Hinweise für den Pseudocode aus der Vorlesung
* Diese Hinweise sind nur hilfreich, falls Sie sich für eine Version mit einer Queue entschieden haben. Dies ist nicht verpflichtend und nur eine Möglichkeit

* Die Java API kennt eine `PriorityQueue<E>`. Nutzen Sie diese, sie besitzt unter anderem die Funktionen `offer(E elem) : void` und `poll() : E`
* Die genannte Queue übernimmt nur ein Element und priorisiert dieses anhand eines internen Comparators. Da für eine `PriorityQueue<Knot>` unklar ist, wonach bei einem Knoten priorisiert werden soll, muss der Queue ein neuer Comparator übergeben werden. Hierbei legen Sie fest, nach welchem Wert verglichen werden soll.
* Achtung: Es wird nur beim Einfügen in die Queue sortiert. Falls der Wert nachträglich geändert wird, muss das Element entfernt / neu hinzugefügt werden, da sonst die alte Reihenfolge beibehalten wird.

```

Comparator<Apple> appleComparer = Comparator.comparing(apple -> eatInfo.get(apple).tastiness);
PriorityQueue<Knot> eatQueue = new PriorityQueue(appleComparer);

```

Beispiel aus der Übungsstunde:

```

class Apple{} //Äpfel, die du essen willst

class AppleInfo{ // Dein Gedächtnis, wie lecker ein Apfel ist

  int tastiness; //Wie lecker ist ein Apfel?
  AppleInfo(int tastiness){this.tastiness = tastiness;}
}

// Dein Freund sagt dir, wie lecker ein Apfel ist.
Map<Apple, AppleInfo> eatInfo = new HashMap<>();

//Ich will den besten Apfel zuerst essen (niedrigste Zahl)
Comparator<Apple> appleComparer = Comparator.comparing(apple -> eatInfo.get(apple).tastiness);
PriorityQueue<Knot> eatQueue = new PriorityQueue(appleComparer);

```

* In diesem Comparator wird nun nach dem in der Map `knotInfos` gespeicherten Gewicht priorisiert
* Achtung: Es wird nur bei dem Hinzufügen die Queue sortiert.

```

Apple apple10 = new Apple();
Apple apple5 = new Apple();

eatInfo.put(apple10,new AppleInfo(10));
eatInfo.put(apple5, new AppleInfo(5));

eatQueue.offer(apple10);
eatQueue.offer(apple5);

```

* Queue hat folgende Reihenfolge mit Wertigkeit:
* 1. apple5 -> 5
* 2. apple10 -> 10

```

eatQueue.poll(); // Liefert apple5
eatQueue.poll(); // Liefert apple10

```

* PROBLEM:

```

eatQueue.offer(apple10);
eatQueue.offer(apple5);

```

* Aktuelle Reihenfolge: 1. apple5 , 2. apple10

```

eatInfo.get(apple5).tastiness = 200; // Apfel5 ist verschimmelt

eatQueue.poll(); // ??

```

* Was kommt hier raus?
* Erwartet: apple10
* Aber: prinzipiell undefiniert!
* Tatsächlich: apple5 (mit Wert 200)
* Warum: Der Wert wurde geändert, nachdem der Apfel hinzugefügt wurde.
* Die Queue wurde nicht neu geordnet

* Was wäre eine Lösung für das Problem?

* Wenn der Knoten in der Queue schon vorhanden ist

```

eatQueue.remove(apple5);
eatInfo.get(apple5).tastiness = 200;
eatQueue.put(apple5);

```

* Falls man den Knoten erst der Queue hinzugefügt

```

eatInfo.get(apple5).tastiness = 200;
eatQueue.put(apple5);

```
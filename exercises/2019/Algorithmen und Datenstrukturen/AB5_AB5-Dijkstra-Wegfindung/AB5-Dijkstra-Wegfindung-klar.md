---
title: AB5-Dijkstra-Wegfindung-klar
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
id: 5b3365ef-7461-454b-817d-278555b222b2
---

### Aufgabe

Gegeben ist ein zusammenhängender gewichteter Graph.
Ihre Aufgabe ist es, mithilfe des Algorithmus von Dijkstra den kürzesten Pfad von einem Startknoten zu einem Zielknoten zu finden. Die Aufgabe soll in Java programmiert werden. Ihnen werden die folgenden Klassen zur Verfügung gestellt:

* `Knot`: Repräsentiert einen Knoten und hat eine ID, um die Knoten einzigartig zu machen.
* `Edge`: Repräsentiert eine Kante und hat einen Startknoten `src` und einen Zielknoten `target` sowie ein Gewicht `distance`. Auf alle Felder kann man über Getter-Methoden zugreifen.
* `Graph`: Repräsentiert den Graphen und besitzt eine Liste an Knoten `knots` und eine Liste an Kanten `edges`, die über Getter-Methoden zu erhalten sind.

Erstellen Sie eine Klasse namens `Dijkstra` anhand des vorgefertigten Code-Gerüsts:

```java
package  dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Dijkstra {

  private class DijkstraInfo {
    int distToStart;
    Knot predecessor;
    boolean visited;

    DijkstraInfo(int distToStart, Knot predecessor, boolean visited) {
      this.distToStart = distToStart;
      this.predecessor = predecessor;
      this.visited = visited;
    }
  }

  private List<Knot> knots;
  private List<Edge> edges;
  private Map<Knot, DijkstraInfo> knotInfos = new HashMap<>();
  // ... 

  Dijkstra(Graph graph) {
    knots = graph.getKnots();
    edges = graph.getEdges();
    // ... 
  }

  void execute(Knot start) {
    // TODO: implement
  }

  List<Knot> getShortestPath(Knot start, Knot target) {
    // TODO: implement
  }

}
```

In `execute` soll der Algorithmus von Dijkstra angewendet werden und der kürzeste Pfad von der Startinsel `start` zu jeder anderen bestimmt werden. Speichern Sie sich die Informationen, die Sie dadurch erhalten, sinnvoll in der Datenstruktur `knotInfos` intern ab. 
Die Methode `getShortestPath` soll nun den kürzesten Pfad vom Knoten `start` bis zum Knoten `target` ermitteln. Zurückgegeben wird eine Liste aller Knoten, die dabei besucht worden sind.
Falls es keinen Weg gibt, soll eine leere Liste zurückgegeben werden.

Fügen Sie **alle** genannten Klassen in einem Package namens `dijkstra` zusammen.

#### Allgemeine Hinweise: 
* Achten Sie darauf, dass sich die Klassen im richtigen Package befinden.
* Benennen Sie die Methoden genau wie in der Aufgabenstellung beschrieben und achten Sie auf korrekte Typen.
* Die oben genannten Klassen erhalten Sie beim Download der Tests über Dozentron.
* Nutzen Sie das Ihnen gegebene Code-Gerüst. Sie können dieses aber beliebig erweitern.
* Es kann helfen, sich zusätzlich zu den oben genannten Methoden noch Hilfsmethoden zu schreiben.
* Nähere Infos dazu wie der Algorithmus von Dijkstra funktioniert und wie ein Graph aufgebaut ist, finden Sie im Vorlesungsskript. Nutzen Sie den Pseudocode, er gibt Ihnen bereits viel vor.

#### Hinweise für den Pseudocode aus der Vorlesung
* Diese Hinweise sind nur hilfreich, falls Sie sich für eine Version mit einer Queue entschieden haben. Dies ist nicht verpflichtend und nur eine Möglichkeit

* Die Java API kennt eine `PriorityQueue<E>`. Nutzen Sie diese, sie besitzt unter anderem die Funktionen `offer(E elem) : void` und `poll() : E`
* Die genannte Queue übernimmt nur ein Element und priorisiert dieses anhand eines internen Comparators. Da für eine `PriorityQueue<Knot>` unklar ist, wonach bei einem Knoten priorisiert werden soll, muss der Queue ein neuer Comparator übergeben werden. Hierbei legen Sie fest, nach welchem Wert verglichen werden soll.
* Achtung: Es wird nur beim Einfügen in die Queue sortiert. Falls der Wert nachträglich geändert wird, muss das Element entfernt / neu hinzugefügt werden, da sonst die alte Reihenfolge beibehalten wird.

```

Comparator<Apple> appleComparer = Comparator.comparing(apple -> eatInfo.get(apple).tastiness);
PriorityQueue<Knot> eatQueue = new PriorityQueue(appleComparer);

```

* Weiterführende Informationen über die Queue mit Beispiel: [Moodle-Datei](https://moodle.thm.de/mod/page/view.php?id=240428)
## Musterlösung für Aufgabe 2

Die `TreeMap` sortiert ihre Elemente nach den Schlüsseln, daher müssen die Keys hier `Comparable` sein
oder ein Komparator-Objekt muss mitgegeben werden.

Die `HashMap` hingegen sortiert nicht, braucht aber eine sinnvolle Implementierung der Methode `hashCode`.

In beiden Fällen sollten die Schlüssel unveränderlich sein, bzw. man muss aufpassen, dass man sie nicht verändert,
während sie in der Map gespeichert sind.

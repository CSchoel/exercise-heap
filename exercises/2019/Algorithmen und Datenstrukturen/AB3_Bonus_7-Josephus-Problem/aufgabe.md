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
lang: de-DE
solution-size: 0
---

## Josephus-Problem

Das Spiel stellt eine besondere Form des "Wichtelns" dar:

Jeder Teilnehmer bringt als Geschenk eine beliebige Anzahl Münzen mit.
Alle Teilnehmer setzen sich im Kreis hin und das Spiel läuft wie folgt ab:
Der erste Teilnehmer wählt den direkten Nachbarn mit den meisten Münzen und nimmt ihm diese ab. Dieser Nachbar scheidet **sofort** aus.
Danach kommt der nächste Teilnehmer auf der linken Seite an die Reihe. Dieser wählt wieder den direkten Nachbarn mit den meisten Münzen und nimmt ihm diese ab. Dieser Nachbar scheidet **sofort** aus.

Dies wird so lange im Kreis wiederholt, bis nur noch ein Teilnehmer übrig ist.

Haben beide Nachbarn eines Teilnehmers gleich viele Münzen, wählt der Teilnehmer den linken Nachbarn.

### Aufgabe:

Sie erhalten eine beliebige Anzahl Zeilen als Input. In jeder Zeile steht eine (natürliche) Zahl. Jede Zeile repräsentiert einen Teilnehmer, der über die jeweilige Zeilennummer identifiziert wird. Die dort stehende Zahl gibt die Anzahl der Münzen des Teilnehmers an.

Führen sie die oben genannten Simulationsschritte durch um zu ermitteln, welcher Teilnehmer am Ende übrig bleibt. Ihre Ausgabe ist die Zeilennummer, der dieser Teilnehmer zugeordnet ist und die Anzahl Münzen, die er nun besitzt. Beide Werte stehen in der selben Zeile durch ein Semikolon getrennt.

Beginnen sie bei der ersten Zeile.

### Hinweise:

- Die Zeilen werden mit `0` beginnend nummeriert.
- Die Zwerge werden über ihre Zeilennummern identifiziert, d.h. Teilnehmer 0 ist der Teilnehmer, der mit der Anzahl Münzen in Zeile 0 beginnt.
- Die Teilnehmer (*die Zwerge*) sitzen im Kreis, es gibt also **immer** einen nächsten Nachbarn. Der letzte Teilnehmer (letzte Zeile der Eingabe) ist ein Nachbar des ersten Teilnehmers.
- "Der nächste Teilnehmer auf der linken Seite" ist hierbei der Teilnehmer mit der nächst geringeren Nummer.
- Der linke Teilnehmer von Teilnehmer 0 ist der Teilnehmer mit der höchsten Nummer.
- Ausgeschiedene Teilnehmer verlassen sofort den Kreis, sie werden also nicht weiter beachtet.
- Es gelten die üblichen Bedingungen für IO-Aufgaben.
- Die Teilnehmeranzahl ist immer größer als 0.
- Es muss eine sinnvolle Datenstruktur verwendet werden, die einen Kreis abbilden kann - überlegen Sie sich, welche verwendet werden kann.
- Es muss eine "Simulation" des Vorgangs stattfinden

### Beispiel

Sie erhalten folgenden Input:
```
4
2
8
0
7
```

Sie beginnen mit Teilnehmer 0 (Wert 4). Die Nachbarn sind die Teilnehmer 1 und 4. Teilnehmer 4 hat die meisten Münzen, also wird er entfernt, und seine Münzen gehen an Teilnehmer 0 über, der nun 11 Münzen besitzt.

```
11
2
8
0
X (Die Zeile ist hier mit X markiert, um zu zeigen, dass der Teilnehmer Ausgeschieden ist. Die Zeilennummern sollen aber konsistent bleiben.)
```

Als nächstes ist der Teilnehmer mit der nächst geringeren Nummer an der Reihe. Da als letztes Teilnehmer 0 an der Reihe war, geht es mit der höchsten Nummer weiter. Da Teilnehmer 4 ausgeschieden ist, ist dies Teilnehmer 3.

Seine Nachbarn besitzen 11 und 8 Münzen. Entsprechend werden die Münzen von Teilnehmer 3 angenommen und aufaddiert:

```
X
2
8
11
X
```

Nach dem selben Schema geht es dann weiter zu Teilnehmer 2:

```
X
2
19
X
X
```

Und zuletzt zu Teilnehmer 1:

```
X
21
X
X
X
```

Damit ist Teilnehmer 1 als letztes übrig und hat 21 Münzen.

Damit lautet ihre Ausgabe:
```

1;21
```

---
title: Fallstudie zur Objektorientierung
author:
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 1
    - major: computer science
    - institution: Technische Hochschule Mittelhessen
    - course: Objektorientierte Programmierung
    - subject: object orientation
lang: de-DE
solution-size: 100
source: https://git.thm.de/cslz90/oop-cs
id: c30bc00b-0646-4eb9-bf20-e7b42f5a7d8f
---

# Fallstudie zur Objektorientierung

## Radioaktive Interfaces

In dieser Aufgabe werden Sie chemische Elemente mit Interfaces und
Klassen modellieren. Ihr Programm soll nachher in der Lage sein die
folgenden Anforderungen zu erfüllen:

-   Es können radioaktive und nicht-radioaktive Atome dargestellt
    werden. Atome sind definiert durch ihre Ordnungszahl. Außerdem haben
    sie eine Masse und eine Kurschreibweise. Radioaktive Atome (und nur
    diese) haben außerdem eine Halbwertszeit.

-   Es können radioaktive und nicht-radioaktive Moleküle dargestellt
    werden. Moleküle setzen sich aus mehreren Atomen zusammen und haben
    außerdem einen Namen. Die Struktur der Zusammensetzung muss nicht
    dargestellt werden. Es reicht eine Darstellung in Form der
    **Summenformel**[^1].

-   Für alle Moleküle lässt sich die Summenformel auf der Konsole oder
    als Dialogfenster ausgeben. Die Zahlen müssen dabei nicht
    tiefgestellt werden.

-   Die Masse von Molekülen kann basierend auf der Masse ihrer Atome
    berechnet werden. Die Masse eines Moleküls ist dabei die Summe der
    Massen der enthaltenen Atome.

-   Die Halbwertszeit von radioaktiven Molekülen kann basierend auf der
    Halbwertszeit ihrer radioaktiven Atome berechnet werden. Enthält ein
    Molekül zum Beispiel die radioaktiven Atome $a_1, a_2, ... a_n$ mit
    den Halbwertszeiten $h_1, h_2, ... h_n$ (und beliebig viele andere
    nicht-radioaktive Atome), dann berechnet sich die Halbwertszeit
    $H_m$ des Moleküls wie folgt:
    $$\frac{1}{H_m} = \sum \limits^n_{i=0}\frac{1}{h_i}$$

### Bonus zur Spezifikation

-   Erlauben Sie auch die Zusammensetzung von Molekülen aus mehreren
    Molekülen.

-   Bilden Sie auch die Struktur in der die Moleküle zusammengesetzt
    sind in Ihrem Code in einer Valenzstrichformel nach dem Bohrschen
    Atommodell ab. Sie müssen dabei die einzelnen Atome in einer freien
    Graphenstruktur miteinander verbinden können. Freie Elektronenpaare
    und die Unterscheidung zwischen Einfach- und Mehrfachbindung können
    bei der Darstellung zunächst einmal ignoriert werden.

Überlegen Sie sich welche Interfaces ein Programm benötigt, dass diese
Spezifikationen erfüllen soll. Denken Sie dabei daran, die Interfaces
möglichst klein zu gestalten und damit die Verwendung an möglichst
vielen Stellen im Programm zu ermöglichen.

## Radioaktives Klassendiagramm

Überlegen Sie sich welche Klassen Sie zusätzlich zu den bereits
definierten Interfaces noch benötigen um das Programm umzusetzen und
zeichnen Sie ein entsprechendes UML-Klassendiagramm.

## Nicht-radioaktive Planänderung

Wie es in der Realität häufig der Fall ist, ändert Ihr Auftraggeber
mitten in der Planungsphase noch etwas an der Spezifikation. Er möchte,
dass Sie hundertprozentig sicherstellen, dass es in Ihrem Code nicht
möglich ist, ein Molekül zu erzeugen, das einen nicht-radioaktiven Typ
hat aber radioaktive Atome enthält.

Prüfen Sie, ob Ihre Aufteilung in Interfaces und Klassen den
Anforderungen standhält und ändern Sie das Klassendiagramm
gegebenenfalls.

## Radioaktive Implementierung

Implementieren Sie das Programm anhand Ihres Klassendiagramms. Achten
Sie dabei auf die richtige Verwendung von Interfaces und Vererbung.

Modellieren Sie als Beispiel die folgenden spaßigen Stoffe:

|                        |                                                      |
|-----------------------:|:-----------------------------------------------------|
|          Salpetersäure | HNO<sub>3</sub>                                      |
|          Schwefelsäure | H<sub>2</sub>SO<sub>4</sub>                          |
|          Nitroglycerin | C<sub>3</sub>H<sub>5</sub>N<sub>3</sub>O<sub>9</sub> |
|        Uranhexafluorid | UF<sub>6</sub>                                       |
|        Plutoniumdioxid | PuO<sub>2</sub>                                      |
|         Triuranoctoxid | U<sub>3</sub>O<sub>8</sub>                           |
| Lysergsäurediethylamid | C<sub>20</sub>H<sub>25</sub>N<sub>30</sub>           |

Enthaltene Atome:

|      |              |             |                                          |
|-----:|:-------------|:------------|:-----------------------------------------|
| Abk. | Ordnungszahl | Masse \[u\] | Halbwertszeit (falls radioaktiv)         |
|    H | 1            | 1.0079      | \-                                       |
|    C | 6            | 12.0110     | \-                                       |
|    N | 7            | 14.0067     | \-                                       |
|    O | 8            | 15.9994     | \-                                       |
|    F | 9            | 18.9984     | \-                                       |
|    U | 92           | 238.0289    | 4.468 Milliarden Jahre (<sup>238</sup>U) |
|   Pu | 94           | 244.0642    | 24110 Jahre (<sup>239</sup>Pu)           |

## Radioaktive Dateien

In Aufgabe 4 haben Sie vermutlich bemerkt, dass Sie ganz schön viele
Daten in Ihren Code mit hineinschreiben müssen. Das ist eigentlich
erstens zu aufwändig und zweitens auch schlechter Stil. Wo es möglich
ist sollte man Daten, deren Visualisierung und die dahinterliegende
Kontrollstruktur voneinander trennen, um bessere Übersicht über die
Projektstruktur zu behalten und flexibleren Code zu produzieren
(Model-View-Controller Pattern).

Außerdem ist es natürlich oft von Vorteil den Programmzustand oder die
erstellten Ergebnisse persistent zu speichern, so dass sie auch nach dem
Herunterfahren des Rechners wieder abrufbar sind.

An dieser Stelle kommt natürlich das Dateisystem ins Spiel. Fügen Sie
daher die folgende Funktionalität in Ihr Programm ein:

1.  Ermöglichen Sie es, die Liste der grundlegenden Atomeigenschaften
    (Masse, Ordnungszahl, \...) auf das Dateisystem auszulagern. Dabei
    bietet sich z.B. eine CSV-Datei an.

2.  Ermöglichen Sie auch die Speicherung von zusammengesetzten Molekülen
    in ihrer Summenformel als Datei.

### Bonusaufgabe zu Dateien

Entwickeln Sie ein möglichst kompaktes binäres Dateiformat für die
Speicherung von einer Liste von Molekülen in der Summenformel (ohne den
Namen). Dazu müssen Sie sich überlegen wie Sie die einzelnen Atomtypen
und deren Anzahl in einem `byte`-array codieren können.

## Radioaktive reguläre Ausdrücke

Sie sind mit Ihrem Programm bereits in der Lage, chemische Moleküle in
ihrer Summenformel darzustellen. Schreiben Sie nun eine Methode, mit der
Sie in der Lage sind zu prüfen ob die String-Repräsentation dieser
Summenformel auf einen beliebigen regulären Ausdruck passt. Entwerfen
Sie zum Testen auch reguläre Ausdrücke, die folgende Überprüfungen
erlauben:

-   Handelt es sich um eine organische Verbindung? (Wir betrachten hier
    vereinfacht alle Moleküle als organische Verbindung, die mindestens
    ein C-Atom besitzen.)

-   Könnte das Molekül mindestens eine OH-Gruppe enthalten?

-   Könnte das Molekül mindestens einen Kohlenstoffring enthalten (6
    Kohlenstoffatome in Hexagonalstruktur).

-   Enthält das Atom höchstens ein radioaktives Atom? (In unserem
    Beispiel können Sie davon ausgehen, dass Sie nur Uran und Plutonium
    als radioaktive Atome prüfen müssen.)

Entwerfen Sie diese regulären Ausdrücke dabei zunächst für eine etwas
abweichende String-Darstellung, bei der Sie jedes Atom mehrfach
ausschreiben, statt Zahlensymbole zu verwenden. Also z.B. HHO statt
$\text{H}_2\text{O}$. Führt die Darstellung mit Zahlen zu schwierigeren
oder zu einfacheren regulären Ausdrücken? Ist die Reihenfolge der Atome
in einer der Darstellungen relevant?

[^1]: Die Summenformel gibt die Art und Anzahl der im Molekül
    enthaltenen Atome an. Z.b: $\text{H}_2\text{O}$

---
title: Große Zahlen als BigInteger
author:
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 1
    - major: computer science
    - previous: 0ceea428-199d-4150-be99-c2ecf4dfc51d
    - subject: integer overflow
    - subject: big integer
lang: de-DE
solution-size: 6
id: 857f56c1-7566-4088-b178-2f1f91ff776e
---

In der [letzten Aufgabe](exheap://0ceea428-199d-4150-be99-c2ecf4dfc51d) haben wir gesehen, dass sich die Rechnung 84446883³ in keinem der primitiven Java-Datentypen exakt darstellen lässt.
Für die wenigen Fälle, wo eine perfekt exakte Darstellung so großer Ganzzahlen nötig ist, gibt es den Datentyp `BigInteger`.
Dieser wird wie folgt verwendet:

```java
jshell> import java.math.BigInteger

jshell> BigInteger b = BigInteger.valueOf(9);
b ==> 9

jshell> b.pow(100)
$26 ==> 265613988875874769338781322035779626829233452653394495974574961739092490901302182994384699044001
```

Erstellen Sie eine `BigInteger` Variable namens `mol_bigint`, in der Sie das exakte Ergebnis von 84446883³ speichern.

Definieren Sie dann eine weitere `BigInteger`-Variable `mol_diff`, mit der Sie berechnen, wie groß der Unterschied zwischen dem Wert von `mol_bigint` und dem tatsächlichen Wert der Avogadro-Konstante (6,02214076 · 10²³) ist.
---
author:
- "Christopher Sch\xF6lzel"
- Porty[bot]
id: d870d860-2496-4a7c-990b-6feafc658bf1
keywords:
- language: java
- major: computer science
- institution: Technische Hochschule Mittelhessen
- semester: '2'
- course: Algorithmen und Datenstrukturen
- teaches: was
- teaches: du
- teaches: java
- teaches: math
- teaches: pow
- teaches: text
lang: de-DE
solution-size: 15
title: Anhalteweg

---
## Aufgabe 03 - Anhalteweg

In der Fahrschule lernt man die folgende Faustformel für den Anhalteweg (Reaktionsweg + Bremsweg):

$$
\frac{\text{Tachowert} \cdot 3}{10} + \frac{\text{Tachowert}^2}{100}
$$

Schreibe einen Java-Ausdruck, der diese Rechnung umsetzt.

*Tipps:* 
* *$x^2$ lässt sich als* `x * x` *schreiben, oder man verwendet die power-Funktion* `Math.pow(x,2)`*.*
* `7 / 3` *ist in Java etwas anderes als* `7.0 / 3`*. Probiere aus, was hier passiert und achte bei deiner Lösung darauf, dass du immer das richtige Ergebnis bekommst.*

**Test: Bei einer Geschwindigkeit von 51 km/h sollte der Anhalteweg 41,31m betragen.**
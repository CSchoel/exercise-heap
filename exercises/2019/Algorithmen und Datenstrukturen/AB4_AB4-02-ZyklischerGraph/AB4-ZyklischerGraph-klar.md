---
title: AB4-ZyklischerGraph-klar
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
id: f27f0464-de42-4292-934b-301d1d546501
---

# Zyklische Graphen

Graphen sind eine Standardstruktur der Informatik und werden Ihnen in Ihrer Karriere sehr häufig begegnen.

Ihre Aufgabe besteht darin in einem vorgegebenen Graphen (Kette) Zyklen zu finden. Für diese Aufgabenstellung sind gültige Graphen solche ohne Zyklen, ungültige enthalten mindestens einen Zyklus.

Um den Unterschied zwischen einem gültigen und ungültigen Graphen zu veranschaulichen, hier zwei bildliche Beispiele:

![Knotlinge](https://homepages.thm.de/~cslz90/kurse/ad17/static/Knotlinge.png)

Ungültige Zyklen sind rot markiert.

Erweitern Sie die Methode `hasCycles` so, dass sie ein "True" zurückgibt, falls ein Graph einen Zyklus enthält. Die Klasse `AbstractGraph<E>` ist in den Tests zum herunterladen enthalten

```java
package cycles;
import cycles.abstractGraph.AbstractGraph;
public final class Graph<E> extends AbstractGraph<E> {

	@Override
	public boolean hasCycles() {
		/* TODO: Aufgabe der Studenten */
		return false;
	}
}
```

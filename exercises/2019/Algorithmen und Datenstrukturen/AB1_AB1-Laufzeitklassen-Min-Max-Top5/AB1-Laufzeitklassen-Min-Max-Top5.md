---
title: AB1-Laufzeitklassen-Min-Max-Top5
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

## Min-, Max- und die Top5
Sie erhalten von uns eine Liste mit Zahlen. Speichern Sie diese Daten in eine Arrayliste mit Integern. Finden Sie in dieser Liste jeweils das Minimum und das Maximum. Beides soll gleichzeitig ermittelt werden.

Als Hilfe soll Ihnen der hier gegebene Pseudocode dienen:

```
algorithm minmax(a):
  min := a[0]
  max := a[0]
  for i := 1 ... a.length()-1
	   if a[i] < min then
		   min := a[i]
	   if a[i] > max then
		   max := a[i]
return min,max
```

Da sie einen Input erhalten und in Dozentron nur der Output getestet wird, dürfen Sie diese Aufgabe in einer beliebigen Sprache lösen. Der Code wird natürlich dennoch kontrolliert.  

> Hinweis:  
Das Nutzen von fertigen Min-Max Methoden ist nicht erlaubt.  
Bitte implementieren Sie selbst eine Lösung!

### Aufgabe 1: Minimum und Maximum

* Schreiben Sie eine Methode `minmax` welche eine Arrayliste übernimmt und das Maximum und das Minimum dieser Liste liefert.

* Alle Zahlen in der gelieferten Liste sind positiv.  

Bitte geben Sie die Zahlen in dem folgenden Format ab:

```
<minZahl>
<maxZahl>
```

#### Beispiel:

Gegebener Input:

2
6
4
9
3

Ihr Output:
```  
2
9
```

#### Bitte beachten:

* Es dürfen keine Leerzeilen im Output stehen!
* Bitte reichen Sie Ihren Quellcode zur Korrektheitsprüfung ein.
* Die Methode sollte dabei in einer Klasse sein.

### Aufgabe 2: Friede den Adepten, Krieg den Überbezahlten

Sie haben einen **neuen** Input erhalten. Suchen Sie in der neuen Liste mit Hilfe einer Methode `top5` die fünf größten Zahlen und lassen Sie sich diese ausgeben. Die Methode soll eine maximale Laufzeit von O(n) besitzen.

Bitte geben Sie die Zahlen in dem folgenden Format ab:

```
<1. Zahl>
<2. Zahl>
<3. Zahl>
<4. Zahl>
<5. Zahl>
```

#### Beispiel:

*Gegebener Input*:  

2  
6  
4  
9  
3  
24  
1  


*Ihr Output*:  

24  
9  
6  
4  
3  


#### Bitte beachten:

* Es dürfen keine Leerzeilen im Output stehen!
* Bitte reichen Sie Ihren Quellcode zur Korrektheitsprüfung ein.
* Die Methode sollte dabei in einer Klasse sein.

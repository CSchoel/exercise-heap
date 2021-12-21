## Musterlösung für die Aufgabe "Objektorientierung"

### Aufgabe 4.1
Mit dem Schlüsselwort *final* vor einer Klasse verbietet man die Spezialisierung dieser Klasse durch eine Unterklasse.

### Aufgabe 4.2
Mit dem Schlüsselwort *final* vor einer Methode unterbindet man das Überschreiben dieser Methode durch Unterklassen.

### Aufgabe 4.3
Fehlt: Final vor Attributen

### Aufgabe 5
Die Klassen nennen sich *statische innere Klassen* und sie können das gleiche tun wie "normale" Klassen. Sie bilden aber eine innere Klasse mit eigener Sichtbarkeit. Zur Erzeugung von Exemplaren statischer innerer Klassen ist kein Objekt der äußeren Klasse notwendig. Wenn das *static* fehlt, bräuchte man ein Objekt der äußeren Klasse, um ein Objekt der inneren Klasse zu erzeugen.

### Aufgabe 6
Die *...* hinter dem generischen Typen im Beispiel geben an, dass die Methode `toList()` beliebig viele Argumente oder gar ein Array übergeben bekommen kann. In der Methode selbst kann man auf die Argumente zugreifen, indem man auf `args` wie auf ein Array zugreift. Man bezeichnet das als *varargs*.

### Aufgabe 7
Schreibt man in Java keinen Zugriffsmodifizierer vor eine globale Variable, so wird diese default-mäßig als *package-private* angesehen. Das bedeutet, dass nur Klassen im selben Package auf die Variable zugreifen dürfen. Soll diese Variable auch darüber hinaus sichtbar sein, wäre es sinnvoll den Modifier *public* zu verwenden. Soll die Variable aber nur innerhalb der Klasse zugreifbar sein, wäre es sinnvoll den Modifier *private* zu wählen. 
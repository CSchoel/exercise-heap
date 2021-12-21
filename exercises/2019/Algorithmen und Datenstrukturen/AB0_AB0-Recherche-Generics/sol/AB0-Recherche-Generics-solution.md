## Musterlösung für die Aufgabe "Generics"

Das `?` in generischen Typen nennt man ein *Wildcard*.
Es steht für einen zunächst unbekannten Typ.
Eine `Collection<?>` ist zum Beispiel eine Collection mit unbekanntem Elementtyp.

Wildcards können zusätzlichen Einschränkungen unterworfen sein.
Bei dem Ausdruck `? extends T` muss der Typ ein Subtyp von `T` sein (oder `T` selbst).
Bei dem Ausdruck `? super T` muss der Typ dagegen ein Supertyp von `T` sein (oder `T` selbst).
Man verwendet Wildcards dazu, eine Methode oder ein anderes Stück Code allgemeiner zu formulieren, als es ohne sie möglich wäre.

Zum Beispiel kann die Methode `Collections.copy(List<? super T>, List<? extends T>)` Daten aus einer beliebigen Kollektion in eine andere übertragen, so lange die Elementtypen kompatibel sind.
Die einzige Bedingung ist, dass der Typ der Quellcollection ein Supertyp vom Typ der Zielcollection ist.
Würde man `T` statt den Wildcard-Typen verwenden, müsste der Typ der Quellcollection immer exakt der gleiche wie der der Zielcollection sein.
Man könnte also z.B. die Daten einer `List<Integer>` nicht in eine `List<Number>` kopieren.

Quellen:

* https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html
* https://docs.oracle.com/javase/9/docs/api/java/util/Collections.html#copy-java.util.List-java.util.List-

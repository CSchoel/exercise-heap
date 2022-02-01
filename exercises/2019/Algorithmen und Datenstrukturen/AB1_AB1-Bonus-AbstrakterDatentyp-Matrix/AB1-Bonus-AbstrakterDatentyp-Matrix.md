---
title: AB1-Bonus-AbstrakterDatentyp-Matrix
author:
    - AuD-Tutoren
    - Christopher Schölzel
keywords:
    - language: java
    - semester: 2
    - major: computer science
    - institution: Technische Hochschule Mittelhessen
    - course: Algorithmen und Datenstrukturen
    - requires: loops
    - requires: classes
    - requires: interfaces
    - teaches: object-oriented design
    - teaches: performance
    - teaches: paging
    - teaches: abstract datatypes
lang: de-DE
solution-size: 400
id: 3def2ed5-017d-4060-835d-c9f951f0757a
---

# Abstrakter Datentyp: Matrix

Sie haben in der Vorlesung gelernt, dass es zu einem abstrakten Datentyp mehrere Datenstrukturen geben kann und zu einer Datenstruktur mehrere Implementierungen.

Als ein praktisches Anwendungsbeispiel hierfür eignet sich eine mathematische Matrix als abstrakter Datentyp.
Wir gehen hierfür von dem folgenden Java-Interface für Matrizen, die `double`-Werte enthalten aus:

```java
/**
 * Represents a Matrix of double values
 */
public interface DoubleMatrix {
  /**
   * Gets value at row y and column x (with boundary checks)
   * @param y row index (starting at 0)
   * @param x column index (starting at 0)
   * @return matrix value at row y and column x
   */
  double get(int y, int x);

  /**
   * <p>Like {@link #get(int, int)} but without boundary checks.</p>
   *
   * <p>Warning: This method should only be used inside algorithms that
   * have properly been tested using {@link #get(int, int)} before.</p>
   * @param y row index (starting at 0)
   * @param x column index (starting at 0)
   * @return matrix value at row y and column x
   */
  double unsafeGet(int y, int x);

  /**
   * Sets value at row y and column x (with boundary checks)
   * @param y row index (starting at 0)
   * @param x column index (starting at 0)
   * @param value value to put at row y and column x
   */
  void set(int y, int x, double value);

  /**
   * <p>Like {@link #set(int, int, double)} but without boundary checks.</p>
   *
   * <p>Warning: This method should only be used inside algorithms that
   * have properly been tested using {@link #get(int, int)} before.</p>
   * @param y row index (starting at 0)
   * @param x column index (starting at 0)
   * @param value value to put at row y and column x
   */
  void unsafeSet(int y, int x, double value);

  /**
   * Adds a matrix to this matrix and returns the result as new matrix
   * @param other the matrix that should be added to this matrix
   * @return the result of adding this to other
   */
  DoubleMatrix add(DoubleMatrix other);

  /**
   * Performs a matrix multiplication (dot product) with this matrix as the
   * left matrix and the other matrix as the right matrix.
   * @param other right matrix for multiplication
   * @return result of multiplying this with other
   */
  DoubleMatrix multiply(DoubleMatrix other);

  /**
   * @return the number of columns of this matrix
   */
  int columns();

  /**
   * @return the number of rows of this matrix
   */
  int rows();
}
```

Ihre Aufgabe ist es, zwei Klassen (und damit zwei unterschiedliche Datenstrukturen) im Paket `de.thm.mni.aud` zu erstellen, die dieses Interface implementieren (und damit den gleichen abstrakten Datentyp realisieren):

* `TwoDimDoubleMatrix` nutzt zur internen Speicherung ein Array vom Typ `double[][]`, wobei die inneren Arrays die *Zeilen* der Matrix darstellen.
    Diese Klasse soll die folgenden Konstruktoren haben:

  * `TwoDimDoubleMatrix(int, int)` erstellt eine Matrix mit der angegebenen Anzahl von Zeilen (erster Parameter) und Spalten (zweiter Parameter), die überall den Wert 0 hat.
  * `TwoDimDoubleMatrix(double[][])` übernimmt die Werte aus dem übergebenen Array als Werte der Matrix.
* `OneDimDoubleMatrix` nutzt zur internen Speicherung ein Array vom Typ `double[]`, in dem die Zeilen der Matrix *hintereinander* im Array gespeichert sind.
    Diese Klasse soll die folgenden Konstruktoren haben:
  * `OneDimDoubleMatrix(int, int)` funktioniert genau so wie der entsprechende Konstruktor von `TwoDimDoubleMatrix`.
  * `OneDimDoubleMatrix(double[], int)` übernimmt die Werte aus dem übergebenen Array als Werte der Matrix.
    Der zweite Parameter gibt an, wie viel Spalten die resultierende Matrix haben soll.

Beide Klassen sollen außerdem eine statische Methode `identity(int)` haben, die eine [Identitätsmatrix](https://en.wikipedia.org/wiki/Identity_matrix) mit der angegebenen Größe erzeugt.

Achten Sie bei der Implementierung auch darauf, Fehlerfälle zu erkennen und die entsprechenden Ausnahmen zu werfen:

* `IndexOutOfBoundsException` für Zugriffe außerhalb der erlaubten Grenzen einer Matrix
* `IllegalArgumentException` für fehlerhafte Parameter (z.B. im Konstruktor)
* `ArithmeticException` für Rechenfehler (z.B. wenn Matrixgrößen nicht zueinander passen)

Tipps/Hinweise:

* Die [Rechenregeln für Matrizen](https://en.wikipedia.org/wiki/Matrix_(mathematics)) können Sie bei Bedarf auf Wikipedia nachlesen.
* Sie müssen das Interface nicht aus dem Text kopieren.
    Es ist bereits in den Tests enthalten, die sie von Dozentron herunterladen können.
* Es muss auch möglich sein, eine `OneDimDoubleMatrix` mit einer `TwoDimDoubleMatrix` zu addieren oder zu multiplizieren.
* `unsafeSet(int, int, double)` und `unsafeGet(int, int)` sollen explizit keine Fehlerbehandlung enthalten.
    Diese Methoden sind eine Ausnahme, die es in einem sauberen Softwaredesign nicht geben würde.
    Wir brauchen sie aber, um die Datenstrukturen auf unkomplizierte Art effizient zu machen.
* Nehmen Sie keine Änderungen an dem Interface vor, da dieses von Dozentron wieder mit der Originalversion überschrieben wird.
    Wenn Sie den gleichen Code in beiden Klassen brauchen, ihn aber nur einmal implementieren wollen, können Sie eine *abstrakte Klasse* verwenden.
* Achten Sie darauf, dass ihre Datenstrukturen von außen nur mit den im Interface angegebenen Methoden verändert werden können.
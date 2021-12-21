package de.thm.mni.aud;

import static org.junit.Assert.*;

/**
 * Contains helper methods for tests.
 */
public class DoubleMatrixTestUtil {
  static final double delta = 1e-7;

  static void testSetAndGet(DoubleMatrix m) {
    assertEquals(0, m.get(0, 0), delta);
    m.set(2, 4, 3);
    assertEquals(3, m.get(2, 4), delta);
    assertEquals(0, m.get(4, 2), delta);
    m.set(2, 4, 10);
    assertEquals(10, m.get(2, 4), delta);
    // test that limits are set correctly
    m.set(9, 0, -1);
    m.set(0, 4, -1);
    m.set(9, 4, -1);
    String msg = "accessing index (%d, %d) in an %dx%d matrix "
               + "should raise an IndexOutOfBoundsException";
    try {
      m.set(10, 0, -1);
      fail(String.format(msg, 10, 0, 10, 5));
    } catch (IndexOutOfBoundsException e) { /* this exception is expected */ }
    try {
      m.set(0, 5, -1);
      fail(String.format(msg, 0, 5, 10, 5));
    } catch (IndexOutOfBoundsException e) { /* this exception is expected */ }
    try {
      m.get(10, 0);
      fail(String.format(msg, 10, 0, 10, 5));
    } catch (IndexOutOfBoundsException e) { /* this exception is expected */ }
    try {
      m.get(0, 5);
      fail(String.format(msg, 0, 5, 10, 5));
    } catch (IndexOutOfBoundsException e) { /* this exception is expected */ }
  }

  static void assertMatrixEquals(DoubleMatrix expected, DoubleMatrix actual) {
    assertEquals("wrong row number!", expected.rows(), actual.rows());
    assertEquals(
      "wrong column number!",
      expected.columns(), actual.columns()
    );
    String msg = "Matrices are not equal!"
               + "First difference is at y = %d, x = %d.";
    for(int y = 0; y < expected.rows(); y++) {
      for(int x = 0; x < expected.columns(); x++) {
        assertEquals(
          String.format(msg, y, x),
          expected.get(y, x),
          actual.get(y, x),
          delta
        );
      }
    }
  }

  static void assertEqualButNotSame(
      DoubleMatrix expected, DoubleMatrix actual,
      DoubleMatrix a, DoubleMatrix b) {
    assertNotSame(a, actual);
    assertNotSame(b, actual);
    double tempA = a.get(0, 0);
    double tempB = b.get(0, 0);
    a.set(0, 0, Math.PI);
    String msg = "result of a.add(b) is affected by changes to %s!";
    assertNotEquals(String.format(msg, "a"), Math.PI, actual.get(0, 0));
    b.set(0, 0, Math.PI);
    assertNotEquals(String.format(msg, "b"), Math.PI, actual.get(0, 0));
    // revert changes to a and b for further tests
    a.set(0, 0, tempA);
    b.set(0, 0, tempB);
    assertMatrixEquals(expected, actual);
  }

  static double[] rotationMatrix1D(double theta) {
    return new double[]{
      Math.cos(theta), -Math.sin(theta), Math.sin(theta), Math.cos(theta)
    };
  }

  static double[][] rotationMatrix2D(double theta) {
    return new double[][]{
      {Math.cos(theta), -Math.sin(theta)},
      {Math.sin(theta), Math.cos(theta)}
    };
  }
}

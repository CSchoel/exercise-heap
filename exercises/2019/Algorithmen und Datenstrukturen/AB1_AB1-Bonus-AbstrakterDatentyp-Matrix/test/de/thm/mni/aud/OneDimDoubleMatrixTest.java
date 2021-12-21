package de.thm.mni.aud;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static de.thm.mni.aud.DoubleMatrixTestUtil.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Contains tests for {@link OneDimDoubleMatrix}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OneDimDoubleMatrixTest {

  /**
   * Tests functionality of {@link DoubleMatrix#set(int, int, double)} and
   * {@link DoubleMatrix#get(int, int)}.
   */
  @Test
  public void t01setAndGet() {
    DoubleMatrix m = new OneDimDoubleMatrix(10, 5);
    DoubleMatrixTestUtil.testSetAndGet(m);
  }

  /**
   * Tests functionality of {@link DoubleMatrix#rows()} and
   * {@link DoubleMatrix#columns()}.
   */
  @Test
  public void t02rowsAndColumns() {
    DoubleMatrix m = new OneDimDoubleMatrix(10, 5);
    assertEquals(10, m.rows());
    assertEquals(5, m.columns());
  }

  /**
   * Tests functionality of {@link DoubleMatrix#add(DoubleMatrix)}.
   */
  @Test
  public void t03add() {
    DoubleMatrix m1 = new OneDimDoubleMatrix(100, 10);
    DoubleMatrix m2 = new OneDimDoubleMatrix(100, 10);
    DoubleMatrix expected = new OneDimDoubleMatrix(100, 10);
    // 0 + 0 = 0 => test for out of bounds errors or other crude stuff
    assertEqualButNotSame(expected, m1.add(m2), m1, m2);

    // [1, 2, 3] + [4, 5, -6] = [5, 7, -3]
    m1 = new OneDimDoubleMatrix(new double[]{1, 2, 3}, 3);
    m2 = new OneDimDoubleMatrix(new double[]{4, 5, -6}, 3);
    expected = new OneDimDoubleMatrix(new double[]{5, 7, -3}, 3);
    assertEqualButNotSame(expected, m1.add(m2), m1, m2);
    // switch m1 and m2
    assertEqualButNotSame(expected, m2.add(m1), m2, m1);

    // larger matrix
    m1 = new OneDimDoubleMatrix(new double[]{1, 2, 3, 4, 5, 6}, 2);
    m2 = new OneDimDoubleMatrix(new double[]{4, 5, -6, 7, -8, 9}, 2);
    expected = new OneDimDoubleMatrix(new double[]{5, 7, -3, 11, -3, 15}, 2);
    assertEqualButNotSame(expected, m1.add(m2), m1, m2);
  }

  /**
   * Tests functionality of {@link DoubleMatrix#multiply(DoubleMatrix)}.
   */
  @Test
  public void t04multiply() {
    DoubleMatrix m1 = new OneDimDoubleMatrix(10, 10);
    DoubleMatrix m2 = new OneDimDoubleMatrix(10, 10);
    DoubleMatrix expected = new OneDimDoubleMatrix(10, 10);
    // 0 * 0 = 0 => test for out of bounds errors or other crude stuff
    assertEqualButNotSame(expected, m1.multiply(m2), m1, m2);

    //check if dimensions are correct 5x100 * 100x7 = 5x7
    m1 = new OneDimDoubleMatrix(5, 100);
    m2 = new OneDimDoubleMatrix(100, 7);
    expected = new OneDimDoubleMatrix(5, 7);
    assertEqualButNotSame(expected, m1.multiply(m2), m1, m2);

    // [1, 2, 3] * [[3], [2], [-1]] = [4]
    m1 = new OneDimDoubleMatrix(new double[]{1, 2, 3}, 3);
    m2 = new OneDimDoubleMatrix(new double[]{3, 2, -1}, 1);
    expected = new OneDimDoubleMatrix(new double[]{4}, 1);
    assertEqualButNotSame(expected, m1.multiply(m2), m1, m2);

    // two 45 degree rotation matrices should give a 90 degree rotation matrix
    m1 = new OneDimDoubleMatrix(rotationMatrix1D(Math.PI / 4), 2);
    m2 = new OneDimDoubleMatrix(rotationMatrix1D(Math.PI / 4), 2);
    expected = new OneDimDoubleMatrix(rotationMatrix1D(Math.PI / 2), 2);
    assertEqualButNotSame(expected, m1.multiply(m2), m1, m2);
  }

  /**
   * Tests if {@link DoubleMatrix#add(DoubleMatrix)} throws correct exceptions.
   */
  @Test
  public void t05addException() {
    String msg = "adding a %dx%d and a %dx%d matrix should "
               + "raise an ArithmeticException";
    try {
      new OneDimDoubleMatrix(10, 5)
        .add(new OneDimDoubleMatrix(10, 1));
      fail(String.format(msg, 10, 5, 10, 1));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
    try {
      new OneDimDoubleMatrix(5, 1)
        .add(new OneDimDoubleMatrix(6, 1));
      fail(String.format(msg, 5, 1, 6, 1));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
    try {
      new OneDimDoubleMatrix(10, 5)
        .add(new OneDimDoubleMatrix(5, 10));
      fail(String.format(msg, 10, 5, 5, 10));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
  }

  /**
   * Tests if {@link DoubleMatrix#multiply(DoubleMatrix)} throws correct
   * exceptions.
   */
  @Test
  public void t06multiplyException() {
    String msg = "multiplying a 10x5 and a 6x10 matrix should "
               + "raise an ArithmeticException";
    try {
      new OneDimDoubleMatrix(10, 5)
        .multiply(new OneDimDoubleMatrix(6, 10));
      fail(String.format(msg, 10, 5, 6, 10));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
    try {
      new OneDimDoubleMatrix(10, 5)
        .multiply(new OneDimDoubleMatrix(10, 7));
      fail(String.format(msg, 10, 5, 10, 7));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
    try {
      new OneDimDoubleMatrix(10, 5)
        .multiply(new OneDimDoubleMatrix(10, 5));
      fail(String.format(msg, 10, 5, 10, 5));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
  }

  /**
   * Tests if the constructor of OneDimDoubleMatrix throws correct exceptions.
   */
  @Test
  public void t07constructorException() {
    try {
      new OneDimDoubleMatrix(new double[10], 3);
      String msg = "the constructor should raise an IllegalArgumentException"
                 + "if the length of the array is not divisible by cols";
      fail(msg);
    } catch (IllegalArgumentException iae) { /* this is expected */ }
  }

  /**
   * Tests functionality of {@link OneDimDoubleMatrix#identity(int)}.
   */
  @Test
  public void t08identity() {
    assertMatrixEquals(
      new OneDimDoubleMatrix(new double[]{1}, 1),
      OneDimDoubleMatrix.identity(1)
    );

    assertMatrixEquals(
      new OneDimDoubleMatrix(new double[]{1, 0, 0, 1}, 2),
      OneDimDoubleMatrix.identity(2)
    );

    assertMatrixEquals(
      new OneDimDoubleMatrix(new double[]{1, 0, 0, 0, 1, 0, 0, 0, 1}, 3),
      OneDimDoubleMatrix.identity(3)
    );
  }

  /**
   * Tests if the constructor displays signs of aliasing.
   */
  @Test
  public void t09aliasing() {
    double[] content = new double[]{1, 2, 3};
    DoubleMatrix mat = new OneDimDoubleMatrix(content, 1);
    content[0] = 100;
    String msg = "The constructor of OneDimDoubleMatrix seems to create an " +
      "alias by just using the argument array to store its data instead of " +
      "copying it.";
    assertEquals(msg, 1, mat.get(0, 0), delta);
  }
}

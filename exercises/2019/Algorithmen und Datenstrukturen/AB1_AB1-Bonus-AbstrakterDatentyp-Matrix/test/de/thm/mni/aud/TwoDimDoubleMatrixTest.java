package de.thm.mni.aud;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static de.thm.mni.aud.DoubleMatrixTestUtil.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Contains tests for {@link TwoDimDoubleMatrix}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TwoDimDoubleMatrixTest {

  /**
   * Tests functionality of {@link DoubleMatrix#set(int, int, double)} and
   * {@link DoubleMatrix#get(int, int)}.
   */
  @Test
  public void t01setAndGet() {
    DoubleMatrix m = new TwoDimDoubleMatrix(10, 5);
    testSetAndGet(m);
  }

  /**
   * Tests functionality of {@link DoubleMatrix#rows()} and
   * {@link DoubleMatrix#columns()}.
   */
  @Test
  public void t02rowsAndColumns() {
    DoubleMatrix m = new TwoDimDoubleMatrix(10, 5);
    assertEquals(10, m.rows());
    assertEquals(5, m.columns());
  }

  /**
   * Tests functionality of {@link DoubleMatrix#add(DoubleMatrix)}.
   */
  @Test
  public void t03add() {
    DoubleMatrix m1 = new TwoDimDoubleMatrix(100, 10);
    DoubleMatrix m2 = new TwoDimDoubleMatrix(100, 10);
    DoubleMatrix expected = new TwoDimDoubleMatrix(100, 10);
    // 0 + 0 = 0 => test for out of bounds errors or other crude stuff
    assertEqualButNotSame(expected, m1.add(m2), m1, m2);

    // [1, 2, 3] + [4, 5, -6] = [5, 7, -3]
    m1 = new TwoDimDoubleMatrix(new double[][]{{1, 2, 3}});
    m2 = new TwoDimDoubleMatrix(new double[][]{{4, 5, -6}});
    expected = new TwoDimDoubleMatrix(new double[][]{{5, 7, -3}});
    assertEqualButNotSame(expected, m1.add(m2), m1, m2);
    // switch m1 and m2
    assertEqualButNotSame(expected, m2.add(m1), m2, m1);

    // larger matrix
    m1 = new TwoDimDoubleMatrix(new double[][]{{1, 2}, {3, 4}, {5, 6}});
    m2 = new TwoDimDoubleMatrix(new double[][]{{4, 5}, {-6, 7}, {-8, 9}});
    expected = new TwoDimDoubleMatrix(
      new double[][]{{5, 7}, {-3, 11}, {-3, 15}}
    );
    assertEqualButNotSame(expected, m1.add(m2), m1, m2);
  }

  /**
   * Tests functionality of {@link DoubleMatrix#multiply(DoubleMatrix)}.
   */
  @Test
  public void t04multiply() {
    DoubleMatrix m1 = new TwoDimDoubleMatrix(10, 10);
    DoubleMatrix m2 = new TwoDimDoubleMatrix(10, 10);
    DoubleMatrix expected = new TwoDimDoubleMatrix(10, 10);
    // 0 * 0 = 0 => test for out of bounds errors or other crude stuff
    assertEqualButNotSame(expected, m1.multiply(m2), m1, m2);

    //check if dimensions are correct 5x100 * 100x7 = 5x7
    m1 = new TwoDimDoubleMatrix(5, 100);
    m2 = new TwoDimDoubleMatrix(100, 7);
    expected = new TwoDimDoubleMatrix(5, 7);
    assertEqualButNotSame(expected, m1.multiply(m2), m1, m2);

    // [1, 2, 3] * [[3], [2], [-1]] = [4]
    m1 = new TwoDimDoubleMatrix(new double[][]{{1, 2, 3}});
    m2 = new TwoDimDoubleMatrix(new double[][]{{3}, {2}, {-1}});
    expected = new TwoDimDoubleMatrix(new double[][]{{4}});
    assertEqualButNotSame(expected, m1.multiply(m2), m1, m2);

    // two 45 degree rotation matrices should give a 90 degree rotation matrix
    m1 = new TwoDimDoubleMatrix(rotationMatrix2D(Math.PI / 4));
    m2 = new TwoDimDoubleMatrix(rotationMatrix2D(Math.PI / 4));
    expected = new TwoDimDoubleMatrix(rotationMatrix2D(Math.PI / 2));
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
      new TwoDimDoubleMatrix(10, 5)
        .add(new TwoDimDoubleMatrix(10, 1));
      fail(String.format(msg, 10, 5, 10, 1));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
    try {
      new TwoDimDoubleMatrix(5, 1)
        .add(new TwoDimDoubleMatrix(6, 1));
      fail(String.format(msg, 5, 1, 6, 1));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
    try {
      new TwoDimDoubleMatrix(10, 5)
        .add(new TwoDimDoubleMatrix(5, 10));
      fail(String.format(msg, 10, 5, 5, 10));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
  }

  /**
   * Tests if {@link DoubleMatrix#multiply(DoubleMatrix)} throws correct
   * exceptions.
   */
  @Test
  public void t06multiplyException() {
    String msg = "multiplying a %dx%d and a %dx%d matrix should "
               + "raise an ArithmeticException";
    try {
      new TwoDimDoubleMatrix(10, 5)
        .multiply(new TwoDimDoubleMatrix(6, 10));
      fail(String.format(msg, 10, 5, 6, 10));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
    try {
      new TwoDimDoubleMatrix(10, 5)
        .multiply(new TwoDimDoubleMatrix(10, 7));
      fail(String.format(msg, 10, 5, 10, 7));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
    try {
      new TwoDimDoubleMatrix(10, 5)
        .multiply(new TwoDimDoubleMatrix(10, 5));
      fail(String.format(msg, 10, 5, 10, 5));
    } catch (ArithmeticException ae) { /* this is the exception we expect */ }
  }

  @Test
  public void t07constructorException() {
    double[][] content = new double[][]{
      {1, 2, 3},
      {4, 5, 6},
      {7, 8}
    };
    double[][] content2 = new double[][]{
      {1, 2, 3},
      {4, 5, 6, 7},
      {8, 9, 10}
    };
    String msg = "Double arrays with different row sizes should raise an " +
      "IllegalArgument exception!";
    try {
      new TwoDimDoubleMatrix(content);
      fail(msg);
    } catch (IllegalArgumentException iae) { /* this is expected */ }

    try {
      new TwoDimDoubleMatrix(content2);
      fail(msg);
    } catch (IllegalArgumentException iae) { /* this is expected */ }
  }

  /**
   * Tests functionality of {@link TwoDimDoubleMatrix#identity(int)}.
   */
  @Test
  public void t08identity() {
    assertMatrixEquals(
      new TwoDimDoubleMatrix(new double[][]{{1}}),
      TwoDimDoubleMatrix.identity(1)
    );

    assertMatrixEquals(
      new TwoDimDoubleMatrix(new double[][]{{1, 0}, {0, 1}}),
      TwoDimDoubleMatrix.identity(2)
    );

    assertMatrixEquals(
      new TwoDimDoubleMatrix(new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}),
      TwoDimDoubleMatrix.identity(3)
    );
  }

  /**
   * Tests if the constructor displays signs of aliasing.
   */
  @Test
  public void t09aliasing() {
    double[][] content = new double[][]{{1}, {2}, {3}};
    DoubleMatrix mat = new TwoDimDoubleMatrix(content);
    content[0][0] = 100;
    String msg = "The constructor of TwoDimDoubleMatrix seems to create an " +
      "alias by just using the argument array to store its data instead of " +
      "copying it.";
    assertEquals(msg, 1, mat.get(0, 0), delta);
  }
}

package de.thm.mni.aud;

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

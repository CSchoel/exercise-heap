package de.thm.mni.aud;

import java.util.Arrays;

/**
 * DoubleMatrix that is backed by a two-dimensional array.
 */
public class TwoDimDoubleMatrix extends AbstractDoubleMatrix {
  // Class invariant: there exists a c >= 0 so that for all y it holds that
  // content[y].length = c
  private double[][] content;

  /**
   * Generates a matrix with the given number of rows and columns. All values
   * will be set to zero.
   * @param rows number of rows
   * @param cols number of columns
   */
  public TwoDimDoubleMatrix(int rows, int cols) {
    this(new double[rows][cols]);
  }
  /**
   * Crates a matrix that contains the values of the given array.
   * @param content content for the matrix (first index is the row index)
   */
  public TwoDimDoubleMatrix(double[][] content) {
    if (content.length == 0) {
      this.content = new double[0][0];
      return;
    }
    int columns = content[0].length;
    this.content = new double[content.length][columns];
    String msg = "All rows must have the same length but row number %d has" +
      "length %d while row 0 has length %d.";
    for (int y = 0; y < content.length; y++) {
      if (content[y].length != columns) {
        throw new IllegalArgumentException(
          String.format(msg, y, content[y].length, columns)
        );
      }
      System.arraycopy(content[y], 0, this.content[y], 0, columns);
    }
  }

  /**
   * Creates an identity matrix of the given size
   * @param cols number of columns (and rows)
   * @return identity matrix with cols columns and rows
   */
  public static TwoDimDoubleMatrix identity(int cols) {
    TwoDimDoubleMatrix mat = new TwoDimDoubleMatrix(cols, cols);
    AbstractDoubleMatrix.id(mat);
    return mat;
  }

  @Override
  public double unsafeGet(int y, int x) {
    return content[y][x];
  }

  @Override
  public void unsafeSet(int y, int x, double value) {
    content[y][x] = value;
  }

  @Override
  public DoubleMatrix add(DoubleMatrix other) {
    TwoDimDoubleMatrix res = new TwoDimDoubleMatrix(
      other.rows(),
      other.columns()
    );
    AbstractDoubleMatrix.add(this, other, res);
    return res;
  }

  @Override
  public DoubleMatrix multiply(DoubleMatrix other) {
    TwoDimDoubleMatrix res = new TwoDimDoubleMatrix(
      this.rows(),
      other.columns()
    );
    AbstractDoubleMatrix.mul(this, other, res);
    return res;
  }

  @Override
  public int columns() {
    return content[0].length;
  }

  @Override
  public int rows() {
    return content.length;
  }
}

package de.thm.mni.aud;

/**
 * Abstract base class for DoubleMatrix implementations
 */
public abstract class AbstractDoubleMatrix implements DoubleMatrix {
  /**
   * Adds matrix a to matrix b, storing results in matrix res
   * @param a left addend
   * @param b right addend
   * @param res result
   */
  protected static void add(DoubleMatrix a, DoubleMatrix b, DoubleMatrix res) {
    if (a.rows() != b.rows() || a.columns() != b.columns()) {
      String msg = String.format(
        "cannot add %dx%d with %dx%d matrix",
        a.rows(), a.columns(),
        b.rows(), b.columns()
      );
      throw new ArithmeticException(msg);
    }
    assert a.rows() == b.rows();
    assert a.columns() == b.columns();
    for(int y = 0; y < a.rows(); y++) {
      for(int x = 0; x < a.columns(); x++) {
        res.unsafeSet(y, x, a.unsafeGet(y, x) + b.unsafeGet(y, x));
      }
    }
  }

  /**
   * Multiplies matrix a with matrix b (dot product), storing results in matrix
   * res
   * @param a left factor
   * @param b right factor
   * @param res result
   */
  protected static void mul(DoubleMatrix a, DoubleMatrix b, DoubleMatrix res) {
    if (b.rows() != a.columns()) {
      String msg = String.format(
        "cannot multiply %dx%d with %dx%d matrix",
        a.rows(), a.columns(),
        b.rows(), b.columns()
      );
      throw new ArithmeticException(msg);
    }
    for(int y = 0; y < a.rows(); y++) {
      for(int x = 0; x < b.columns(); x++) {
        double tmp = 0;
        for(int i = 0; i < a.columns(); i++) {
          tmp += a.unsafeGet(y, i) * b.unsafeGet(i, x);
        }
        res.unsafeSet(y, x, tmp);
      }
    }
  }

  /**
   * Sets the diagonal of the given square matrix to one.
   * @param res square matrix
   */
  protected static void id(DoubleMatrix res) {
    assert res.rows() == res.columns();
    for(int i = 0; i < res.columns(); i++) {
      res.set(i, i , 1);
    }
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(int y = 0; y < rows(); y++) {
      for(int x = 0; x < columns(); x++) {
        sb.append(String.format("%7.3f ", get(y, x)));
      }
      sb.append(System.lineSeparator());
    }
    return sb.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    if (!(other instanceof AbstractDoubleMatrix)) return false;
    AbstractDoubleMatrix o = (AbstractDoubleMatrix) other;
    if (o.rows() != rows()) return false;
    if (o.columns() != columns()) return false;
    for(int y = 0; y < rows(); y++) {
      for(int x = 0; x < columns(); x++) {
        if (get(y, x) != o.get(y, x)) return false;
      }
    }
    return true;
  }

  @Override
  public double get(int y, int x) {
    checkIndex(y, x);
    return unsafeGet(y, x);
  }

  @Override
  public void set(int y, int x, double value) {
    checkIndex(y, x);
    unsafeSet(y, x, value);
  }

  private void checkIndex(int y, int x) {
    if (y < 0 || y >= rows() || x < 0 || x >= columns()) {
      String template = "cannot access index %d, %d in %dx%d matrix";
      String msg = String.format(template, y, x, rows(), columns());
      throw new IndexOutOfBoundsException(msg);
    }
  }
}

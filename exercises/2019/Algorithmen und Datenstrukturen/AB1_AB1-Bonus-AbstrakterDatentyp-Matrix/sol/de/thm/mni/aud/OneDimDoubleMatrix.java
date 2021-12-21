package de.thm.mni.aud;

import java.util.Arrays;

/**
 * DoubleMatrix that is backed by a one-dimensional array.
 */
public class OneDimDoubleMatrix extends AbstractDoubleMatrix {
  // Class invariant: content.length % cols == 0
  private double[] content;
  private int cols;

  /**
   * Generates a matrix with the given number of rows and columns. All values
   * will be set to zero.
   * @param rows number of rows
   * @param cols number of columns
   */
  public OneDimDoubleMatrix(int rows, int cols) {
    this(new double[rows * cols], cols);
  }

  /**
   * Crates a matrix that contains the values of the given array.
   * @param content content for the matrix (first row, second row, etc...)
   * @param cols number of columns
   */
  public OneDimDoubleMatrix(double[] content, int cols) {
    if (content.length % cols != 0) { // this is the class invariant
      String msg = String.format(
        "array of length %d cannot be evenly divided into rows of size %d",
        content.length,
        cols
      );
      throw new IllegalArgumentException(msg);
    }
    this.content = Arrays.copyOf(content, content.length);
    this.cols = cols;
  }

  /**
   * Creates an identity matrix of the given size
   * @param cols number of columns (and rows)
   * @return identity matrix with cols columns and rows
   */
  public static OneDimDoubleMatrix identity(int cols) {
    OneDimDoubleMatrix mat = new OneDimDoubleMatrix(cols, cols);
    AbstractDoubleMatrix.id(mat);
    return mat;
  }

  private int idx(int y, int x) {
    return y * cols + x;
  }

  @Override
  public void unsafeSet(int y, int x, double value) {
    content[idx(y, x)] = value;
  }

  @Override
  public DoubleMatrix add(DoubleMatrix other) {
    OneDimDoubleMatrix res = new OneDimDoubleMatrix(
      other.rows(),
      other.columns()
    );
    AbstractDoubleMatrix.add(this, other, res);
    return res;
  }

  @Override
  public DoubleMatrix multiply(DoubleMatrix other) {
    OneDimDoubleMatrix res = new OneDimDoubleMatrix(
      this.rows(),
      other.columns()
    );
    AbstractDoubleMatrix.mul(this, other, res);
    return res;
  }

//  public DoubleMatrix multiply(OneDimDoubleMatrix other) {
//    OneDimDoubleMatrix res = new OneDimDoubleMatrix(
//      this.rows(),
//      other.columns()
//    );
//    if (other.rows() != this.columns()) {
//      String msg = String.format(
//        "cannot multiply %dx%d with %dx%d matrix",
//        this.rows(), this.columns(),
//        other.rows(), other.columns()
//      );
//      throw new ArithmeticException(msg);
//    }
//    int thisI = 0;
//    int otherI = 0;
//    int resI = 0;
//    for(int x = 0; x < other.columns(); x++) {
//      thisI = 0;
//      resI = x;
//      for(int y = 0; y < this.rows(); y++) {
//        otherI = x;
//        double tmp = 0;
//        for(int i = 0; i < this.columns(); i++) {
//          tmp += this.content[thisI] * this.content[otherI];
//          thisI++;
//          otherI += other.cols;
//        }
//        res.content[resI] = tmp;
//        resI += res.cols;
//      }
//    }
//    return res;
//  }

  public DoubleMatrix multiply(OneDimDoubleMatrix other) {
    if (other.rows() != this.columns()) {
      String msg = String.format(
        "cannot multiply %dx%d with %dx%d matrix",
        this.rows(), this.columns(),
        other.rows(), other.columns()
      );
      throw new ArithmeticException(msg);
    }
    // transpose res and other
    OneDimDoubleMatrix res = new OneDimDoubleMatrix(
      other.columns(),
      this.rows()
    );
    other = new OneDimDoubleMatrix(other.content, other.cols);
    other.transpose();
    int thisI = 0;
    int otherI = 0;
    int resI = 0;
    for(int x = 0; x < other.rows(); x++) {
      thisI = 0;
      for(int y = 0; y < this.rows(); y++) {
        otherI = x * other.columns();
        double tmp = 0;
        for(int i = 0; i < this.columns(); i++) {
          tmp += this.content[thisI] * this.content[otherI];
          thisI++;
          otherI++;
        }
        res.content[resI] = tmp;
        resI++;
      }
    }
    res.transpose();
    return res;
  }

  private void transpose() {
    int from = 0;
    int to = 0;
    for(int y = 0; y < this.rows(); y++) {
      from += y + 1;
      to = (y + 1) * this.rows() + y;
      for(int x = y+1; x < this.columns(); x++) {
        double tmp = content[from];
        content[from] = content[to];
        content[to] = tmp;
        from++;
        to += this.rows();
      }
    }
    cols = this.rows();
  }

  @Override
  public int columns() {
    return cols;
  }

  @Override
  public int rows() {
    return content.length / cols;
  }

  @Override
  public double unsafeGet(int y, int x) {
    return content[idx(y, x)];
  }
}

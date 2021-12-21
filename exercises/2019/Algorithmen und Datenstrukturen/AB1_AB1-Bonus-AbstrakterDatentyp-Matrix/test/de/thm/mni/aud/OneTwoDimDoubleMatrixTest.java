package de.thm.mni.aud;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static de.thm.mni.aud.DoubleMatrixTestUtil.assertEqualButNotSame;
import static de.thm.mni.aud.DoubleMatrixTestUtil.rotationMatrix1D;
import static de.thm.mni.aud.DoubleMatrixTestUtil.rotationMatrix2D;
import static org.junit.Assert.assertTrue;

/**
 * Contains tests that compare {@link OneDimDoubleMatrix} and
 * {@link TwoDimDoubleMatrix}
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OneTwoDimDoubleMatrixTest {

  /**
   * Tests that {@link DoubleMatrix#add(DoubleMatrix)} also works if the
   * matrix on the one side has a different type than the matrix on the other
   * side.
   */
  @Test
  public void t01interoperableAdd() {
    DoubleMatrix m1 = new OneDimDoubleMatrix(
      new double[]{1, 2, 3, 4, 5, 6},
      2
    );
    DoubleMatrix m2 = new TwoDimDoubleMatrix(
      new double[][]{{-1, -1}, {3, 1}, {-6, 9}}
    );
    DoubleMatrix expected1 = new OneDimDoubleMatrix(
      new double[]{0, 1, 6, 5, -1, 15},
      2
    );
    DoubleMatrix expected2 = new TwoDimDoubleMatrix(
      new double[][]{{0, 1}, {6, 5}, {-1, 15}}
    );
    assertEqualButNotSame(expected1, m1.add(m2), m1, m2);
    assertEqualButNotSame(expected2, m1.add(m2), m1, m2);
    assertEqualButNotSame(expected1, m2.add(m1), m1, m2);
    assertEqualButNotSame(expected2, m2.add(m1), m1, m2);
  }

  /**
   * Tests that {@link DoubleMatrix#multiply(DoubleMatrix)} also works if the
   * matrix on the one side has a different type than the matrix on the other
   * side.
   */
  @Test
  public void t02interoperableMultiply() {
    DoubleMatrix m1 = new OneDimDoubleMatrix(
      rotationMatrix1D(Math.PI / 4),
      2
    );
    DoubleMatrix m2 = new TwoDimDoubleMatrix(
      rotationMatrix2D(Math.PI / 4)
    );
    DoubleMatrix expected1 = new OneDimDoubleMatrix(
      rotationMatrix1D(Math.PI / 2),
      2
    );
    DoubleMatrix expected2 = new TwoDimDoubleMatrix(
      rotationMatrix2D(Math.PI / 2)
    );
    assertEqualButNotSame(expected1, m1.multiply(m2), m1, m2);
    assertEqualButNotSame(expected2, m1.multiply(m2), m1, m2);
    assertEqualButNotSame(expected1, m2.multiply(m1), m1, m2);
    assertEqualButNotSame(expected2, m2.multiply(m1), m1, m2);
  }

  /**
   * <p>Tests that {@link OneDimDoubleMatrix} should be measurably faster than
   * {@link TwoDimDoubleMatrix} (on a given multiplication example).</p>
   *
   * <p><b>NOTE:</b> Proper benchmarking in Java is hard!
   * This code is just an approximation.
   * It accounts for warming up the JVM for JIT-compilation, dead code
   * elimination and tries to avoid measuring garbage collection times, but
   * may still be susceptible to other inaccuracies.</p>
   *
   * <p>If you want to do some robust performance measures in Java, use
   * <a href="https://openjdk.java.net/projects/code-tools/jmh/">jmh</a>.</p>
   */
  @Test
  public void t03speed() {


    // Initialize result list with full capacity to store results so that
    // they are not garbage collected during tests.
    // This is implemented as a instance variable so that the compiler cannot
    // detect that the result is never actually used.
    results = new ArrayList<>(N_WARMUP * 2  + N_TEST * 2);

    // warmup phase: ensure that JIT has finished optimizing the method
    runSpeedTest2D(N_WARMUP);

    // actual test
    long twoD = runSpeedTest2D(N_TEST);

    // warmup for 1D case
    runSpeedTest1D(N_WARMUP);

    // test for 1D case
    long oneD = runSpeedTest1D(N_TEST);

    // calculate speedup factor
    double speedup = 1.0 * twoD / oneD;

    String msg = "OPTIONAL Test: The muliplication method of "
               + "OneDimDoubleMatrix can be made faster than the one in "
               + "TwoDimDoubleMatrix by a factor of at least 1.2. "
               + "Achieving this is very hard and requires that you go beyond "
               + "using the unsafe get- and set-Methods to directly "
               + "manipulate the internal variables of OneDimDoubleMatrix. "
               + "There are multiple ways to achieve this without changing "
               + "the Interface if both matrices are OneDimDoubleMatrices, but "
               + "keep in mind that you also have to provide a (slower) way to "
               + "multiply matrices of different types.\n\n"
               + "The speed test returned the following times:\n"
               + "OneDimDoubleMatrix: %9d ns\n"
               + "TwoDimDOubleMatrix: %9d ns\n"
               + "Speedup factor:     %9.3f";
    assertTrue(String.format(msg, oneD, twoD, speedup), speedup > 1.2);

    System.out.println(String.format("OneDimDoubleMatrix: %9d ns", oneD));
    System.out.println(String.format("TwoDimDoubleMatrix: %9d ns", twoD));
    System.out.println(String.format("Speedup factor:     %9.3f", speedup));
  }

  private static List<DoubleMatrix> results;
  private static final int AY = 100;
  private static final int AX = 10;
  private static final int BY = 10;
  private static final int BX = 10;
  private static final int N_WARMUP = 3000;
  private static final int N_TEST = 3000;

  private static double[] doubles1D(int n, int seed) {
    Random r = new Random(seed);
    double[] res = new double[n];
    for(int i = 0; i < res.length; i++) {
      res[i] = (r.nextInt(200_000) - 100_000) / 1000.0;
    }
    return res;
  }
  private static double[][] doubles2D(int rows, int columns, int seed) {
    Random r = new Random(seed);
    double[][] res = new double[rows][columns];
    for(int y = 0; y < rows; y++) {
      for(int x = 0; x < columns; x++) {
        res[y][x] = (r.nextInt(200_000) - 100_000) / 1000.0;
      }
    }
    return res;
  }

  private static long runSpeedTest1D(int iterations) {

    double[] aContent = doubles1D(AX * AY, 0);
    double[] bContent = doubles1D(BX * BY, 0);
    OneDimDoubleMatrix a = new OneDimDoubleMatrix(aContent, AX);
    OneDimDoubleMatrix b = new OneDimDoubleMatrix(bContent, BX);

    long t = System.nanoTime();

    for(int i = 0; i < iterations; i++) {
      // save results to ensure that we do not count garbage collection times
      results.add(a.multiply(b));
    }

    return System.nanoTime() - t;
  }

  private static long runSpeedTest2D(int iterations) {

    double[][] aContent = doubles2D(AY, AX, 0);
    double[][] bContent = doubles2D(BY, BX, 0);
    TwoDimDoubleMatrix a = new TwoDimDoubleMatrix(aContent);
    TwoDimDoubleMatrix b = new TwoDimDoubleMatrix(bContent);

    long t = System.nanoTime();

    for(int i = 0; i < iterations; i++) {
      // save results to ensure that we do not count garbage collection times
      results.add(a.multiply(b));
    }

    return System.nanoTime() - t;
  }
}

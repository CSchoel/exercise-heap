package zipper;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ZipperTest {

  private List<Integer> intTest1 = Arrays.asList(1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41);
  private List<Integer> intTest2 = Arrays.asList(2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42);

  private List<String> stringTest = Arrays.asList(
    "Apple", "Banana", "Orange", "Pineapple", "Watermelon", "Cherry", "Pear", "plum", "grape"
  );
  private List<Double> doubleTest = Arrays.asList(
    0.46, 2.99, 23.78, 100.99, 4.12, 1.04, 89.264, 42.42, 12.11, 15.231, 1000000.00
  );

  @Test
  public void tupleTest() {
    Tuple<Character, Double> t = new Tuple<>('z', 0.42);
    assertEquals('z', (char) t._1());
    assertEquals(0.42, t._2(), 0.0);
  }

  @Test
  public void tupleEqualsTest() {
    Tuple<String, Boolean> t1 = new Tuple<>("foo", true);
    Tuple<String, Boolean> t2 = new Tuple<>("foo", true);
    Tuple<String, Boolean> t3 = new Tuple<>("bar", true);
    Tuple<String, Boolean> t4 = new Tuple<>("foo", false);
    assertEquals(t1, t2);
    assertEquals(t2, t1);
    assertNotEquals(t1, t3);
    assertNotEquals(t1, t4);
    assertNotEquals(t3, t1);
    assertNotEquals(t4, t1);
  }

  @Test
  public void zipTest() {
    List<Tuple<Integer, Integer>> intZipTestRes = Arrays.asList(
      new Tuple<>(1, 2), new Tuple<>(3, 4), new Tuple<>(5, 6),
      new Tuple<>(7, 8), new Tuple<>(9, 10), new Tuple<>(11, 12),
      new Tuple<>(13, 14), new Tuple<>(15, 16), new Tuple<>(17, 18),
      new Tuple<>(19, 20), new Tuple<>(21, 22), new Tuple<>(23, 24),
      new Tuple<>(25, 26), new Tuple<>(27, 28), new Tuple<>(29, 30),
      new Tuple<>(31, 32), new Tuple<>(33, 34), new Tuple<>(35, 36),
      new Tuple<>(37, 38), new Tuple<>(39, 40), new Tuple<>(41, 42)
    );
    assertEquals(intZipTestRes, Zipper.zip(intTest1.stream(), intTest2.stream()).collect(Collectors.toList()));
  }

  @Test
  public void zipLengthTest() {
    List<Tuple<String, Double>> strDoubZipTestRes = Arrays.asList(
      new Tuple<>("Apple", 0.46), new Tuple<>("Banana", 2.99),
      new Tuple<>("Orange", 23.78), new Tuple<>("Pineapple", 100.99),
      new Tuple<>("Watermelon", 4.12), new Tuple<>("Cherry", 1.04),
      new Tuple<>("Pear", 89.264), new Tuple<>("plum", 42.42),
      new Tuple<>("grape", 12.11)
    );
    assertEquals(strDoubZipTestRes, Zipper.zip(stringTest.stream(), doubleTest.stream()).collect(Collectors.toList()));
  }

  @Test
  public void zipWithTest() {
    BiFunction<Integer, Integer, Integer> modulo3Fn = (i1, i2) -> (i1 + i2) % 3;
    List<Integer> zipWithMod3TestRes = Arrays.asList(0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2);
    assertEquals(zipWithMod3TestRes, Zipper.zipWith(intTest1.stream(), intTest2.stream(), modulo3Fn).collect(Collectors.toList()));
  }

  @Test
  public void zipWithLengthTest() {
    BiFunction<String, Double, String> priceFn = (str, d) -> str + ": " + d + " EUR";
    List<String> zipWithPricesTestRes = Arrays.asList(
      "Apple: 0.46 EUR", "Banana: 2.99 EUR", "Orange: 23.78 EUR", "Pineapple: 100.99 EUR", "Watermelon: 4.12 EUR",
      "Cherry: 1.04 EUR", "Pear: 89.264 EUR", "plum: 42.42 EUR", "grape: 12.11 EUR"
    );
    assertEquals(zipWithPricesTestRes, Zipper.zipWith(stringTest.stream(), doubleTest.stream(), priceFn).collect(Collectors.toList()));
  }

  @Test
  public void lazyZipTest() {
    List<Tuple<Integer, Integer>> oddLazyZipTestRes = Arrays.asList(
      new Tuple<>(1, 2), new Tuple<>(3, 4), new Tuple<>(5, 6),
      new Tuple<>(9, 10), new Tuple<>(11, 12), new Tuple<>(13, 14),
      new Tuple<>(15, 16), new Tuple<>(19, 20), new Tuple<>(21, 22),
      new Tuple<>(23, 24), new Tuple<>(25, 26), new Tuple<>(29, 30),
      new Tuple<>(31, 32), new Tuple<>(33, 34), new Tuple<>(35, 36),
      new Tuple<>(39, 40), new Tuple<>(41, 42)
    );
    Stream<Integer> infiniteStream1 = Stream.iterate(1, i -> i + 2);
    Stream<Integer> infiniteStream2 = Stream.iterate(2, i -> i + 2);
    assertEquals(oddLazyZipTestRes, Zipper.zip(infiniteStream1, infiniteStream2).filter(t -> (t._1() + t._2()) % 5 != 0).limit(17).collect(Collectors.toList()));
  }

  @Test
  public void lazyZipWithTest() {
    List<Integer> oddLazyZipWithTestRes = Arrays.asList(3,7,11,19,23,27,31,39,43,47,51,59,63,67,71,79,83);
    Stream<Integer> infiniteStream1 = Stream.iterate(1, i -> i + 2);
    Stream<Integer> infiniteStream2 = Stream.iterate(2, i -> i + 2);
    assertEquals(oddLazyZipWithTestRes, Zipper.zipWith(infiniteStream1, infiniteStream2, (x, y) -> x + y).filter(x -> x % 5 != 0).limit(17).collect(Collectors.toList()));
  }

}

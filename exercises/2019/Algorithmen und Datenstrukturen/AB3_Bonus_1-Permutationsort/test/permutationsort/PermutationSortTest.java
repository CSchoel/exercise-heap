package permutationsort;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PermutationSortTest {

  public static final int MIN_VALUE = -1000;
  public static final int MAX_VALUE = 1000;

  public static final int LONG_LIST_SIZE = 10;

  @Test
  public void listSize0Test() {
    testRandomList(0);
  }

  @Test
  public void listSize1Test() {
    testRandomList(1);
  }

  @Test
  public void listLongTest() {
    testRandomList(LONG_LIST_SIZE);
  }

  @Test
  public void testPermutations() {
    List<Integer> lst = new ArrayList<>();
    new Random().ints(6, MIN_VALUE, MAX_VALUE).forEach(lst::add);
    List<List<Integer>> perms = PermutationSort.permutations(lst);
    Set<List<Integer>> distinct = new HashSet<>(perms);
    assertEquals(distinct.size(), perms.size());
  }

  private void testRandomList(int size) {
    List<Integer> lst = new ArrayList<>();
    new Random().ints(size, MIN_VALUE, MAX_VALUE).forEach(i -> lst.add(i));

    List<Integer> correctList = new ArrayList<>(lst);
    Collections.sort(correctList);

    PermutationSort.permutationSort(lst);

    assertTrue("A list of size " + size + " was sorted incorrect", lst.equals(correctList));
  }
}

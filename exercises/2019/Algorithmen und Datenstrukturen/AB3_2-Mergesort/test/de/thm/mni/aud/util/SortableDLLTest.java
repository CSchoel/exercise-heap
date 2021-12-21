package de.thm.mni.aud.util;

import de.thm.mni.aud.SortableDLL;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@FixMethodOrder(NAME_ASCENDING)
public class SortableDLLTest {

  /**
   * Tests if an empty list is "sorted" correctly.
   */
  @Test
  public void t00sort0() {
    SortableDLL<String> lst1 = new SortableDLL<>();
    lst1.sort();
    lst1.checkClassInvariant();
    String expected = "[]";
    assertEquals(expected, lst1.toString());
  }

  /**
   * Tests if a list with one element is "sorted" correctly.
   */
  @Test
  public void t01sort1() {
    SortableDLL<String> lst1 = new SortableDLL<>();
    lst1.append("c");
    lst1.sort();
    lst1.checkClassInvariant();
    String expected = "[c]";
    assertEquals(expected, lst1.toString());
  }

  /**
   * Tests if a list with two elements is sorted correctly.
   */
  @Test
  public void t02sort2() {
    SortableDLL<String> lst1 = new SortableDLL<>();
    lst1.append("c");
    lst1.append("a");
    lst1.sort();
    lst1.checkClassInvariant();
    assertEquals("[a, c]", lst1.toString());
  }

  /**
   * <p>Tests if the algorithm used really is a merge sort variant by
   * inspecting the call structure and intermediary results for a list of size
   * 2^n.</p>
   */
  @Test
  public void t03sortIsMergeSort() {
    SortableDLL<String> lst = new SortableDLL<>();
    for(String s: List.of("c", "a", "f", "e")) { lst.append(s); }
    MergeSortVisualizer<String> v = new MergeSortVisualizer<>();
    lst.sort(v);
    assertEquals("[c, a][f, e]\n[c][a][f][e]\n[a, c][e, f]\n[a, c, e, f]", v.toString());
    System.out.println(v);
  }

  /**
   * Tests if a list with four elements is sorted correctly.
   */
  @Test
  public void t04sort4() {
    SortableDLL<String> lst1 = new SortableDLL<>();
    for(String s: List.of("c", "a", "f", "e")) { lst1.append(s); }
    lst1.sort();
    lst1.checkClassInvariant();
    assertEquals("[a, c, e, f]", lst1.toString());
  }

  /**
   * Tests if a list with four equal elements is "sorted" correctly.
   */
  @Test
  public void t05sort4allEqual() {
    SortableDLL<String> lst1 = new SortableDLL<>();
    for(String s: List.of("a", "a", "a", "a")) { lst1.append(s); }
    lst1.sort();
    lst1.checkClassInvariant();
    assertEquals("[a, a, a, a]", lst1.toString());
  }

  /**
   * Tests if a list with five elements is sorted correctly.
   */
  @Test
  public void t06sort5() {
    SortableDLL<String> lst1 = new SortableDLL<>();
    for(String s: List.of("m", "e", "r", "g", "e")) { lst1.append(s); }
    lst1.sort();
    lst1.checkClassInvariant();
    assertEquals("[e, e, g, m, r]", lst1.toString());
  }

  /**
   * Tests if sorting also works with integers and lists of size ten.
   */
  @Test
  public void t07sort10ints() {
    SortableDLL<Integer> lst1 = new SortableDLL<>();
    for(Integer i: List.of(10, 7, 9, 4, 8, -1, 0, 10, 1, 1)) { lst1.append(i); }
    lst1.sort();
    lst1.checkClassInvariant();
    assertEquals("[-1, 0, 1, 1, 4, 7, 8, 9, 10, 10]", lst1.toString());
  }

  /**
   * Tests sorting algorithm for a list of 40 integers.
   */
  @Test
  public void t08sort40ints() {
    SortableDLL<Integer> lst1 = new SortableDLL<>();
    List<Integer> copy = new ArrayList<>();
    new Random().ints(-20, 20).limit(40).forEach(x -> {
      lst1.append(x);
      copy.add(x);
    });
    lst1.sort();
    lst1.checkClassInvariant();
    Collections.sort(copy);
    assertEquals(copy.toString(), lst1.toString());
  }

  /**
   * Tests if a list of 1000 integers is sorted correctly.
   */
  @Test
  public void t09sort1000ints() {
    SortableDLL<Integer> lst1 = new SortableDLL<>();
    List<Integer> copy = new ArrayList<>();
    new Random().ints(-20, 20).limit(1000).forEach(x -> {
      lst1.append(x);
      copy.add(x);
    });
    lst1.sort();
    Collections.sort(copy);
    Iterator<Integer> i1 = lst1.iterator();
    Iterator<Integer> i2 = copy.iterator();
    int i = 0;
    while(i1.hasNext() && i2.hasNext()) {
      String msg = "Wrong value at index %d";
      assertEquals(String.format(msg, i), i2.next(), i1.next());
      i++;
    }
    if (i1.hasNext()) {
      fail("actual list is larger than expected list");
    } else if (i2.hasNext()) {
      fail("actual list is smaller than expected list");
    }
  }

  /**
   * Ensures that sorting algorithm runs in O(n log n) by using a (very rough)
   * timeout.
   *
   * <p>Note: Like all performance tests this is just a very rough approximation.
   * An O(n log n) algorithm should be able to do this in under a second while
   * an O(n²) algorithm should take multiple minutes.
   * Individual differences in performance on a smaller scale may still be due
   * to a large number of reasons.</p>
   */
  @Test(timeout=1000)
  public void t10sortIsNLogN() {
    /*

     */
    SortableDLL<Integer> lst = new SortableDLL<>();
    Random r = new Random();
    for(int i = 0; i < 100_000; i++) {
      lst.append(r.nextInt(20_000) - 10_000);
    }
    lst.sort();
  }

  /**
   * <p>Tests that sort really works <i>in-place</i>.</p>
   *
   * <p>More specifically it is not allowed to create instances of
   * {@link de.thm.mni.aud.util.DoublyLinkedList.DoublyLinkedNode} with the
   * exception of a single dummy node that can help to make the algorithm
   * a little shorter.</p>
   *
   * <p>It is also not allowed to create other Objects on the heap in either
   * the merge or split steps. This is tested using
   * {@link Runtime#freeMemory()}.</p>
   */
  @Test
  public void t11sortIsInPlace() {
    SortableDLL<Integer> lst = new SortableDLL<>();
    Random r = new Random();
    for(int i = 0; i < 100_000; i++) {
      lst.append(r.nextInt(20_000) - 10_000);
    }
    DoublyLinkedList.DoublyLinkedNode.counter = 0; // reset counter
    long mem = Runtime.getRuntime().freeMemory();
    lst.sort();
    mem -= Runtime.getRuntime().freeMemory();
    String msg = String.format(
      "During sort() a total of %d new nodes was created, but only a single " +
        "dummy node is allowed",
      DoublyLinkedList.DoublyLinkedNode.counter
    );
    assertTrue(msg,DoublyLinkedList.DoublyLinkedNode.counter <= 1);
    /*
    Note: We test for zero here, because Runtime.getRuntime().freeMemory() is
    only an approximation. It IS allowed to create O(1) additional objects,
    but the memory that they require will be below the accuracy of the
    approximation. Note also that this test assumes that the garbage collector
    has not already freed the memory of the additional objects. This should
    be safe to assume with a modern JVM where the GC does not run in big
    chunks but in small incremental steps.
    Edit: Test for 2MB to allow small Errors
     */
    if (mem > 2000000) {
      msg = "Sorting a list with 100_000 elements took approximately " +
        "%d byte extra (heap) space, but sorting should be in-place!";
      fail(String.format(msg, mem));
    }
  }


//  /**
//   * This test is supposed to fail in different ways to show the different
//   * errors that can be detected by
//   * {@link DoublyLinkedList#checkClassInvariant()}.
//   */
//  @Test
//  public void checkInvariantTest() {
//    DoublyLinkedList<String> lst = new DoublyLinkedList<>();
//    for (String s : new String[]{"a", "b", "c", "d", "e"}) {
//      lst.append(s);
//    }
//    lst.checkClassInvariant();
//    lst.first.next.next.next = null;
//
//    //lst.last.next = lst.first;
//    //lst.first.prev = lst.last;
//
//    //lst.first.prev = new DoublyLinkedList.DoublyLinkedNode<>("x");
//    //lst.first.prev.next = lst.first;
//
//    //lst.first.next.next.next.prev = lst.first;
//    lst.checkClassInvariant();
//  }

}

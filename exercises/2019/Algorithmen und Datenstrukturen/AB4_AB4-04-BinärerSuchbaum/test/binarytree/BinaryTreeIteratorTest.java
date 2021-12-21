package binarytree;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertArrayEquals;

public class BinaryTreeIteratorTest {
  /*
    private ABinaryTree<Integer> tree;

    private static <T> Stream<T> iteratorAsStream(final Iterator<T> iterator) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
    }

    private static void addAll(ABinaryTree<Integer> tree, Integer... values) {
        Arrays.stream(values).forEach(tree::add);
    }

    private static void removeAll(ABinaryTree<Integer> tree, Integer... values) {
        Arrays.stream(values).forEach(tree::remove);
    }

    @Before
    public void initialize() {
        tree = new BinaryTree<>(Comparator.<Integer>naturalOrder());
    }

    @Test
    public void breadthFirstOrderIteratorEmptyTest() {
        final Integer[] expectedElements = new Integer[0];

        final Integer[] actualElements = iteratorAsStream(tree.breadthFirstIterator())
                .toArray(Integer[]::new);

        assertArrayEquals("The breadth-first iterator, should give the elements floorwise.",
            expectedElements, actualElements);
    }

    @Test
    public void depthFirstOrderIteratorEmptyTest() {
        final Integer[] expectedElements = new Integer[0];

        final Integer[] actualElements = iteratorAsStream(tree.depthFirstIterator())
                .toArray(Integer[]::new);

        assertArrayEquals("The depth-first iterator, should give the elements in sorted (ascending) order.",
            expectedElements, actualElements);
    }

    @Test
    public void breadthFirstOrderIteratorTest1() {
        addAll(tree, 50, 10, 90, 5, 11, 70, 101);

        final Integer[] expectedElements = new Integer[] { 50, 10, 90, 5, 11, 70, 101 };

        final Integer[] actualElements = iteratorAsStream(tree.breadthFirstIterator())
            .toArray(Integer[]::new);

        assertArrayEquals("The breadth-first iterator, should give the elements floorwise.",
                expectedElements, actualElements);
    }

    @Test
    public void depthFirstOrderIteratorTest1()  {
        addAll(tree, 50, 10, 90, 5, 11, 70, 101);

        final Integer[] expectedElements = new Integer[] { 5, 10, 11, 50, 70, 90, 101 };

        final Integer[] actualElements = iteratorAsStream(tree.depthFirstIterator())
            .toArray(Integer[]::new);

        assertArrayEquals("The depth-first iterator, should give the elements in sorted (ascending) order.",
            expectedElements, actualElements);
    }

    @Test
    public void breadthFirstOrderIteratorTest2() {
        addAll(tree, 1, 2, 42, 0, 3, -42, 50, 99, 23, 2, 77, 35, 100);
        removeAll(tree, 0, 77, 99);

        final Integer[] expectedElements = new Integer[] { 1, -42, 2, 42, 3, 50, 23, 100, 35 };

        final Integer[] actualElements = iteratorAsStream(tree.breadthFirstIterator())
            .toArray(Integer[]::new);

        assertArrayEquals("The breadth-first iterator, should give the elements floorwise.",
            expectedElements, actualElements);
    }

    @Test
    public void depthFirstOrderIteratorTest2()  {
        addAll(tree, 1, 2, 42, 0, 3, -42, 50, 99, 23, 2, 77, 35, 100);
        removeAll(tree, 0, 77, 99);

        final Integer[] expectedElements = new Integer[] { -42, 1, 2, 3, 23, 35, 42, 50, 100 };

        final Integer[] actualElements = iteratorAsStream(tree.depthFirstIterator())
            .toArray(Integer[]::new);

        assertArrayEquals("The depth-first iterator, should give the elements in sorted (ascending) order.",
            expectedElements, actualElements);
    }

    @Test
    public void breadthFirstOrderIteratorTest3()  {
        addAll(tree, 1, 2, 42, 0, 3, -42, 50, 99, 23, 2, 77, 35, 100);
        removeAll(tree, 0, 77, 99, 42);

        final Integer[] expectedElements = new Integer[] { 1, -42, 2, 50, 3, 100, 23, 35 };

        final Integer[] actualElements = iteratorAsStream(tree.breadthFirstIterator())
            .toArray(Integer[]::new);

        assertArrayEquals("The breadth-first iterator, should give the elements floorwise.",
            expectedElements, actualElements);
    }

    @Test
    public void depthFirstOrderIteratorTest3() {
        addAll(tree, 1, 2, 42, 0, 3, -42, 50, 99, 23, 2, 77, 35, 100);
        removeAll(tree, 0, 77, 99, 42);

        final Integer[] expectedElements = new Integer[] { -42, 1, 2, 3, 23, 35, 50, 100 };

        final Integer[] actualElements = iteratorAsStream(tree.depthFirstIterator())
            .toArray(Integer[]::new);

        assertArrayEquals("The depth-first iterator, should give the elements in sorted (ascending) order.",
            expectedElements, actualElements);
    }

   */
}

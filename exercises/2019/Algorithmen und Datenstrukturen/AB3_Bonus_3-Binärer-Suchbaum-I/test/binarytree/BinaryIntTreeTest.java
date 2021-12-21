
package binarytree;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.BiPredicate;

import static org.junit.Assert.*;

public class BinaryIntTreeTest {

    private ABinaryIntTree tree;

    private static void addAll(ABinaryIntTree tree, int... values) {
        Arrays.stream(values).forEach(tree::add);
    }

    private static int[] randomInts(int count) {
        return new Random().ints(count).toArray();
    }

    private static void shuffle(int[] array, int from, int to) {
        final Random rng = new Random();

        for (int i = from; i < to; ++i) {
            int k = from + rng.nextInt(to - from);

            if (i != k) {
                array[i] ^= array[k];
                array[k] ^= array[i];
                array[i] ^= array[k];
            }
        }
    }

    private static BiPredicate<Integer, Integer> LT = (a, b) -> a < b;
    private static BiPredicate<Integer, Integer> GT = (a, b) -> a > b;

    private static boolean isSorted(ABinaryIntTree tree) {
        final ABinaryIntTreeNode root = tree.root();
        return root == null ||
            isSorted(root, root.left(), LT) &&
            isSorted(root, root.right(), GT);
    }

    private static boolean isSorted(ABinaryIntTreeNode parent, ABinaryIntTreeNode node, BiPredicate<Integer, Integer> predicate) {
        return node == null ||
            predicate.test(node.value(), parent.value()) &&
            isSorted(node, node.left(), LT) &&
            isSorted(node, node.right(), GT);
    }

    @Before
    public void initialize() {
        tree = new BinaryIntTree();
    }

    @Test
    public void anEmptyTreeIsEmptyTest() {
        assertTrue("The method .isEmpty() of an empty tree should return true", tree.isEmpty());
    }

    @Test
    public void aNonEmptyTreeIsNotEmptyTest() {
        tree.add(3);
        assertFalse("The method .isEmpty() of a non-empty tree should return false", tree.isEmpty());
    }

    @Test
    public void afterAddingAValueItShouldExistTest() {
        addAll(tree, 5);
        assertTrue("After adding the value 5 it should exist in the binary tree.",
            tree.contains(5));
    }

    @Test
    public void afterAddingValuesTheyShouldExistTest() {
        final int[] values = new int[] { 47, 17, 13, 635 };
        addAll(tree, values);

        Arrays.stream(values)
            .filter(n -> !tree.contains(n))
            .forEach(n ->
                fail(String.format("After adding the values 47, 17, 13 and 635 all of them should exist in the binary " +
                     "tree. Value '%d' doesn't!", n)));
    }

    @Test
    public void afterAddingManyValuesTheyShouldExistTest() {
        final int[] values = randomInts(5000);
        addAll(tree, values);
        shuffle(values, 0, values.length);
        Arrays.stream(values)
            .filter(n -> !tree.contains(n))
            .forEach(n ->
                fail(String.format("After adding many values all of them should exist in the binary tree, but value " +
                     "'%d' doesn't!", n)));
    }

    
    @Test
    public void addingAnElementTwiceShouldNotChangeTheSizeTest() {
        final int[] values = randomInts(4000);
        addAll(tree, values);

        tree.add(5);
        final int oldSize = tree.size();

        tree.add(5);
        assertEquals("Adding an element twice shouldn't change the size of the tree!", oldSize, tree.size());
    }

    @Test
    public void addingDistinctElementsShouldChangeTheSizeTest() {
        tree.add(1);
        assertEquals("After adding a single element to the tree it should have a size of 1!", 1, tree.size());

        tree.add(2);
        tree.add(3);
        tree.add(5);
        assertEquals("Adding distinct elements to the tree, should change its size!", 4, tree.size());
    }

    @Test
    public void afterInsertingElementsTheTreeIsStillSortedTest() {
        final int[] values = randomInts(1000);

        for (final int value : values) {
            assertTrue("Before adding an element to the tree it should be sorted!", isSorted(tree));
            tree.add(value);
            assertTrue("After adding an element to the tree it should be sorted!", isSorted(tree));
        }
    }
}

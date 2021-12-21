
package binarytree;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    private ABinaryTree<String> tree;
    private Comparator<String> naturalOrderComparator;

    private static void addAll(ABinaryTree<String> tree, String... values) {
        Arrays.stream(values).forEach(tree::add);
    }

    private static void removeAll(ABinaryTree<String> tree, String... values) {
        Arrays.stream(values).forEach(tree::remove);
    }

    private static String[] randomStrings(final int minLength, final int maxLength, final int count) {
        final Random random = new Random();

        final IntFunction<String> makeRandomStringWithLength = (len) ->
             random.ints(len, (int) 'A', (int) 'Z')
            .mapToObj(c -> Character.toString((char) c))
            .collect(Collectors.joining());

        return random.ints(count, minLength, maxLength)
            .mapToObj(makeRandomStringWithLength)
            .toArray(String[]::new);
    }

    private static <T> void shuffle(T[] array, int from, int to) {
        final Random rng = new Random();

        for (int i = from; i < to; ++i) {
            int k = from + rng.nextInt(to - from);

            if (i != k) {
                T tmp = array[i];
                array[i] = array[k];
                array[k] = tmp;
            }
        }
    }

    private static <T> boolean isSorted(ABinaryTree<T> tree, Comparator<T> comparator) {
        final ABinaryTreeNode<T> root = tree.root();
        final BiPredicate<T, T> LT = (a, b) -> comparator.compare(a, b) < 0;
        final BiPredicate<T, T> GT = (a, b) -> comparator.compare(a, b) > 0;

        return root == null ||
            isSorted(LT, GT, root, root.left(), LT) &&
            isSorted(LT, GT, root, root.right(), GT);
    }

    private static <T> boolean isSorted(BiPredicate<T, T> LT, BiPredicate<T, T> GT,
                                        ABinaryTreeNode<T> parent, ABinaryTreeNode<T> node, BiPredicate<T, T> predicate) {
        return node == null ||
            predicate.test(node.value(), parent.value()) &&
                isSorted(LT, GT, node, node.left(), LT) &&
                isSorted(LT, GT, node, node.right(), GT);
    }

    @Before
    public void initialize() {
        naturalOrderComparator = Comparator.naturalOrder();
        tree = new BinaryTree<>(naturalOrderComparator);
    }

    @Test
    public void anEmptyTreeIsEmptyTest() {
        assertTrue("The method .isEmpty() of an empty tree should return true", tree.isEmpty());
    }

    @Test
    public void aNonEmptyTreeIsNotEmptyTest() {
        tree.add("Hello");
        assertFalse("The method .isEmpty() of a non-empty tree should return false", tree.isEmpty());
    }

    @Test
    public void afterAddingAValueItShouldExistTest() {
        tree.add("Foobar");
        assertTrue("After adding the value \"Foobar\" it should exist in the binary tree.",
            tree.contains("Foobar"));
    }

    @Test
    public void afterAddingValuesTheyShouldExistTest() {
        final String[] values = new String[] { "foo", "bar", "Hello", "World" };
        addAll(tree, values);

        Arrays.stream(values)
            .filter(n -> !tree.contains(n))
            .forEach(n ->
                fail(String.format("After adding the values \"foo\", \"bar\", \"Hello\" and \"World\" all of them " +
                    "should exist in the binary tree. Value '%s' doesn't!", n)));
    }

    @Test
    public void afterAddingManyValuesTheyShouldExistTest() {
        final String[] values = randomStrings(0, 100, 3000);
        addAll(tree, values);
        shuffle(values, 0, values.length);

        Arrays.stream(values)
            .filter(n -> !tree.contains(n))
            .forEach(n ->
                fail(String.format("After adding many values all of them should exist in the binary tree, but value '%s' doesn't!", n)));
    }

    @Test
    public void afterRemovingAValueItShouldNotExistTest() {
        addAll(tree, "foobar");
        removeAll(tree, "foobar");
        assertTrue("After adding and removing the value 5 it shouldn't exist in the binary tree.",
            !tree.contains("foobar"));
    }

    @Test
    public void afterRemovingValuesTheyShouldNotExistTest() {
        final String[] values = new String[] { "foo", "bar", "Hello", "World" };
        final String[] values2 = new String[] {"Hello", "World"};
        addAll(tree, values);
        shuffle(values, 0, values.length);
        removeAll(tree, values2);

        Arrays.stream(values2)
            .filter(tree::contains)
            .forEach(n ->
                fail(String.format("After adding and removing the values \"Hello\" and \"World\" " +
                    "none of them should exist in the binary tree, but value '%s' does!", n)));
    }

    @Test
    public void afterRemovingManyValuesTheyShouldNotExistTest() {
        final String[] values = randomStrings(0, 500,5000);
        addAll(tree, values);
        shuffle(values, 0, values.length);
        removeAll(tree, values);

        Arrays.stream(values)
            .filter(tree::contains)
            .forEach(n ->
                fail(String.format("After adding and removing many values none of them should exist in the binary tree, but value '%s' does!", n)));
    }

    @Test
    public void addingAnElementTwiceShouldNotChangeTheSizeTest() {
        final String[] values = randomStrings(0, 100,100);
        addAll(tree, values);

        tree.add("meow");
        final int oldSize = tree.size();

        tree.add("meow");
        assertEquals("Adding an element twice shouldn't change the size of the tree!", oldSize, tree.size());
    }

    @Test
    public void addingDistinctElementsShouldChangeTheSizeTest() {
        tree.add("cat");
        assertEquals("After adding a single element to the tree it should have a size of 1!", 1, tree.size());

        tree.add("dog");
        tree.add("mouse");
        tree.add("chinchilla");
        assertEquals("Adding distinct elements to the tree, should change its size!", 4, tree.size());
    }


    @Test
    public void afterInsertingElementsTheTreeIsStillSortedTest() {
        final String[] values = randomStrings(0, 100,1000);

        for (final String value : values) {
            assertTrue("Before adding an element to the tree it should be sorted!",
                isSorted(tree, naturalOrderComparator));
            tree.add(value);
            assertTrue("After adding an element to the tree it should be sorted!",
                isSorted(tree, naturalOrderComparator));
        }
    }

    @Test
    public void afterInsertingAndRemovingElementsTheTreeIsStillSortedTest() {
        final String[] values = randomStrings(0, 100,1000);

        addAll(tree, values);
        assertTrue("After adding 1000 elements, the tree should be sorted!",
            isSorted(tree, naturalOrderComparator));

        shuffle(values, 1, values.length);

        assertTrue("Before removing the root node the tree should be sorted!",
            isSorted(tree, naturalOrderComparator));
        tree.remove(values[0]);
        assertTrue("After removing the root node the tree should be sorted!",
            isSorted(tree, naturalOrderComparator));

        for (final String value : values) {
            assertTrue("Before removing an element to the tree it should be sorted!",
                isSorted(tree, naturalOrderComparator));
            tree.remove(value);
            assertTrue("After removing an element to the tree it should be sorted!",
                isSorted(tree, naturalOrderComparator));
        }
    }

}

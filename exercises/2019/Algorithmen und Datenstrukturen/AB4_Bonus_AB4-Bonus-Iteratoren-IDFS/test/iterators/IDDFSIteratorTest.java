package iterators;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class IDDFSIteratorTest {


    @Test
    public void testOnlyRoot() {
        TreeInterface<Integer> tree = new Tree<>(0);
        Iterator<Integer> iterator = tree.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new Integer(0));
    }

    @Test
    public void testSimpleTree() {
        Integer[] testValues = {0, 0, 1, 2, 3, 4, 0, 1, 5, 6, 7, 2, 8, 9, 10, 3, 11, 4, 14, 15, 0, 1, 5, 6, 7, 2, 8, 9, 10, 3, 11, 12, 13, 4, 14, 15};
        TreeInterface<Integer> tree = new Tree<>(0);
        TreeInterface<Integer> tree1 = new Tree<>(1);
        tree1.addChild(5).addChild(6).addChild(7);
        TreeInterface<Integer> tree2 = new Tree<>(2);
        tree2.addChild(8).addChild(9).addChild(10);
        TreeInterface<Integer> tree3 = new Tree<>(3);
        tree3.addChild(new Tree<>(11).addChild(12).addChild(13));
        TreeInterface<Integer> tree4 = new Tree<>(4);
        tree4.addChild(14).addChild(15);

        tree.addChild(tree1);
        tree.addChild(tree2);
        tree.addChild(tree3);
        tree.addChild(tree4);

        Iterator<Integer> iterator = tree.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            if (index >= testValues.length) {
                fail("You iterated out of bounds");
            }
            Integer val = iterator.next();
            //System.out.println(val);
            assertEquals(val, testValues[index]);
            index += 1;
        }
        if (index < testValues.length) {
            fail("You stopped iterating too early");
        }
    }

    @Test
    public void testOveriterate() {
        TreeInterface<Integer> tree = new Tree<>(0);
        Iterator<Integer> iterator = tree.iterator();
        iterator.next();
        assertFalse(iterator.hasNext());
        try {
            iterator.next();
            fail("You didn't throw an exception when the iterator shouldn't have any more elements");
        } catch (Exception e) {

        }
    }
}

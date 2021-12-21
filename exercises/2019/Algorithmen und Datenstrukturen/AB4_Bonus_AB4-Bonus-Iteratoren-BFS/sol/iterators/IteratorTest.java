package iterators;

import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(2);
        Tree<Integer> tree2 = new Tree<>(2);
        //tree2.addChild(new Tree<>(8));
        tree2.addChild(8);
        tree2.addChild(new Tree<>(23));
        //tree2.addChild(new Tree<>(8).addChild(23));
        Tree<Integer> tree3 = new Tree<>(2);
        tree3.addChild(new Tree<>(7));
        Tree<Integer> tree4 = new Tree<>(2);
        tree4.addChild(new Tree<>(6));
        tree4.addChild(new Tree<>(6));
        tree4.addChild(new Tree<>(6));
        tree4.addChild(new Tree<>(6));
        Tree<Integer> tree5 = new Tree<>(2);
        tree5.addChild(new Tree<>(5));
        tree5.addChild(new Tree<>(65));
        Tree<Integer> tree50 = new Tree<>(87);
        tree50.addChild(new Tree<>(123));
        tree50.addChild(new Tree<>(5432));
        tree5.addChild(tree50);

        tree.addChild(tree2);
        tree.addChild(tree3);
        tree.addChild(tree4);
        tree.addChild(tree5);

        Iterator iterator = tree.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

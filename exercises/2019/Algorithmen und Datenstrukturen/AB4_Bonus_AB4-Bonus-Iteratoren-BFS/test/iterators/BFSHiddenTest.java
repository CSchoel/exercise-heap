package iterators;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BFSHiddenTest {

    private TreeInterface<Integer> referenceTree = new ReferenceTree<Integer>(0) {
        @Override
        public Iterator<Integer> iterator() {
            return new ReferenceIterator<>(referenceTree);
        }
    };
    private TreeInterface<Integer> studentTree = new ReferenceTree<Integer>(0) {
        @Override
        public Iterator<Integer> iterator() {
            return new BFSIterator<>(studentTree);
        }
    };

    private void randomTrees(Random r, int maxDepth, int maxWidth, int maxContent, TreeInterface<Integer> rTree, TreeInterface<Integer> sTree) {
        if (maxDepth <= 0) return;
        int branchCount = r.nextInt(maxWidth);
        for (int i = 0; i < branchCount; i++) {
            int branchLength = r.nextInt(maxDepth);
            int content = r.nextInt(maxContent);
            TreeInterface<Integer> localRef = new ReferenceTree<Integer>(content) {
                @Override
                public Iterator<Integer> iterator() {
                    return new ReferenceIterator<>(referenceTree);
                }
            };
            TreeInterface<Integer> localStud = new ReferenceTree<Integer>(content) {
                @Override
                public Iterator<Integer> iterator() {
                    return new BFSIterator<>(studentTree);
                }
            };
            rTree.addChild(localRef);
            sTree.addChild(localStud);
            randomTrees(r, branchLength, branchCount, maxContent, localRef, localStud);
        }
    }

    @Before
    public void init() {
        Random r = new Random();
        int branchCount = r.nextInt(20);
        System.out.println(String.format("%d branches", branchCount));
        randomTrees(r, 35, branchCount, 100, referenceTree, studentTree);
    }

    @Test
    public void testRandomTree() {
        Iterator<Integer> refIterator = referenceTree.iterator();
        Iterator<Integer> studIterator = studentTree.iterator();
        while (refIterator.hasNext()) {
            if (!studIterator.hasNext()) {
                fail("Your iterator stopped too early");
            }
            int refVal = refIterator.next();
            int studVal = studIterator.next();
            //System.out.println(String.format("%d, %d", refVal, studVal));
            assertEquals(refVal, studVal);
        }
        if (studIterator.hasNext()) {
            fail("Your iterator stopped too late");
        }
    }

}

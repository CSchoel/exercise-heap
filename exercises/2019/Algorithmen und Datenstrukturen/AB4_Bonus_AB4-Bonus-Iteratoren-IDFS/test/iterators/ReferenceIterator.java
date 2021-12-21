package iterators;

import iterators.TreeInterface;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReferenceIterator<E> implements Iterator<E> {

    private Deque<NodeInfo> nodes = new ArrayDeque<>();
    private int maxDepth = 1;
    private int currentMaxDepth = 0;
    private int currentDepth = 0;
    private TreeInterface<E> tree;

    public ReferenceIterator(TreeInterface<E> tree) {
        System.out.println("IDFS");
        this.tree = tree;
        nodes.addFirst(new NodeInfo(tree, 0));
        currentMaxDepth = 0;
    }

    @Override
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    @Override
    public E next() {
        if (nodes.isEmpty()) throw new NoSuchElementException();
        NodeInfo out = nodes.peekFirst();
        if (!out.node.getChildren().isEmpty() && currentDepth < currentMaxDepth) {
            //System.out.println("Going deeper");

            nodes.addFirst(new NodeInfo(out.node.getChildren().get(0), 0));
            currentDepth += 1;
        } else {
            if (!out.node.getChildren().isEmpty() && currentDepth == currentMaxDepth && currentMaxDepth == maxDepth - 1) {
                maxDepth += 1;
                //System.out.println(String.format("Erhöhe maxDepth auf %d", maxDepth));
            }
            NodeInfo childNote = nodes.removeFirst();
            while (!nodes.isEmpty() && childNote.childIndex + 1 >= nodes.peekFirst().node.getChildren().size()) {
                //System.out.println("Going up");
                childNote = nodes.removeFirst();
                currentDepth -= 1;
            }
            //System.out.println("Going right");
            NodeInfo parent = nodes.peekFirst();
            if (parent == null) {
                currentDepth = 0;
                if (currentMaxDepth + 1 < maxDepth) {
                    currentMaxDepth += 1;
                    //System.out.println("Pushing root");
                    nodes.addFirst(new NodeInfo(tree, 0));
                }
                //System.out.println();
                return out.node.getContent();
            }
            nodes.addFirst(new NodeInfo(parent.node.getChildren().get(childNote.childIndex + 1), childNote.childIndex + 1));
        }
        return out.node.getContent();
    }


    private class NodeInfo {
        private final TreeInterface<E> node;
        private final int childIndex;

        private NodeInfo(TreeInterface<E> node, int childIndex) {
            this.node = node;
            this.childIndex = childIndex;
        }
    }
}
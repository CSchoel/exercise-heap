package binarytree;

import java.util.Comparator;

public abstract class ABinaryTree<T> {

    protected final Comparator<T> comparator;

    public ABinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * @return the root node of this tree.
     */
    public abstract ABinaryTreeNode<T> root();

    /**
     * Add a value of type T to this binary tree.
     */
    public abstract void add(T value);

    /**
     * Remove a value of type T from this binary tree.
     */
    public abstract void remove(T value);

    /**
     * Check, if the value of type T exists in this tree.
     */
    public abstract boolean contains(T value);

    /**
     * @return true, if this tree is empty, false otherwise.
     */
    public abstract boolean isEmpty();

    /**
     * The number of elements in this tree.
     */
    public abstract int size();

    /**
     * Return an iterator, which traverses this tree in breadth-first-order.
     */
    //public abstract java.util.Iterator<T> breadthFirstIterator();

    /**
     * Return an iterator, which traverses this tree in depth-first in-order.
     */
    //public abstract java.util.Iterator<T> depthFirstIterator();

}

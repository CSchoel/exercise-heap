package binarytree;

public abstract class ABinaryIntTree {

    /**
     * @return the root node of this tree.
     */
    public abstract ABinaryIntTreeNode root();

    /**
     * Add an integer value into this binary tree.
     */
    public abstract void add(int value);

    /**
     * Remove an integer value from this binary tree.
     */
    public abstract void remove(int value);

    /**
     * Check, if the integer value exists in this tree.
     */
    public abstract boolean contains(int value);

    /**
     * @return true, if this tree is empty, false otherwise.
     */
    public abstract boolean isEmpty();

    /**
     * @return the number of elements in this tree.
     */
    public abstract int size();

}

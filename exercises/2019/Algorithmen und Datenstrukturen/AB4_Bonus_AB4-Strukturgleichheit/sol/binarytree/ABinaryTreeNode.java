package binarytree;

public abstract class ABinaryTreeNode<T> {

    /**
     * @return the value stored in this node.
     */
    public abstract T value();

    /**
     * @return the left subtree of this node.
     */
    public abstract ABinaryTreeNode<T> left();

    /**
     * @return the right subtree of this node.
     */
    public abstract ABinaryTreeNode<T> right();
}

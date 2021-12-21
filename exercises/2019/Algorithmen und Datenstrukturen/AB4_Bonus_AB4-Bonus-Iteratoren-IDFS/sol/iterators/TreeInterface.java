package iterators;

import java.util.List;

public interface TreeInterface<E> extends Iterable<E> {

    /**
     * @return the node's content
     */
    public E getContent();

    /**
     * @return a list of the node's children
     */
    public List<TreeInterface<E>> getChildren();

    /**
     * Adds a node to this node's children.
     *
     * @param child the node to add
     */
    public void addChild(TreeInterface<E> child);

    /**
     * Creates a node from a value and adds it to this node's children.
     * This function returns this node to make chaining possible.
     *
     * @param child the value to create the node from
     * @return this node
     */
    public TreeInterface<E> addChild(E child);
}

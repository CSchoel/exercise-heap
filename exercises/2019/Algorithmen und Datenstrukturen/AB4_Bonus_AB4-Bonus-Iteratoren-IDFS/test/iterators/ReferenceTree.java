package iterators;

import iterators.Tree;
import iterators.TreeInterface;

import java.util.LinkedList;
import java.util.List;

public abstract class ReferenceTree<E> implements TreeInterface<E> {


    private final E content;
    private List<TreeInterface<E>> children = new LinkedList<>();

    public ReferenceTree(E content) {
        //System.out.println("BFS");
        this.content = content;
    }

    public E getContent() {
        return content;
    }

    @Override
    public List<TreeInterface<E>> getChildren() {
        return children;
    }

    @Override
    public void addChild(TreeInterface<E> child) {
        children.add(child);
    }

    @Override
    public TreeInterface<E> addChild(E child) {
        TreeInterface<E> tree = new Tree<>(child);
        addChild(tree);
        return this;
    }

    //@Override
    //public Iterator<E> iterator() {
    //    return new iterators.ReferenceIterator<>(this);
    //}
}

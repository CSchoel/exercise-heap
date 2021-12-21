package iterators;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class ReferenceIterator<E> implements Iterator<E> {

    private Queue<TreeInterface<E>> nodes = new ArrayDeque<>();

    public ReferenceIterator(TreeInterface<E> tree) {
        nodes.offer(tree);
    }

    @Override
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    @Override
    public E next() {
        TreeInterface<E> out = nodes.poll();
        if (out == null) throw new IllegalStateException();
        out.getChildren().forEach(a -> nodes.offer(a));
        return out.getContent();
    }
}
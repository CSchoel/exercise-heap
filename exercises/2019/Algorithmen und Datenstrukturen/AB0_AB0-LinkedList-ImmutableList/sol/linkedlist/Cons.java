package linkedlist;

import java.util.function.Function;

public class Cons<A> implements ImmutableList<A> {

    private A elem;
    private ImmutableList<A> next;

    public Cons(A elem, ImmutableList<A> next) {
        this.elem = elem;
        this.next = next;
    }

    @Override
    public ImmutableList<A> cons(A elem) {
        next = next.cons(this.elem);
        this.elem = elem;
        return this;
    }

    @Override
    public ImmutableList<A> append(A elem) {
        return new Cons<A>(this.elem, next.append(elem));
    }

    @Override
    public int size() {
        return next.size() + 1;
    }

    @Override
    public A getAt(int idx) throws IndexOutOfBoundsException {
        if (idx < 0) throw new IndexOutOfBoundsException("Index out of bounds!");
        return idx == 0 ? elem : next.getAt(--idx);
    }

    @Override
    public <B> ImmutableList<B> map(Function<A, B> fn) {
        ImmutableList<B> tmp = new Nil<>();
        for (int i = 0; i < size(); i++) tmp = tmp.append(fn.apply(getAt(i)));
        return tmp;
    }

    @Override
    public String toString() {
        return "Cons(" + elem.toString() + ", " + next.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Cons && elem.equals(((Cons) o).elem) && next.equals(((Cons) o).next);
    }

}

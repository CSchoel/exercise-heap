package linkedlist;

import java.util.function.Function;

public class Nil<A> implements ImmutableList<A> {

    @Override
    public ImmutableList<A> cons(A elem) {
        return append(elem);
    }

    @Override
    public ImmutableList<A> append(A elem) {
        return new Cons<>(elem, this);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public A getAt(int idx) throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException("Index out of bounds!");
    }

    @Override
    public <B> ImmutableList<B> map(Function<A, B> fn) {
        return new Nil<>();
    }

    @Override
    public String toString() {
        return "Nil";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Nil;
    }

}

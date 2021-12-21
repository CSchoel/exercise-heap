package linkedlist;

import java.util.function.Function;

class Nil<A> implements ImmutableList<A> {

    @Override
    public ImmutableList<A> cons(A elem) {
        return new Cons<A>(elem, this);
    }

    @Override
    public ImmutableList<A> append(A elem) {
        return cons(elem);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public A getAt(int idx) throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException("Nil is empty");
    }

    @Override
    public <B> ImmutableList<B> map(Function<A, B> fn) {
        return new Nil<B>();
    }

    @Override
    public String toString() {
        return "Nil";
    }

    @Override
    public boolean equals(Object other) {
        if(other == null) {
            return false;
        } else {
            return other instanceof Nil || this == other;
        }
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}

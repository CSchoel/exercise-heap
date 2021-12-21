package linkedlist;

import java.util.function.Function;

public class Cons<A> implements ImmutableList<A> {

    private final A element;
    private final ImmutableList<A> tail;
    public Cons(A element, ImmutableList<A> tail) {
        this.element = element;
        this.tail = tail;
    }
    @Override
    public ImmutableList<A> cons(A elem) {
        return new Cons<A>(elem, this);
    }

    @Override
    public ImmutableList<A> append(A elem) {
        return appendImpl(elem, this);
    }

    private ImmutableList<A> appendImpl(A elem, ImmutableList<A> current) {
        if(current instanceof Cons) {
            Cons<A> currentCons = (Cons<A>) current;
            return new Cons<A>(currentCons.element, appendImpl(elem, currentCons.tail));
        } else {
            //current is Nil == empty list
            return new Cons<A>(elem, current);
        }
    }

    @Override
    public int size() {
        return 1 + tail.size();
    }


    @Override
    public A getAt(int idx) throws IndexOutOfBoundsException {
        return (idx==0) ? element : tail.getAt(idx-1);
    }

    @Override
    public <B> ImmutableList<B> map(Function<A, B> fn) {
        return new Cons<B>(fn.apply(this.element), this.tail.map(fn));
    }

    @Override
    public String toString() {
        return String.format("Cons(%s, %s)", element.toString(), tail.toString());
    }

    @Override
    public boolean equals(Object other) {
        if(other == null) return false;
        else if(other instanceof Cons) {
            Cons<A> otherCons = (Cons<A>) other;
            return this.element.equals(otherCons.element) && this.tail.equals(otherCons.tail);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}

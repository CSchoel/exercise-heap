package linkedlist;

import java.util.function.Function;

public interface ImmutableList<A> {

    ImmutableList<A> cons(A elem);

    ImmutableList<A> append(A elem);

    int size();

    A getAt(int idx) throws IndexOutOfBoundsException;

    <B> ImmutableList<B> map(Function<A, B> fn);

}


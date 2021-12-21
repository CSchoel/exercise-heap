package linkedlist;

import java.util.function.Function;


public interface ImmutableList<A> {
  /** Prepends elem infront of this list */
  ImmutableList<A> cons(A elem);
  /** Appends elem at the end of this list. */
  ImmutableList<A> append(A elem);
  /** Returns the size of the list. */
  int size();
  /** Returns the element at the index idx. */
  A getAt(int idx) throws IndexOutOfBoundsException;

  <B> ImmutableList<B> map(Function<A,B> fn);
}
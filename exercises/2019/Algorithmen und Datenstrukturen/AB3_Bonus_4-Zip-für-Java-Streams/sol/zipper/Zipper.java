package zipper;

import java.util.Iterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Zipper {

  static <A, B> Stream<Tuple<A, B>> zip(Stream<A> stream1, Stream<B> stream2) {
    Iterator<A> iteratorA = stream1.iterator();
    Iterator<B> iteratorB = stream2.iterator();

    Iterator<Tuple<A, B>> iterator= new Iterator<Tuple<A, B>>() {
      @Override
      public boolean hasNext() {
        return iteratorA.hasNext() && iteratorB.hasNext();
      }

      @Override
      public Tuple<A, B> next() {
        return zip(iteratorA.next(), iteratorB.next());
      }
    };

    return StreamSupport.stream(Spliterators.spliterator(iterator, Long.MAX_VALUE, 0), false);
  }

  private static <A, B> Tuple<A, B> zip(A val1, B val2) {
    return new Tuple<>(val1, val2);
  }

  static <A, B, C> Stream<C> zipWith(Stream<A> stream1, Stream<B> stream2, BiFunction<A, B, C> biFn) {
    return zip(stream1, stream2).map(tuple -> biFn.apply(tuple._1(), tuple._2()));
  }
}

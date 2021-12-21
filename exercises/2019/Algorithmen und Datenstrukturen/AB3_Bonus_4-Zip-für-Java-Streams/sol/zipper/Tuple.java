package zipper;

class Tuple<A, B> {

  private A val1;
  private B val2;

  Tuple(A val1, B val2) {
    this.val1 = val1;
    this.val2 = val2;
  }

  A _1() {
    return val1;
  }

  B _2() {
    return val2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Tuple<?, ?> tuple = (Tuple<?, ?>) o;

    return (val1 != null ? val1.equals(tuple.val1) : tuple.val1 == null) && (val2 != null ? val2.equals(tuple.val2) : tuple.val2 == null);
  }

  @Override
  public String toString() {
    return "(" + val1 + ", " + val2 + ")";
  }
}

package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;


public class ImmutableListTest {

  @Test
  public void immutabilityTest() {
    ImmutableList<Integer> nil = new Nil<>();
    ImmutableList<Integer> cons = new Cons<>(42, new Nil<>());

    assertNotSame("List is not immutable", nil, nil.append(43));
    assertNotSame("List is not immutable", nil, nil.cons(44));
    assertNotSame("List is not immutable", cons, cons.append(45));
    assertNotSame("List is not immutable", cons, cons.cons(46));
  }

  @Test
  public void equalsTest() {
    assertEquals(new Nil<String>(), new Nil<>());
    assertEquals(new Cons<Integer>(5, new Nil<>()), new Cons<>(5, new Nil<>()));
    assertNotEquals(new Cons<Integer>(5, new Nil<>()), new Cons<>(6, new Nil<>()));
    assertNotEquals(new Cons<Integer>(5, new Nil<>()), new Nil<>());
    assertEquals(
      new Cons<Integer>(5, new Cons<>(6, new Cons<>(7, new Nil<>()))),
      new Cons<Integer>(5, new Cons<>(6, new Cons<>(7, new Nil<>()))));
    assertNotEquals(
      new Cons<Integer>(5, new Cons<>(8, new Cons<>(7, new Nil<>()))),
      new Cons<Integer>(5, new Cons<>(6, new Cons<>(7, new Nil<>()))));
  }

  @Test
  public void nilTest() {
    ImmutableList<Object> nil = new Nil<>();
    assertEquals(0, nil.size());
    assertEquals("Nil", nil.toString());
  }

  @Test
  public void toStringTest() {
    assertEquals("Nil", new Nil<String>().toString());
    assertEquals("Cons(5, Cons(3, Nil))", new Cons<Integer>(5, new Cons<>(3, new Nil<>())).toString());
  }

  @Test
  public void consTest() {
    ImmutableList<Integer> lst = new Cons<>(5, new Nil<>());
    assertEquals(lst, new Nil<Integer>().cons(5));

    ImmutableList<String> lst2 = new Cons<>("Tom", new Cons<>("Tim", new Cons<>("Meier", new Nil<>())));
    assertEquals(lst2, new Nil<String>().cons("Meier").cons("Tim").cons("Tom"));
  }

  @Test
  public void appendTest() {
    ImmutableList<Integer> lst = new Cons<>(5, new Nil<>());
    assertEquals(lst, new Nil<Integer>().append(5));

    ImmutableList<String> lst2 = new Cons<>("Tom", new Cons<>("Tim", new Cons<>("Meier", new Nil<>())));
    assertEquals(lst2, new Cons<>("Tom", new Nil<>()).append("Tim").append("Meier"));
  }

  @Test
  public void sizeTest() {
    ImmutableList<String> lst = new Nil<>();
    ImmutableList<String> lst2 = new Cons<>("Tom", new Cons<>("Tim", new Cons<>("Meier", new Nil<>())));
    assertEquals(0, lst.size());
    assertEquals(3, lst2.size());
  }

  @Test
  public void mapTest() {
    ImmutableList<String> lst = new Cons<>("Tom", new Cons<>("Tim", new Cons<>("Meier", new Nil<>())));
    assertEquals(new Cons<Integer>(3, new Cons<>(3, new Cons<>(5, new Nil<>()))),
      lst.map(s -> s.length()));

    ImmutableList<Integer> lst2 = new Cons<>(2, new Cons<>(4, new Cons<>(6, new Nil<>())));
    assertEquals(new Cons<Integer>(4, new Cons<>(8, new Cons<>(12, new Nil<>()))),
      lst2.map(i -> i * 2));
  }

  @Test
  public void getAtTest() {
    ImmutableList<String> lst = new Cons<>("Tom", new Cons<>("Tim", new Cons<>("Meier", new Cons<>("Lisa", new Nil<>()))));
    assertEquals("Tom", lst.getAt(0));
    assertEquals("Lisa", lst.getAt(3));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void nilIndexOutOfBoundsTest() {
    ImmutableList<String> lst = new Nil<>();
    lst.getAt(0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void consIndexOutOfBoundsTest() {
    ImmutableList<String> lst = new Cons<>("Tom", new Cons<>("Tim", new Cons<>("Meier", new Cons<>("Lisa", new Nil<>()))));
    lst.getAt(4);
  }

}

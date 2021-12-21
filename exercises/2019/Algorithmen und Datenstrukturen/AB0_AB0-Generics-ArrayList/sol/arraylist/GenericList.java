package arraylist;

public interface GenericList<E> {
  E get(int idx); // retrieve element
  void set(E el, int idx); // overwrite element
  int size(); // number of elements
  void add(E el); // append to end
  void remove(int idx); // remove at index
  void insert(E el, int idx); // insert at index
}

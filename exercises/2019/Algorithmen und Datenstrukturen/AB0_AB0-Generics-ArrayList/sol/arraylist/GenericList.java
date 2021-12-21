package arraylist;

public interface GenericList<E> {

    E get(int idx);

    void set(E el, int idx);

    int size();

    void add(E el);

    void remove(int idx);

    void insert(E el, int idx);

}

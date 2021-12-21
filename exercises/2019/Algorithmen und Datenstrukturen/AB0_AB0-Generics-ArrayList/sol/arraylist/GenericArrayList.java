package arraylist;

public class GenericArrayList<E> implements GenericList<E> {

    private E[] content;
    private int size;

    public GenericArrayList() {
        this(0);
    }

    @SuppressWarnings("unchecked")
    public GenericArrayList(int size) {
        content = (E[]) new Object[size];
        this.size = 0;
    }

    @Override
    public E get(int idx) {
        return content[idx];
    }

    @Override
    public void set(E el, int idx) {
        content[idx] = el;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E el) {
        if (size == content.length) increase();
        content[size++] = el;
    }

    @SuppressWarnings("unchecked")
    private void increase() {
        E[] tmp = (E[]) new Object[content.length + 1];
        for (int i = 0; i < content.length; i++) tmp[i] = content[i];
        content = tmp;
    }

    @Override
    public void remove(int idx) {
        size--;
        for (int i = idx; i < size; i++) content[i] = content[i + 1];
    }

    @Override
    public void insert(E el, int idx) {
        if (size == content.length) increase();
        for (int i = size - 1; i >= idx; i--) content[i + 1] = content[i];
        content[idx] = el;
        size++;
    }

}

package core.util;

public interface ListP<E> extends CollectionP<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    IteratorP<E> iterator();

    Object[] toArray();

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(CollectionP<?> c);

    boolean addAll(CollectionP<? extends E> c);

    boolean addAll(int index, CollectionP<? extends E> c);

    boolean removeAll(CollectionP<?> c);

    void clear();

    boolean equals(Object o);

    int hashCode();

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    ListIteratorInternal<E> listIterator();
}

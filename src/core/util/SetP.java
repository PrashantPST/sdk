package core.util;

public interface SetP<E> extends CollectionP<E> {

    int size();

    boolean isEmpty();

    IteratorP<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean add(E e);

    boolean remove(Object o);

    void clear();

    boolean equals(Object o);

    int hashCode();

    boolean contains(Object o);

    boolean containsAll(CollectionP<?> c);

    boolean retainAll(CollectionP<?> c);

    boolean addAll(CollectionP<? extends E> c);

    boolean removeAll(CollectionP<?> c);
}


package core.util;

import core.lang.IterableP;

public interface CollectionP<E> extends IterableP<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    IteratorP<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean add(E e);

    boolean remove(Object o);

    void clear();

    boolean equals(Object o);

    int hashCode();

    boolean containsAll(CollectionP<?> c);

    boolean addAll(CollectionP<? extends E> c);

    boolean removeAll(CollectionP<?> c);

    boolean retailAll(CollectionP<?> c);
}

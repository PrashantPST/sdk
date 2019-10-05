package core.util;

import java.util.Iterator;

public interface CollectionInternal<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean add(E e);

    boolean remove(Object o);

    void clear();

    boolean equals(Object o);

    int hashCode();

    boolean containsAll(CollectionInternal<?> c);

    boolean addAll(CollectionInternal<? extends E> c);

    boolean removeAll(CollectionInternal<?> c);

    boolean retailAll(CollectionInternal<?> c);
}

package core.util;

import java.util.Iterator;

public interface SetInternal<E> extends CollectionInternal<E> {

    int size();

    boolean isEmpty();

    Iterator<E> iterator();

    Object[] toArray();

    boolean add(E e);

    boolean remove(Object o);

    void clear();

    boolean equals(Object o);

    int hashCode();

    boolean contains(Object o);

    boolean containsAll(CollectionInternal<?> c);

    boolean retainAll(CollectionInternal<?> c);

    boolean addAll(CollectionInternal<? extends E> c);

    boolean removeAll(CollectionInternal<?> c);
}


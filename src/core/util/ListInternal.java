package core.util;

import java.util.Iterator;
import java.util.ListIterator;

public interface ListInternal<E> extends CollectionInternal<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<E> iterator();

    Object[] toArray();

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(CollectionInternal<?> c);

    boolean addAll(CollectionInternal<? extends E> c);

    boolean addAll(int index, CollectionInternal<? extends E> c);

    boolean removeAll(CollectionInternal<?> c);

    void clear();

    boolean equals(Object o);

    int hashCode();

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    ListIterator<E> listIterator();
}

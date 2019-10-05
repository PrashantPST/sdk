package core.util;

public interface ListIteratorInternal<E> extends IteratorInternal<E> {

    boolean hasNext();

    E next();

    boolean hasPrevious();

    E previous();

}

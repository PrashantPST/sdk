package core.util;

public abstract class AbstractCollectionP<E> implements CollectionP<E> {

    public abstract int size();

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        IteratorP<E> it = iterator();
        if (o == null) {
            while (it.hasNext())
                if (it.next() == null)
                    return true;
        } else {
            while (it.hasNext())
                if (o.equals(it.next()))
                    return true;
        }
        return false;
    }

    public boolean containsAll(CollectionP<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }
}

package core.util;

import java.util.Iterator;

public abstract class AbstractCollectionInternal<E> implements CollectionInternal<E> {

    public abstract int size();

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        Iterator<E> it = iterator();
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

    public boolean containsAll(CollectionInternal<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }
}

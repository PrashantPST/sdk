package core.util;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashSetInternal<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {

    static final long serialVersionUID = -50247444067133216L;

    private static final Object PRESENT = new Object();

    public HashSetInternal() {
        map = new HashMap<>();
    }

    private transient HashMap<E, Object> map;

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    public void clear() {
        map.clear();
    }

    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }

    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }
}

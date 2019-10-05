package core.util;

import core.io.SerializableP;
import core.lang.CloneableP;

public class HashSetP<E> extends AbstractSetP<E> implements SetP<E>, CloneableP, SerializableP {

    static final long serialVersionUID = -50247444067133216L;

    private static final Object PRESENT = new Object();

    public HashSetP() {
        map = new HashMapP<>();
    }

    private transient HashMapP<E, Object> map;

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public IteratorP<E> iterator() {
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

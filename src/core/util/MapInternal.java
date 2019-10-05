package core.util;

public interface MapInternal<K, V> {

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    void clear();

    SetInternal<K> keySet();

    interface Entry<K,V> {

        K getKey();

        V getValue();

        V setValue(V value);

        boolean equals(Object o);

        int hashCode();


    }

    boolean equals(Object o);

    int hashCode();



}

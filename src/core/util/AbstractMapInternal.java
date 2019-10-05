package core.util;

public abstract class AbstractMapInternal<K,V> implements MapInternal<K,V> {

    public abstract SetInternal<MapInternal.Entry<K,V>> entrySet();

}

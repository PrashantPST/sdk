package core.util;

public abstract class AbstractMapP<K,V> implements MapP<K,V> {

    public abstract SetP<MapP.Entry<K,V>> entrySet();

}

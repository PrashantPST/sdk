package core.util;

import core.io.SerializableP;
import core.lang.CloneableP;

public class HashMapP<K, V> extends AbstractMapP<K, V> implements MapP<K, V>, CloneableP, SerializableP {

    private static final long serialVersionUID = 362498820763185L;

    transient int size;




}

package ru.job4j.gc.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract  class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        if (value == null || value.equals("")) {
            System.out.println("Отсутвтвует значение!");
        } else {
            cache.put(key, new SoftReference<>(value));
        }
    }

    public V get(K key) {
        V result = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (result == null) {
            result = load(key);
            put(key, result);
        }
        return result;
    }

    public Map<K, SoftReference<V>> getCache() {
        return cache;
    }

    protected abstract V load(K key);
}

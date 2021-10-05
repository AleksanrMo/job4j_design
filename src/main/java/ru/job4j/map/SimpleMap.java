package ru.job4j.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public void forEach(Consumer<? super K> action) {
        Map.super.forEach(action);
    }

    private int hash(K key) {
        int h = key.hashCode();
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    private int getIndex(int h) {
        return h & table.length - 1;
    }

    @Override
    public boolean put(K key, V value) {

        if (count == LOAD_FACTOR * capacity) {
            table = Arrays.copyOf(table, table.length * 2);
        }
        if (table[getIndex(hash(key))] == null) {
            table[getIndex(hash(key))] = new MapEntry<>(key, value);
            modCount++;
            count++;

            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        if (table[getIndex(hash(key))] != null && table[getIndex(hash(key))].getKey().equals(key)) {
            return table[getIndex(hash(key))].getValue();
        }
       return null;
    }

    @Override
    public boolean remove(K key) {
        if (table[getIndex(hash(key))] != null) {
            table[getIndex(hash(key))] = null;
            modCount++;
            count--;
            return true;
        }

        return false;
    }

    @Override
    public Iterator<K> iterator() {

        return new Iterator<K>() {

            private final int expectedModCount = modCount;
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter <= count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                while (table[counter] == null) {
                    counter++;
                }
                 return table[counter++].getKey();
            }
        };

    }



    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

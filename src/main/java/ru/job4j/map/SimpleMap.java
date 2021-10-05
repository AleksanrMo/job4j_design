package ru.job4j.map;

import java.util.*;
import java.util.function.Consumer;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    private int hash(K key) {
        int h = key.hashCode();
        return (key == null) ? 0 : h ^ (h >>> 16);
    }

    private int getIndex(int h) {
        return h & capacity - 1;
    }

    @Override
    public boolean put(K key, V value) {
        int index = getIndex(hash(key));
        if (count >= LOAD_FACTOR * capacity) {
            resize();
        }
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            modCount++;
            count++;

            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = getIndex(hash(key));
        if (table[index] != null && table[index].getKey().equals(key)) {
            return table[getIndex(hash(key))].getValue();
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = getIndex(hash(key));
        if (table[index] != null && table[index].getKey().equals(key)) {
            table[index] = null;
            modCount++;
            count--;
            return true;
        }

        return false;
    }

    private void resize() {
        capacity = capacity * 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (MapEntry<K, V> element : table) {
            if (element != null) {
                newTable[getIndex(hash(element.getKey()))] = element;
            }
        }
        table = newTable;
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
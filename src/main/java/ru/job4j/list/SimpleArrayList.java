package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements Iterable<T>, List<T> {

    private T[] container;

    private int size;

    private int modCount = 0;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        modCount++;
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size] = value;
        size++;

    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
       T temp = container[index];
        container[index] = newValue;
        return temp;
    }

    @Override
    public T remove(int index) {
        modCount++;
        Objects.checkIndex(index, size);
        T temp = container[index];
        System.arraycopy(container, index + 1, container,
                index, container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        return temp;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
         return  container[index];
    }

    @Override
    public int size() {
        return size;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final int expectedModCount = modCount;
            private int count = 0;

            @Override
            public boolean hasNext() {
                 return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                return container[count++];
            }

        };
    }
}

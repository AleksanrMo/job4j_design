package ru.job4j.collection.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private int size;
    private Node first;
    private Node last;
    private int modCount = 0;

    private static class Node<E> {
        E item;
        Node next;
        Node prev;

        public Node(E element) {
            this.item = element;
        }
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    @Override
    public void add(E value) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> node = first;
        int i = 0;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node.item;
    }

    @Override
    public Iterator<E> iterator() {
          return new Iterator<E>() {
            private final int expectedModCount = modCount;
            private int count = 0;
            Node<E> lastReturned;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }

                if (lastReturned == null) {
                    lastReturned = first;
                } else {
                    lastReturned = lastReturned.next;
                }
                count++;
                return lastReturned.item;
            }

        };
    }
}

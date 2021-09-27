package ru.job4j.collection.list;

public class SimpleQueue<T> {

    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        out.push(in.pop());
        return out.pop();
    }

    public void push(T value) {
        in.pushLast(value);

    }
}

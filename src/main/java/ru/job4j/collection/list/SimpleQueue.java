package ru.job4j.collection.list;

public class SimpleQueue<T> {

    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int inSize = 0;
    private int outSize = 0;


    public T poll() {
        int temp = inSize;
        if (outSize == 0) {
            for (int i = 0; i < inSize; i++) {
                out.push(in.pop());
                temp--;
                outSize++;
            }
        }
        inSize = temp;
        outSize--;
        return out.pop();

    }

    public void push(T value) {
        in.push(value);
        inSize++;

    }

    public static void main(String[] args) {
        SimpleQueue<Integer> i = new SimpleQueue<>();
        SimpleQueue<Integer> j =  new SimpleQueue<>();
        i.push(1);
        i.push(2);
        i.push(3);
        System.out.println(i);
    }
}

package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MatrixIt implements Iterator<Integer> {

    private int point = 0;
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
    while (point < data.length) {
        if (data[row].length != 0 && column < data[row].length) {
            return true;
        }
        column = 0;
        row++;
        point++;
    }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

    public static void main(String[] args) {
        int[][] in = {
                {}, {}
        };
        MatrixIt test = new MatrixIt(in);
        test.next();
    }
}

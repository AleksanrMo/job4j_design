package ru.job4j.io;

import java.io.FileOutputStream;

public class MultiplyTable {
    public static void main(String[] args) {
        try (FileOutputStream stream = new FileOutputStream("test.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    stream.write(Integer.toString(i).getBytes());
                    stream.write(" * ".getBytes());
                    stream.write(Integer.toString(j).getBytes());
                    stream.write(" = ".getBytes());
                    stream.write(Integer.toString(j * i).getBytes());
                    stream.write(System.lineSeparator().getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

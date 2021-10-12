package ru.job4j.io;

import java.io.FileOutputStream;

public class MultiplyTable {

    public static void main(String[] args) {
            try (FileOutputStream stream = new FileOutputStream("test.txt")) {
                StringBuilder str = new StringBuilder();
                for (int i = 1; i < 10; i++) {
                    for (int j = 1; j < 10; j++) {
                        str.append(i).append(" * ").append(j).append(" = ").append(i * j).append(" \n");
                    }
                }
                stream.write(str.toString().getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

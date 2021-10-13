package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        try (FileInputStream stream = new FileInputStream("even.txt")) {
            int i;
            while ((i = stream.read()) != -1) {
              str.append((char) i);
            }
            String[] lines = str.toString().split(System.lineSeparator());
            for (String l: lines) {
               int in = Integer.parseInt(l);
               System.out.println(in % 2 == 0);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

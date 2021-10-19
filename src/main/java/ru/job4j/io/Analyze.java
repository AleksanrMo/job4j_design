package ru.job4j.io;

import org.checkerframework.checker.units.qual.A;

import javax.annotation.processing.FilerException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Analyze {

    public void unavailable(String source, String target) {

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            int count = 0;
            while (reader.ready()) {
                String[] str = reader.readLine().split(" ");
                if (count == 0 && (str[0].equals("500") || str[0].equals("400"))) {
                    out.write(str[1] + ";");
                    count++;
                } else if (count == 1 && (str[0].equals("200") || str[0].equals("300"))) {
                    out.write(str[1] + System.lineSeparator());
                    count = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Analyze analyze = new Analyze();
        analyze.unavailable("./data/sourse.csv", "./data/target.csv");
    }
}

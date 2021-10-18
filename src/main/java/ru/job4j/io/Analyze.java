package ru.job4j.io;

import org.checkerframework.checker.units.qual.A;

import javax.annotation.processing.FilerException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Analyze {

    public void unavailable(String source, String target) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
             List<String> listFirst = new ArrayList<>();
             StringBuilder listSec = new StringBuilder();
             reader.lines().forEach(listFirst::add);
             for (String s: listFirst) {
                 String[] str = s.split(" ");
                    if (count == 0 && (str[0].equals("500") || str[0].equals("400"))) {
                             listSec.append(str[1]).append(";");
                             count++;
                    } else if (count == 1 && (str[0].equals("200") || str[0].equals("300"))) {
                         listSec.append(str[1]).append(System.lineSeparator());
                         count = 0;
                         }
             }
             out.write(listSec.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analyze analyze = new Analyze();
        analyze.unavailable("./data/sourse.csv", "./data/target.csv");
    }
}

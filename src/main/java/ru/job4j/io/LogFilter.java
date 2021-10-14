package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogFilter {

    public static List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines().forEach(el -> {
                String[] strArray = el.split(" ");
                if (strArray[strArray.length - 2].equals("404")) {
                       list.add(el);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void save(List<String> log, String file) {

        try (PrintWriter print = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            log.forEach(e -> print.write(e + "\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
        log.forEach(System.out::println);
    }
}

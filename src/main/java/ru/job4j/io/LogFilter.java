package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {

    public static List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines().forEach(el -> {
                String[] strArray = el.split(" ");
                for (String str: strArray) {
                    if (str.equals("404")) {
                        list.add(el);
                    }
                } });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);

    }
}

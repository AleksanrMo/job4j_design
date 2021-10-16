package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {

        try (BufferedReader read =  new BufferedReader(new FileReader(this.path))) {
             read.lines().forEach(e -> {
                 if (!e.startsWith("#")) {
                     String[] str2 = e.split("=");
                     if (str2.length == 2 && !e.startsWith(" ") && !str2[0].equals("")) {
                         values.put(str2[0], str2[1]);
                     } else {
                          throw new IllegalArgumentException();
                     }
                 }
             });
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("!!!!");
        }

    }

    public String value(String key) {
       return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("./data/pair_without_key.properties"));
Config con = new Config("./data/pair_without_key.properties");

    }

}

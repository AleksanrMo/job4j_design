package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {

        try (BufferedReader read =  new BufferedReader(new FileReader(this.path))) {
             read.lines().forEach(e -> {
                 String[] str = e.split(" ");
                 String[] str2 = e.split("=");

                 if (!str[0].equals("#") && !e.isEmpty()) {
                     values.put(str2[0], str2[1]);
                 }
             });
        } catch (Exception e) {
            e.printStackTrace();
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Config config = (Config) o;
        return Objects.equals(path, config.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }

}

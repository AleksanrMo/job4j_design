package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader {

    private static final String PATH = "path";
    private static final String DELIMITER = "delimiter";
    private static final String OUT = "out";
    private static final String FILTER = "filter";
    private static final String STDOUT = "stdout";

    private static String[] firstLine(ArgsName args) {
        File file = new File(args.get(PATH));
        String delimiter = args.get(DELIMITER);
        String[] string = {};
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            string = read.readLine().split(delimiter);
        } catch (IOException e) {
            e.printStackTrace();
        }
            return string;
    }

    public static void handle(ArgsName args) throws Exception {
        validation(args);
        String[] strings = firstLine(args);
        File path = new File(args.get(PATH));
        String delimiter = args.get(DELIMITER);
        String out = args.get(OUT);
        String filter = args.get(FILTER);
        String[] filterArray = filter.split(",");
        Scanner scanner = new Scanner(path);
        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            for (String s : filterArray) {
                if (strings[i].equals(s)) {
                    listInt.add(i);
                }
            }
        }
        StringBuilder builder2 = new StringBuilder();
        while (scanner.hasNextLine()) {
            String[] textFromFile = scanner.nextLine().split(delimiter);
            for (int i = 0; i < listInt.size(); i++) {
                if (i == (listInt.size() - 1)) {
                    builder2.append(textFromFile[listInt.get(i)]);
                } else {
                    builder2.append(textFromFile[listInt.get(i)]).append(delimiter);
                }
            }
            builder2.append(System.lineSeparator());
        }
        if (out.equals(STDOUT)) {
            System.out.println(builder2);
        } else {
            try (PrintWriter outFile = new PrintWriter(new FileOutputStream(out))) {
                outFile.write(builder2.toString());
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
    }

    private static void validation(ArgsName args) {
        String[] parameters = {PATH, DELIMITER, OUT, FILTER};
        for (String str : parameters) {
            if (args.get(str) == null) {
                throw new IllegalArgumentException(String.format("%s value is null", str));
            }
            if (!args.getValues().containsKey(str)) {
                throw new IllegalArgumentException(String.format("%s parameter not found ", str));
            }

            if (!Files.exists(Paths.get(args.get(PATH)))) {
                throw new IllegalArgumentException("The directory does not exist!");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        handle(ArgsName.of(args));
    }
}


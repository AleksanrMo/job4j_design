package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader {

    private  final String path = "path";
    private  final String delimiter = "delimiter";
    private  final String out = "out";
    private  final String filter = "filter";
    private StringBuilder builder2 = new StringBuilder();

    private  String[] firstLine(ArgsName args) {
        File file = new File(args.get(path));
        String delimiterTemp = args.get(delimiter);
        String[] string = {};
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            string = read.readLine().split(delimiterTemp);
        } catch (IOException e) {
            e.printStackTrace();
        }
            return string;
    }

    public  void handle(ArgsName args) {
        validation(args);
        String[] strings = firstLine(args);
        File pathTemp = new File(args.get(path));
        String delimiterTemp = args.get(delimiter);
        String filterTemp = args.get(filter);
        String[] filterArray = filterTemp.split(",");
        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            for (String s : filterArray) {
                if (strings[i].equals(s)) {
                    listInt.add(i);
                }
            }
        }
        try (Scanner scanner = new Scanner(pathTemp)) {
            while (scanner.hasNextLine()) {
                String[] textFromFile = scanner.nextLine().split(delimiterTemp);
                for (int i = 0; i < listInt.size(); i++) {
                    if (i == (listInt.size() - 1)) {
                        builder2.append(textFromFile[listInt.get(i)]);
                    } else {
                        builder2.append(textFromFile[listInt.get(i)]).append(delimiterTemp);
                    }
                }
                builder2.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     writeToFile(args);

    }

    private void writeToFile(ArgsName args) {
        String outTemp = args.get(out);
        String stdout = "stdout";
        if (outTemp.equals(stdout)) {
            System.out.println(builder2);
        } else {
            try (PrintWriter outFile = new PrintWriter(new FileOutputStream(outTemp))) {
                outFile.write(builder2.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private  void validation(ArgsName args) {
        if (!args.getValues().containsKey(path) || !args.getValues().containsKey(delimiter)
                || !args.getValues().containsKey(out) || !args.getValues().containsKey(filter)) {
            throw new IllegalArgumentException();
        }
        String[] parameters = {path, delimiter, out, filter};
        for (String str : parameters) {
            if (args.get(str) == null) {
                throw new IllegalArgumentException(String.format("%s value is null", str));
            }
            if (!args.getValues().containsKey(str)) {
                throw new IllegalArgumentException(String.format("%s parameter not found ", str));
            }

            if (!Files.exists(Paths.get(args.get(path)))) {
                throw new IllegalArgumentException("The directory does not exist!");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CsvReader reader = new CsvReader();
        reader.handle(ArgsName.of(args));
    }
}


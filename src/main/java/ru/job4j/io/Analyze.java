package ru.job4j.io;

import java.io.*;


public class Analyze {

    public void unavailable(String source, String target) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            int count = 0;
            while (reader.ready()) {
                String[] str = reader.readLine().split(" ");
                if (count == 0 && (str[0].equals("500") || str[0].equals("400"))) {
                    builder.append(str[1]).append(";");
                    count++;
                } else if (count == 1 && (str[0].equals("200") || str[0].equals("300"))) {
                    builder.append(str[1]).append(System.lineSeparator());
                    count = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.write(builder.toString());
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

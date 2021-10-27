package ru.job4j.io;

import org.checkerframework.checker.units.qual.A;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> list = new ArrayList<>();
        String temp = CONTINUE;
       System.out.println("\n Программа \"Оракул\". Введи вопрос который тебя интересует о своем будущем"
               + " \n и получишь ответ. Чтобы выйти введи \"закончит\", если хочешь остаться в программе"
               +  " \n но но не получить ответов - ввседи \"стоп\"");
        while (!temp.equals(OUT)) {
            Scanner scan = new Scanner(System.in);
            String text = scan.nextLine();
            list.add(text);
            if (text.equals(OUT)) {
                temp = OUT;
              saveLog(list);
            }
            if (text.equals(STOP)) {
                temp = STOP;
            }
            if (text.equals(CONTINUE)) {
                temp = CONTINUE;
                continue;
            }
            if (temp.equals(CONTINUE)) {
                List<String> str = readPhrases();
                Random r = new Random();
                String rsl = str.get(r.nextInt(str.size()));
                list.add(rsl);
                System.out.println(rsl);
            }
        }
    }

    private List<String> readPhrases() {
      List<String> list =  new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
             read.lines().forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
            return list;
    }

    private void saveLog(List<String> log) {
        StringBuilder builder = new StringBuilder();
        log.forEach(e -> builder.append(e).append(System.lineSeparator()));
        try (PrintWriter pw = new PrintWriter(new FileWriter(botAnswers, true))) {
          pw.println(builder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("C:\\projects\\job4j_design\\data\\oracle.txt",
                "C:\\projects\\job4j_design\\data\\saveLog.txt");
        cc.run();
    }
}

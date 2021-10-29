package ru.job4j.io;

import java.io.*;
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
    private final List<String> phrases;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        phrases = readPhrases();
    }

    public List<String> readPhrases() {
      List<String> list = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            read.lines().forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
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
                Random r = new Random();
                String rsl = phrases.get(r.nextInt(phrases.size()));
                list.add(rsl);
                System.out.println(rsl);
            }
        }
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
        ConsoleChat cc = new ConsoleChat("./data/oracle.txt",
                "./data/saveLog.txt");
        cc.run();
    }
}

package ru.job4j.io;

import java.io.File;
import java.nio.file.Path;

public class Dir {

    public static void main(String[] args)  {

        File file = new File("c:\\projects");

        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exists %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }

        System.out.printf("size : %s%n", file.getTotalSpace());
        for (File subfile : file.listFiles()) {
            System.out.println(subfile.getName() + " " + subfile.length());
        }
    }
    }



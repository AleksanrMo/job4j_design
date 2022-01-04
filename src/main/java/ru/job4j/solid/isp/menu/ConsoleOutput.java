package ru.job4j.solid.isp.menu;

public class ConsoleOutput implements Output {

    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}

package ru.job4j.solid.srp;

import org.checkerframework.checker.units.qual.C;

/**
 * Нарушение принципов SRP методы измениеия и печати  в одном классе.
 * Также создание объктов выести в отдельные классы
 * Лучшим решением будет разделить на разные классы
 */
public class ChangeAndWrite {

    private String text;

    public ChangeAndWrite(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String changeText(String string) {
        text = string + " " + getText();
        return text;
    }

    public void printText(String string) {
        System.out.println(string + " " + text);
    }

}

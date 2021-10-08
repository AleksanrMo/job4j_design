package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class User {


    private String name;
    private int children;
    private Calendar calendar;

    public User(String name, int children, Calendar calendar) {
        this.name = name;
        this.children = children;
        this.calendar = calendar;

    }

    @Override
    public String toString() {
        return "User{"
                + "children="
                + children
                + ", name='"
                + name + '\''
                + ", calendar="
                + calendar.getTime()
                +
                '}';
    }

}

package ru.job4j.serialization.xml;

import java.util.Arrays;

public class School {

    private final boolean eSchool;
    private final int studentsNumber;
    private final String nameOfSchool;
    private final String[] discipline;

    public School(boolean eSchool, int studentsNumber, String nameOfSchool, String... discipline) {
        this.eSchool = eSchool;
        this.studentsNumber = studentsNumber;
        this.nameOfSchool = nameOfSchool;
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "School{"
                +
                "eSchool=" + eSchool
                +
                ", studentsNumber=" + studentsNumber
                +
                ", nameOfSchool='" + nameOfSchool + '\''
                +
                ", discipline=" + Arrays.toString(discipline)
                +
                '}';
    }

    public static void main(String[] args) {
        School school = new School(false, 2560, "Good School",
                "math", "geometry", "computer since");
    }
}

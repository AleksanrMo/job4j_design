package ru.job4j.serialization.xml;

import java.util.Arrays;

public class School {

    private final boolean eSchool;
    private final int studentsNumber;
    private final String nameOfSchool;
    private final String[] discipline;
    private final Student student;

    public School(boolean eSchool, int studentsNumber, String nameOfSchool, Student student,
                  String... discipline) {
        this.eSchool = eSchool;
        this.studentsNumber = studentsNumber;
        this.nameOfSchool = nameOfSchool;
        this.discipline = discipline;
        this.student = student;
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
                new Student("Anton", "Antonov", 15), "geometry", "computer since");
    }
}

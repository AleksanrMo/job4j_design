package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

@XmlAttribute
    private String name;
    private String lastName;
    private int age;

    public Student() {

    }

    public Student(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{"
                +
                "name='" + name + '\''
                +
                ", lastName='" + lastName + '\''
                +
                ", age=" + age
                +
                '}';

    }
}

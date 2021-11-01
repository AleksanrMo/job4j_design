package ru.job4j.serialization.xml;

import java.util.Arrays;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "school")
@XmlAccessorType(XmlAccessType.FIELD)
public class School {

    @XmlAttribute
    private  boolean eSchool;
    private  int studentsNumber;
    private  String nameOfSchool;
    @XmlElementWrapper(name = "disciplines")
    @XmlElement(name = "discipline")
    private  String[] discipline;
    private  Student student;

    public School() {

    }

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
                ", student=" + student
                +
                '}';
    }

    public static void main(String[] args) {
        School school = new School(false, 2560, "Good School",
                new Student("Anton", "Antonov", 15), "geometry", "computer since");
    }
}

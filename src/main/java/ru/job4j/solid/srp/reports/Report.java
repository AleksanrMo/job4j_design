package ru.job4j.solid.srp.reports;

import ru.job4j.solid.srp.ChangeAndWrite;

import java.util.function.Predicate;

public interface Report {

    String generate(Predicate<Employee> filter);
}

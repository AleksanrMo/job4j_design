package ru.job4j.solid.srp.reports;

import ru.job4j.solid.srp.ChangeAndWrite;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    List<Employee> findBy(Predicate<Employee> filter);
}

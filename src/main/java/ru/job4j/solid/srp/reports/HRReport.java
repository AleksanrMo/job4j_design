package ru.job4j.solid.srp.reports;

import ru.job4j.solid.srp.ChangeAndWrite;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HRReport implements Report, ChangeList {

    private Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee worker : changeList(store.findBy(filter))) {
            text.append(System.lineSeparator())
                    .append(worker.getName()).append(";")
                    .append(worker.getSalary()).append(";");

        }
        return text.toString();

    }
    @Override
    public List<Employee> changeList(List<Employee> list) {
        return  list.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());

    }
    }




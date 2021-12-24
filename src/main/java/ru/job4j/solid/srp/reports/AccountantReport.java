package ru.job4j.solid.srp.reports;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class AccountantReport implements Report, ChangeList {

    private Store store;

    public AccountantReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : changeList(store.findBy(filter))) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append("$").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    @Override
    public List<Employee> changeList(List<Employee> list) {
        return list.stream()
                .map(e -> new Employee(e.getName(), e.getHired(),
                        e.getFired(), e.getSalary() / 75))
                .collect(Collectors.toList());
    }
}

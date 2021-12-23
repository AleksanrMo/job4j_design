package ru.job4j.solid.srp.reports;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


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
        List<Employee> listTemp = new ArrayList<>();
        for (Employee employee: list) {
           listTemp.add(new Employee(employee.getName(), employee.getHired(),
                    employee.getFired(), employee.getSalary() / 75));
        }
        return listTemp;

    }
}

package ru.job4j.solid.srp.reports;



import java.util.function.Predicate;

public class HtmlReport implements Report {

    private Store store;

    public HtmlReport(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!doctype html>" + System.lineSeparator()
                + "<html lang=\"ru\">" + System.lineSeparator()
                + "<head>" + System.lineSeparator()
                + "<meta charset=\"utf-8\"/>" + System.lineSeparator()
                + "<title>\"Отчет для програмистов\"</title>" + System.lineSeparator()
                + "<link rel=\"stylesheet\" href=\"style.css\"/>" + System.lineSeparator()
                + "</head>" + System.lineSeparator()
                + "<body>" + System.lineSeparator())
                .append("Name; Hired; Fired; Salary;");
        for (Employee worker : store.findBy(filter)) {
                  text
                    .append(worker.getName()).append(";")
                    .append(worker.getHired()).append(";")
                    .append(worker.getFired()).append(";")
                    .append(worker.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
         text.append("</body> " + System.lineSeparator()
                + "</html>");
        return text.toString();

    }
}

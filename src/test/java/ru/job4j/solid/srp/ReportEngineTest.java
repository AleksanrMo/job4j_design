package ru.job4j.solid.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import ru.job4j.solid.srp.reports.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHtmlGenerated()  {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new HtmlReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<!doctype html>" + System.lineSeparator()
                        + "<html lang=\"ru\">" + System.lineSeparator()
                        + "<head>" + System.lineSeparator()
                        + "<meta charset=\"utf-8\"/>" + System.lineSeparator()
                        + "<title>\"Отчет для програмистов\"</title>" + System.lineSeparator()
                        + "<link rel=\"stylesheet\" href=\"style.css\"/>" + System.lineSeparator()
                        + "</head>" + System.lineSeparator()
                        + "<body>" + System.lineSeparator())
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("</body> " + System.lineSeparator()
                        + "</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHRGenerated()  {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Andrey", now, now, 120);
        store.add(worker);
        store.add(worker2);
        Report engine = new HRReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenAccountantReport()  {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new AccountantReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() / 75).append("$").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenXMLReport()  {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new XMLReport(store);
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        StringBuilder string = new StringBuilder()

        .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employees>\n")
                .append("    <employee>\n")
                .append("        <fired>").append(format.format(worker.getHired().getTime())).append("</fired>\n")
                .append("        <hired>").append(format.format(worker.getHired().getTime())).append("</hired>\n")
                .append("        <name>Ivan</name>\n")
                .append("        <salary>100.0</salary>\n")
                .append("    </employee>\n")
                .append("</employees>\n");

        assertThat(engine.generate(em -> true), is(string.toString()));
    }

    @Test
    public void whenJSONReport()  {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new JSONReport(store);
        String str = "[{\"name\":\"Ivan\",\"hired\":{\"year\":" + worker.getHired().get(Calendar.YEAR) + ",\"month\":"
                + worker.getHired().get(Calendar.MONTH) + "," + "\"dayOfMonth\":"
                + worker.getHired().get(Calendar.DAY_OF_MONTH) + ",\"hourOfDay\":"
                + worker.getHired().get(Calendar.HOUR_OF_DAY) + ",\"minute\":"
                + worker.getHired().get(Calendar.MINUTE) + ",\"second\":"
                + worker.getHired().get(Calendar.SECOND) + "},\"fired\"" + ":{\"year\":"
                + worker.getHired().get(Calendar.YEAR) + ",\"month\":"
                + worker.getHired().get(Calendar.MONTH) + ",\"dayOfMonth\":"
                + worker.getHired().get(Calendar.DAY_OF_MONTH) + ",\"hourOfDay\":"
                + worker.getHired().get(Calendar.HOUR_OF_DAY) + ",\"minute\":"
                + worker.getHired().get(Calendar.MINUTE) + ",\"second\":"
                + worker.getHired().get(Calendar.SECOND) + "},\"salary\":100.0}]";

        assertThat(engine.generate(em -> true), is(str));
    }

}
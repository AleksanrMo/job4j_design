package ru.job4j.solid.isp.menu;

import java.util.ArrayList;
import java.util.List;

public class Task implements Show {
    Output output;
    List<Show> task;
    private String name;

    public Task(String name) {
        this.name = name;
        task = new ArrayList<>();
        output = new ConsoleOutput();
    }

    public void add(Show taski) {
        task.add(taski);
    }

    public void show(Output output) {
        output.println(name);
        for (Show t: task) {
             t.show(output);
            }
        }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Task{"
                +

                "task=" + task
                +
                ", name='" + name + '\''
                +
                '}';
    }
}

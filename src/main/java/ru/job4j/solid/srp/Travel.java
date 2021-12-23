package ru.job4j.solid.srp;

/**
 * Методы этого класса имеют разню ответственность.
 */

public class Travel implements MoveAndDoSomeThing {

    @Override
    public void move(String transport) {
        System.out.println("Я еду на ".concat(transport));
    }

    @Override
    public String calculateTimeOfRest(double timeOfMove) {
        return  String.valueOf(timeOfMove / 2);
    }
}

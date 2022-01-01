package ru.job4j.solid.dip.disorder;

/**
 * Класс BuildCar зависит от Engine на прямую, то есть жесткая зависимость когда класс верхнего уровня
 * зависит от деталей. Если завтра понадобится какой-то другой двигатель, то тогда возникнут проблемы с заменой кодом,
 * надо будет что-то где-то менять, подправлять так называемый "хард код" у нас получился.
 * Решение создать интерфейс для двигателя и от него наследоваться, также cоздать интерфейс
 * BuildCar от которого наследовать конкретную машину.
 *
 */

public class BuildCar {

    public boolean setEngine(Engine engine) {
       return engine.getSize() == 10;
    }


}
 class Engine {

    private int size;

    public Engine(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
 }
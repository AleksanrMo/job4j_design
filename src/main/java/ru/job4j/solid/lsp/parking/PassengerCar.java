package ru.job4j.solid.lsp.parking;

public class PassengerCar implements Cars {

    private int size;

    public PassengerCar() {
        size = 1;
    }
    @Override
    public int sizeOfCar() {
        return 0;
    }
}

package ru.job4j.solid.lsp.parking;

public class Truck implements Cars {

    private int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int sizeOfCar() {
        return 0;
    }
}

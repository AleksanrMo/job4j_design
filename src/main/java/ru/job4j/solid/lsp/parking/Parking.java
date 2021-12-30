package ru.job4j.solid.lsp.parking;

public class Parking implements ParkingLot {

    @Override
    public boolean acceptCar(Cars car) {
        return false;
    }
}

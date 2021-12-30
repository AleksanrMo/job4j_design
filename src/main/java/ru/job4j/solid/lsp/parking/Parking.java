package ru.job4j.solid.lsp.parking;

public class Parking implements ParkingLot {

    private int freePlaces;

    public Parking(int freePlaces) {
        this.freePlaces =  freePlaces;
    }


    @Override
    public boolean acceptCar(Cars car) {
        return false;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

}

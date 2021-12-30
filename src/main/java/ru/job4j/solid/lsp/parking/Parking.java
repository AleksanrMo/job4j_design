package ru.job4j.solid.lsp.parking;

public class Parking implements ParkingLot {

    private final Cars[] trackPlaces;
    private final Cars[] carPlaces;
    private int passenger;
    private int track;


    public Parking(int passenger, int track) {
        this.passenger = passenger;
        this.track = track;
        carPlaces = new Cars[passenger];
        trackPlaces = new Truck[track];
    }

    @Override
    public boolean acceptCar(Cars car) {
        return false;
    }

    public Cars[] getTruckPlaces() {
        return trackPlaces.clone();

    }

    public Cars[] getCarPlaces() {
        return carPlaces.clone();
    }

}

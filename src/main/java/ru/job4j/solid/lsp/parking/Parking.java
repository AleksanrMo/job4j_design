package ru.job4j.solid.lsp.parking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        return Arrays.copyOf(trackPlaces, trackPlaces.length);

    }

    public Cars[] getCarPlaces() {
        return Arrays.copyOf(carPlaces, trackPlaces.length);
    }


}

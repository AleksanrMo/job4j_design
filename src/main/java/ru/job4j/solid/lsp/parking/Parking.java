package ru.job4j.solid.lsp.parking;

import java.util.Arrays;

public class Parking implements ParkingLot {

    private final Cars[] truckPlaces;
    private final Cars[] carPlaces;
    private int passenger;
    private int truck;


    public Parking(int passenger, int truck) {
        this.passenger = passenger;
        this.truck = truck;
        carPlaces = new Cars[passenger];
        truckPlaces = new Truck[truck];
    }

    @Override
    public boolean acceptCar(Cars car) {
        boolean rst = false;
        if (car.size() == 1 && passenger > 0) {
            carPlaces[carPlaces.length  - passenger] = car;
            passenger--;
            rst = true;
        } else if (car.size() > 1 && truck > 0) {
            truckPlaces[truckPlaces.length - truck] = car;
            truck--;
            rst = true;
        } else if (car.size() > 1 && truck == 0 && passenger >= car.size()) {
            for (int i = 0; i < car.size(); i++) {
                carPlaces[carPlaces.length - passenger] = car;
                passenger--;
            }
            rst = true;
        }
        return rst;
    }

    public Cars[] getTruckPlaces() {
        return Arrays.copyOf(truckPlaces, truckPlaces.length);

    }

    public Cars[] getCarPlaces() {
        return Arrays.copyOf(carPlaces, carPlaces.length);
    }
}
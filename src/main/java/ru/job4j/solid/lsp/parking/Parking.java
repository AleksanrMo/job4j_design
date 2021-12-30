package ru.job4j.solid.lsp.parking;

public class Parking implements ParkingLot {

    private Cars[] passengerCarPlaces;
    private Cars[] truckPlaces;

    public Parking(Cars[] passengerCarPlaces, Cars[] truckPlaces) {
        this.passengerCarPlaces = passengerCarPlaces;
        this.truckPlaces = truckPlaces;
    }

    @Override
    public boolean acceptCar(Cars car) {
        return false;
    }

    public Cars[] getPassengerCarPlaces() {
        return passengerCarPlaces;
    }

    public void setPassengerCarPlaces(Cars[] passengerCarPlaces) {
        this.passengerCarPlaces = passengerCarPlaces;
    }

    public Cars[] getTruckPlaces() {
        return truckPlaces;
    }

    public void setTruckPlaces(Cars[] truckPlaces) {
        this.truckPlaces = truckPlaces;
    }
}

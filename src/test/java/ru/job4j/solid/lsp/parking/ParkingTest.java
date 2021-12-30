package ru.job4j.solid.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

@Ignore
public class ParkingTest {

    @Test

    public void whenAddPassengerCars() {

        Cars passengerCar = new PassengerCar();
        Parking parking = new Parking(new Cars[10], new Cars[10]);
        parking.acceptCar(passengerCar);
        assertEquals(parking.getPassengerCarPlaces()[0], passengerCar);
    }

    @Test
    public void whenAddTruck() {

        Cars truck = new Truck(2);
        Parking parking = new Parking(new Cars[10], new Cars[10]);
        parking.acceptCar(truck);
        assertEquals(parking.getTruckPlaces()[0], truck);
        assertEquals(parking.getTruckPlaces()[1], truck);
    }

    @Test
    public void whenAddTruckAndPassengerCar() {

        Cars truck = new Truck(2);
        Cars passengerCar = new PassengerCar();
        Parking parking = new Parking(new Cars[10], new Cars[10]);
        parking.acceptCar(truck);
        parking.acceptCar(passengerCar);
        assertEquals(parking.getTruckPlaces()[0], truck);
        assertEquals(parking.getTruckPlaces()[1], truck);
        assertEquals(parking.getPassengerCarPlaces()[0], passengerCar);
    }

    @Test()
    public void whenAddTruckButOnlyOnePlaceOrZeroInTruckPlaces()  {

        Cars truck = new Truck(2);
        Parking parking = new Parking(new Cars[10], new Cars[0]);
        parking.acceptCar(truck);
        assertEquals(parking.getTruckPlaces()[0], truck);
        assertEquals(parking.getPassengerCarPlaces()[0], truck);
    }

    @Test(expected = Exception.class)
    public void whenAddParkingHaveNoPlaceForPassengerCar()  {
        Cars passengerCar = new PassengerCar();
        Cars passengerCar2 = new PassengerCar();
        Parking parking = new Parking(new Cars[0], new Cars[10]);
        parking.acceptCar(passengerCar);
        parking.acceptCar(passengerCar2);
    }

    @Test(expected = Exception.class)
    public void whenAddParkingHaveNoPlaceForTrack()  {
        Cars passengerCar = new PassengerCar();
        Cars truck = new Truck(2);
        Parking parking = new Parking(new Cars[0], new Cars[0]);
        parking.acceptCar(passengerCar);
        parking.acceptCar(truck);
    }
}
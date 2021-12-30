package ru.job4j.solid.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

@Ignore
public class ParkingTest {

    @Test

    public void whenAddPassengerCars() {

        Cars passengerCar = new PassengerCar();
        Parking parking = new Parking(20);
        parking.acceptCar(passengerCar);
        assertEquals(parking.getFreePlaces(), 19);
    }

    @Test
    public void whenAddTruck() {

        Cars truck = new Truck(2);
        Parking parking = new Parking(20);
        parking.acceptCar(truck);
        assertEquals(parking.getFreePlaces(), 18);
    }

    @Test
    public void whenAddTruckAndPassengerCar() {

        Cars truck = new Truck(2);
        Cars passengerCar = new PassengerCar();
        Parking parking = new Parking(20);
        parking.acceptCar(truck);
        parking.acceptCar(passengerCar);
        assertEquals(parking.getFreePlaces(), 17);
    }


    @Test(expected = Exception.class)
    public void whenAddTruckButOnlyOnePlaceOrZero()  {

        Cars truck = new Truck(2);
        Parking parking = new Parking(1);
        parking.acceptCar(truck);
    }

    @Test(expected = Exception.class)
    public void whenAddPassengerCarButPlaceOrZero()  {

        Cars passengerCar = new PassengerCar();
        Parking parking = new Parking(0);
        parking.acceptCar(passengerCar);
    }
}
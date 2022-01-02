package ru.job4j.solid.lsp.parking;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


public class ParkingTest {

    @Test

    public void whenAddPassengerCars() {

        Cars passengerCar = new PassengerCar();
        Parking parking = new Parking(10, 10);
        parking.acceptCar(passengerCar);
        assertThat(parking.getPassenger(), is(9));
    }

    @Test
    public void whenAddTruck() {

        Cars truck = new Truck(2);
        Parking parking = new Parking(10, 10);
        parking.acceptCar(truck);
        assertEquals(parking.getTruck(), 9);

    }

    @Test
    public void whenAddTruckAndPassengerCar() {

        Cars truck = new Truck(2);
        Cars passengerCar = new PassengerCar();
        Parking parking = new Parking(10, 10);
        parking.acceptCar(truck);
        parking.acceptCar(passengerCar);
        assertEquals(parking.getTruck(), 9);
        assertEquals(parking.getPassenger(), 9);
    }

    @Test()
    public void whenAddTruckButZeroInTruckPlaces()  {

        Cars truck = new Truck(2);
        Parking parking = new Parking(10, 0);
        parking.acceptCar(truck);
        assertEquals(parking.getPassenger(), 8);
    }

    @Test()
    public void whenAddParkingHaveNoPlaceForPassengerCar()  {
        Cars passengerCar = new PassengerCar();
        Parking parking = new Parking(0, 10);
        assertFalse(parking.acceptCar(passengerCar));

    }

    @Test()
    public void whenAddParkingHaveNoPlaceForTrack()  {
        Cars truck = new Truck(2);
        Parking parking = new Parking(1, 0);
        assertFalse(parking.acceptCar(truck));
    }
}
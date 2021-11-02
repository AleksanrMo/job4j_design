package ru.job4j.serialization;

public class Address {

    private final String street;
    private final int number;

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Address{"
                + "street='" + street + '\''
                + ", number=" + number
                + '}';
    }
}

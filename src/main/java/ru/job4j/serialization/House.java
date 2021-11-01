package ru.job4j.serialization;

import java.util.Arrays;

public class House {

    private final String[] rooms;
    private final int age;
    private final boolean habitable;
    private final Address address;

    public House(int age, boolean habitable, Address address, String... rooms) {
        this.age = age;
        this.habitable = habitable;
        this.address = address;
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "House{"
                + "rooms=" + Arrays.toString(rooms)
                + ", age=" + age
                + ", habitable=" + habitable
                + ", address=" + address
                + '}';
    }
}

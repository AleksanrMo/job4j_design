package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test {
    public static void main(String[] args) {
        House house = new House(10, true, new Address("Vasilieva",
                67), "kitchen", "room 1", "room 2");

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(house));

        final String houseJson =
                "{"
                        + "\"age\":10,"
                        + "\"habitable\":true,"
                        + "\"address\":"
                        + "{"
                        + "\"street\":"
                        + "\"Vasilieva\", \"number\":\"67\""
                        + "},"
                        + "\"rooms\":"
                        + "[\"kitchen\",\"room 1\",\"room 2\"]"
                        + "}";

        final House houseFromJson = gson.fromJson(houseJson, House.class);
        System.out.println(houseJson);
    }
}

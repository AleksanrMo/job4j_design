package ru.job4j.serialization.xml;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.serialization.Address;
import ru.job4j.serialization.House;

import java.util.List;

public class TestJSON {
    public static void main(String[] args) {
        Address address = new Address("Vasilieva",
                67);
        House house = new House(10, true, address, "kitchen", "room 1", "room 2");
        List<String> list = List.of("kitchen", "room 1", "room 2");
        JSONArray arrayJson = new JSONArray(list);
        JSONObject jsonString = new JSONObject(address);
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("age", 10);
        jsonObject.put("habitable", true);
        jsonObject.put("address", jsonString);
        jsonObject.put("rooms", arrayJson);
        System.out.println(jsonObject);

        JSONObject jsonHouse = new JSONObject(house);
        System.out.println(jsonHouse);
    }
}

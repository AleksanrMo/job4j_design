package ru.job4j.solid.lsp;

import java.util.ArrayList;
import java.util.List;


public class Shop implements Storage {

    private List<Food> list;

    public Shop() {
        list = new ArrayList<>();
    }

    @Override
    public void addFood(Food food) {
        list.add(food);
    }
    @Override
    public List<Food> getList() {
        return list;
    }
}

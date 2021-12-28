package ru.job4j.solid.lsp;

import java.util.*;

public class WareHouse implements Storage {

    private List<Food> list;

    public WareHouse() {
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

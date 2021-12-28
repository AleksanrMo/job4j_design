package ru.job4j.solid.lsp;

import java.util.*;

public class Trash implements Storage {

   private List<Food> list;

    public Trash() {
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

package ru.job4j.solid.lsp.store;

import java.util.ArrayList;
import java.util.List;

public class WareHouse implements Storage {

    private List<Food> list;

    public WareHouse() {
        list = new ArrayList<>();
    }

    @Override
    public void addFood(Food food) {
       if (accept(food)) {
           list.add(food);
       }
    }

    @Override
    public boolean accept(Food food) {
        CalculatePercentage percent = new CalculatePercentage();
        double rst =  percent.percentageOfExpiration(food);
        return rst >= 0 && rst < 25;
    }

    @Override
    public List<Food> getList() {
        return list;
    }
}

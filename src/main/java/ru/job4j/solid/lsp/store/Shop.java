package ru.job4j.solid.lsp.store;

import java.util.ArrayList;
import java.util.List;


public class Shop implements Storage {

    private List<Food> list;

    public Shop() {
        list = new ArrayList<>();
    }

    @Override
    public void addFood(Food food) {
        CalculatePercentage percent = new CalculatePercentage();
        double rst =  percent.percentageOfExpiration(food);
        if (accept(food)) {
            if (rst > 75) {
                food.setPrice(food.getPrice() - ((food.getDiscount() / 100.0) * food.getPrice()));
            }
            list.add(food);
        }

    }

    @Override
    public boolean accept(Food food) {
        CalculatePercentage percent = new CalculatePercentage();
        double rst =  percent.percentageOfExpiration(food);
        return rst >= 25 && rst < 100;
    }

    @Override
    public List<Food> getList() {
        return list;
    }
}

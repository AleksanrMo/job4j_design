package ru.job4j.lspclone.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

   private List<Food> list;

    public Trash() {
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
        return rst >= 100;
    }

    @Override
    public List<Food> getList() {
        return list;
    }
}

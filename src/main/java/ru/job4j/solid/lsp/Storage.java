package ru.job4j.solid.lsp;

import java.util.List;

public interface Storage {

    void addFood(Food food);
    List<Food> getList();
}

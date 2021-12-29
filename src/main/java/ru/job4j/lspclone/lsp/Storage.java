package ru.job4j.lspclone.lsp;

import java.util.List;

public interface Storage {

    void addFood(Food food);
    boolean accept(Food food);
    List<Food> getList();
}

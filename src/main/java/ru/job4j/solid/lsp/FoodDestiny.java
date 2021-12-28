package ru.job4j.solid.lsp;


public class FoodDestiny {

    Storage storage;

    public FoodDestiny(Storage storage) {
        this.storage = storage;
    }

    public void excStorage(Food food) {
        storage.addFood(food);
    }

}



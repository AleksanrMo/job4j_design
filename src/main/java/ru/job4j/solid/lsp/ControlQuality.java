package ru.job4j.solid.lsp;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ControlQuality {


    /**
     * Метод принимает коллекцию листов с хранилищами, проверяет продукцию по сроку хранения
     * и в зависимости от этого перераспределяет ее заново между хранилищами.
     * @param list
     */
    public void rewriteLists(List<Storage> list) {
        Storage wareHouse =  new WareHouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        FoodDestiny foodDestiny;
        CalculatePercentage calc = new CalculatePercentage();
        for (Storage storage: list) {
            for (Food food: storage.getList()) {
                double rstOfCalc = calc.percentageOfExpiration(food);
                if (rstOfCalc > 0 && rstOfCalc < 25) {
                    foodDestiny = new FoodDestiny(wareHouse);
                    foodDestiny.excStorage(food);
                } else if (rstOfCalc >= 25 && rstOfCalc <= 75) {
                    foodDestiny = new FoodDestiny(shop);
                    foodDestiny.excStorage(food);
                } else if (rstOfCalc > 75 && rstOfCalc <= 100) {
                    food.setDiscount(40);
                    foodDestiny = new FoodDestiny(shop);
                    foodDestiny.excStorage(food);
                } else if (rstOfCalc >= 100) {
                    foodDestiny = new FoodDestiny(trash);
                    foodDestiny.excStorage(food);
                }
            }
        }
        for (Storage storage: list) {
           if (storage.getClass().equals(WareHouse.class)) {
                storage.getList().clear();
                storage.getList().addAll(wareHouse.getList());
           } else if (storage.getClass().equals(Shop.class)) {
               storage.getList().clear();
               storage.getList().addAll(shop.getList());
           } else if (storage.getClass().equals(Trash.class)) {
               storage.getList().clear();
               storage.getList().addAll(trash.getList());
           }
        }
    }

    public static void main(String[] args) {

        Storage warehause = new WareHouse();
        Storage store = new Shop();
        Storage trash = new Trash();
        List<Storage> list = Arrays.asList(warehause, store, trash);
        warehause.addFood(new Food("1", LocalDate.of(2021, 12, 20),
                LocalDate.of(2021, 12, 29), 149, 40));
        warehause.addFood(new Food("1", LocalDate.of(2021, 12, 20),
                LocalDate.of(2021, 12, 27), 149, 40));
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.rewriteLists(list);
        System.out.println(trash.getList());

    }
}

package ru.job4j.solid.lsp.store;


import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

 private List<Storage> list;

 public ControlQuality(List<Storage> list) {

     this.list = list;
 }

    public void sortFood(Food food) {

     list.forEach(e -> e.addFood(food));

    }

    public void resort() {
     List<Food> temp = new ArrayList<>();
        list.forEach(s -> {
            temp.addAll(s.getList());
            s.getList().clear();
        });
        temp.forEach(this::sortFood);
    }
}

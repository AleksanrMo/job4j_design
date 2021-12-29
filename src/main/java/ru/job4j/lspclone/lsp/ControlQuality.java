package ru.job4j.lspclone.lsp;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ControlQuality {

 private List<Storage> list;

 public ControlQuality(List<Storage> list) {
     this.list = list;
 }

    public void sortFood(Food food) {
       list.forEach(e -> e.addFood(food));
    }
}

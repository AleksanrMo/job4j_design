package ru.job4j.solid.dip.disorder;

/**
 * В этом примере все сильно связанно между собой, нужно добавить абстракции.
 * Например, для класса One можно создать интерфейс и в методах, листе класса Example2
 * уже указывать интерфейс - тем самым убрать жесткую зависимость от какого то определенного
 * класса.
 * Так же хранилище, в нашем случае это List можно заменить на интерфейс который в свою очередь будут
 * реализовать другие классы, ведь возможно мы вообще в будущем захотим хранить наши объекты и в листе ,
 * и в базе данных и в файл записывать.
 *
 */

import java.util.ArrayList;
import java.util.List;

public class ListOfOne {

   List<One> list;
   ListOfOne() {
    list = new ArrayList<>();
   }

   public void add(One one) {
     list.add(one);
   }
   

   class One {

    private int one;

   }
}

package ru.job4j.solid.lsp.disorder;

import java.util.ArrayList;
import java.util.List;

/**
 * В этом примере от наследника мы ожидаем что в лис добавится один элемент, а добавляется два.  Усилили поведение
 * наследника
 * @param <T>
 */
public class RegList<T> {
    List<T> list = new ArrayList<>();

    public boolean add(T t) {
      return list.add(t);
    }

}

class Double extends RegList<Object> {
    List<Object> list = new ArrayList<>();
    @Override
    public boolean add(Object o) {
        boolean rst = false;
        if (o != null) {
            list.add(o);
            list.add(o);
            rst = true;
        }
        return rst;
    }
}

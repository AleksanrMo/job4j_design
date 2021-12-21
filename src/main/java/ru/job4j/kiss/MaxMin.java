package ru.job4j.kiss;

import java.io.File;
import java.util.*;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
       return validAndCalc(value, comparator.reversed());
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
       return validAndCalc(value, comparator);
    }

    public <T> T validAndCalc(List<T> value, Comparator<T> comparator) {
        T rst = null;
        if (!value.isEmpty()) {
            rst = value.get(0);
            for (T t: value) {
                rst = comparator.compare(rst, t) < 0 ? rst : t;
            }
        }
        return rst;
    }
}

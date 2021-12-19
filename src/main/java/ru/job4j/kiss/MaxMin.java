package ru.job4j.kiss;

import java.util.*;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        T rst = null;
        if (!value.isEmpty()) {
            value.sort(comparator);
            rst = value.get(value.size() - 1);
        }
        return rst;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T rst = null;
        if (!value.isEmpty()) {
            value.sort(comparator);
            rst = value.get(0);
        }
        return rst;
    }
}

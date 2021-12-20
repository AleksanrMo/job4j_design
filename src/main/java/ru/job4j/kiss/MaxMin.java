package ru.job4j.kiss;

import java.io.File;
import java.util.*;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
       return valid(value, comparator.reversed());
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
       return valid(value, comparator);
    }

    public <T> T valid(List<T> value, Comparator<T> comparator) {
        T rst = null;
        if (!value.isEmpty()) {
            value.sort(comparator);
            rst = value.get(0);
        }
        return rst;
    }
}

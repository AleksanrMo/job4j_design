package ru.job4j.kiss;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class MaxMinTest {

    @Test

    public void whenFindMax() {
        MaxMin max = new MaxMin();
        List<Integer> list = Arrays.asList(2, 4, 1);
        assertThat(max.max(list, Integer::compareTo), is(4));

    }

    @Test
    public void whenFindMin() {
        MaxMin min = new MaxMin();
        List<Integer> list = Arrays.asList(1, 0, 2);
        assertThat(min.min(list, Integer::compareTo), is(0));

    }

    @Test

    public void whenListIsEmpty() {
        MaxMin min = new MaxMin();
        List<Integer> list = Arrays.asList();
        assertNull(min.min(list, Integer::compareTo));
    }

}
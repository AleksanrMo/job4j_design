package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);

        assertThat(input, Is.is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);

        assertThat(input, Is.is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 10, 2);
    }


    @Test
    public void whenAddAfterInTheMeddle() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5));
        ListUtils.addAfter(input, 2, 3);

        assertThat(input, is(Arrays.asList(0, 1, 2, 3, 4, 5)));
    }

    @Test
    public void whenRemoveIfNotEvenNumbers() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 34, 89));
        ListUtils.removeIf(input, e -> e == 0 || e % 2 != 0);
        assertThat(input, is(Arrays.asList(2, 4, 34)));

    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 34, 89));
        List<Integer> elements = new ArrayList<>(Arrays.asList(2, 3, 5, 89, 9));
        ListUtils.removeAll(input, elements);
        assertThat(input, is(Arrays.asList(1, 4, 34)));
    }

    @Test
    public void whenReplaceIf() {
        List<String> input = new ArrayList<>(Arrays.asList("hello", "java", "test", "test", "words", "test"));
        ListUtils.replaceIf(input, e -> e.equals("test"), "test is passed");
        assertThat(input, is(Arrays.asList("hello", "java", "test is passed",
                "test is passed", "words", "test is passed")));
    }
}
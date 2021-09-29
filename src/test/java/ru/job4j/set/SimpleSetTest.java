package ru.job4j.set;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import java.util.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddWhatSetContains() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(2));
        assertTrue(set.add(null));
        assertTrue(set.add(6));
        assertFalse(set.contains(7));
        assertTrue(set.contains(null));
        assertTrue(set.contains((2)));
    }
}
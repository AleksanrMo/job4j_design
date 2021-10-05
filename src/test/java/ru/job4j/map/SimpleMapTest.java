package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {

    @Test
    public void whenGet2Items() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Good morning");
        map.put(5, "Good night");
        assertThat(map.get(5), is("Good night"));
        assertThat(map.get(1), is("Good morning"));
    }

    @Test
    public void whenGetIsNull() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Good morning");
        map.put(2, "Good night");
        assertNull(map.get(3));
    }

    @Test
    public void whenPutButKeySame() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Good morning");
        map.put(2, "Hello");
        assertFalse(map.put(2, "Hello"));

    }

    @Test
    public void whenPutReturnTrue() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Good morning");
        map.put(2, "Hello");
        assertTrue(map.put(3, "Hello my friend"));

    }

    @Test
    public void whenRemoveItem() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Good morning");
        map.put(2, "Good night");
        map.remove(2);
        assertThat(map.get(1), is("Good morning"));
        assertNull(map.get(2));
    }

    @Test
    public void whenRemoveItem2() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Good morning");
        map.put(2, "Good night");
        map.remove(2);
        map.remove(1);
        assertNull(map.get(1));
        assertNull(map.get(2));
    }

    @Test
    public void whenIteratorTest() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Good morning");
        map.put(2, "Good night");
        map.put(3, "Hello");
        Iterator<Integer> iter = map.iterator();
        assertThat(iter.next(), is(1));
        assertThat(iter.next(), is(2));
        assertThat(iter.next(), is(3));


    }
    @Test (expected = NoSuchElementException.class)
    public void whenIteratorTest2() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "Good morning");
        map.put(2, "Good night");
        map.put(3, "Hello");
        Iterator<Integer> iter = map.iterator();
        assertThat(iter.next(), is(1));
        assertThat(iter.next(), is(2));
        assertThat(iter.next(), is(3));
        assertNull(iter.next());

    }

    @Test
    public void whenTableExpend() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(0, "Good morning");
        map.put(2, "Good night");
        map.put(3, "Hello");
        map.put(4, "Good morning");
        map.put(5, "Good night");
        map.put(7, "Hello");
        map.put(8, "Good morning");
        map.put(9, "Good night");
        map.put(10, "Hello");
        map.put(11, "Good morning");
        map.put(12, "Good night");
        map.put(17, "error");

        assertThat(map.get(12), is("Good night"));

    }
}
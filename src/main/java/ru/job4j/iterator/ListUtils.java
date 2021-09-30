package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator(index);
            i.add(value);
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator(index + 1);
                i.add(value);
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.remove();
            }
        }

    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.set(value);

            }
        }

    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = list.listIterator();
       while (i.hasNext()) {
           if (elements.contains(i.next())) {
               i.remove();
           }
       }
    }

    public static void main(String[] args) {
        Set<String> strings = Set.of("one", "two", "three");
        Iterator<String> str = strings.iterator();
        Map<String, Integer> in = new HashMap<>();
        in.put("s", 1);
        while (str.hasNext()) {
            System.out.println(str.next());
        }
    }
}
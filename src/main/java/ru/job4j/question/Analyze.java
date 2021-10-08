package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        int add = 0;
        int change = 0;
        int del = 0;
        Map<Integer, String> map = new HashMap<>();
        for (User user: previous) {
            map.put(user.getId(), user.getName());
        }
        return null;

    }
}

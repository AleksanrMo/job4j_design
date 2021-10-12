package ru.job4j.question;

import net.sf.saxon.serialize.BinaryTextDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info rsl = new Info(0, 0, 0);
        int count = 0;
        Map<Integer, String> mapPrevious = new HashMap<>();
            for (User user: previous) {
                mapPrevious.put(user.getId(), user.getName());
        }
            for (User user: current) {
                if (!mapPrevious.containsKey(user.getId())) {
                    rsl.setAdded(1);
                } else if (!mapPrevious.get(user.getId()).equals(user.getName())) {
                    rsl.setChanged(1);
                    }
                if (mapPrevious.containsKey(user.getId())) {
                    count++;
                    if (mapPrevious.size() > count) {
                    rsl.setDeleted(1);
                    } else {
                        rsl.setDeleted(0);
                }
            }
        }
       return rsl;
    }
}

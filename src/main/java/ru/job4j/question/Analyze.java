package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info rsl = new Info(0, 0, 0);
        Map<Integer, String> mapPrevious = new HashMap<>();
            for (User user: previous) {
                mapPrevious.put(user.getId(), user.getName());
        }
            for (User user: current) {
                if (!mapPrevious.containsKey(user.getId())) {
                    rsl.setAdded(rsl.getAdded() + 1);
                } else if (!mapPrevious.get(user.getId()).equals(user.getName())) {
                    rsl.setChanged(rsl.getChanged() + 1);
                    }
            }
            rsl.setDeleted(rsl.getAdded() + previous.size() - current.size());

       return rsl;
    }
}

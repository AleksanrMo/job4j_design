package ru.job4j.io.duplicates;

import ru.job4j.serialization.json.A;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    Map<FileProperty, List<Path>> map = new HashMap<>();


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
       long size = file.toFile().length();
       String name = file.getFileName().toString();
       FileProperty property = new FileProperty(size, name);
        if (map.containsKey(property)) {
            map.get(property).add(file);
       } else {
            map.put(property, new ArrayList<>());
            map.get(property).add(file);
        }

        return super.visitFile(file, attrs);
    }

    public List<Path> getDuplicates() {
        List<Path> list = new ArrayList<>();
        for (Map.Entry<FileProperty, List<Path>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                list.addAll(entry.getValue());
            }
        }
        return list;
    }
}

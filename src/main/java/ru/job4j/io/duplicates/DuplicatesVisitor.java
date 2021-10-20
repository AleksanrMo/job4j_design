package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Set<FileProperty> properties = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
       long size = file.toFile().length();
       String name = file.getFileName().toString();
        if (!properties.add(new FileProperty(size, name))) {
            System.out.println("Это дубликат " +  file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}

package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visit = new DuplicatesVisitor();
        visit.duplicatesFinder(Path.of("./"), visit);
    }
}
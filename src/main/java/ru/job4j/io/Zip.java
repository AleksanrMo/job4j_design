package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

    public class Zip {
        public static void packFiles(List<Path> sources, Path target) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
                   for (Path file: sources) {
                       zip.putNextEntry(new ZipEntry(file.toFile().getPath()));
                       try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file.toFile().getPath()))) {
                           zip.write(out.readAllBytes());
                       }
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
            }

            public static void packSingleFile(File source, File target) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static ArgsName find(String[] args) {
            ArgsName arguments = ArgsName.of(args);
            Path directory = Path.of(arguments.get("d"));
            Path output = Path.of(arguments.get("o"));
            String exclude = arguments.get("e");
                if (args.length != 3 || directory == null || output == null || exclude == null) {
                    throw new IllegalArgumentException();
                    }
                return arguments;
        }

        public static  List<Path> search(Path root, Predicate<Path> condition) throws IOException {
            return Search.search(root, condition);
        }

        public static void main(String[] args) {
        char a = 'a';
            System.out.println(a);
            packSingleFile(new File("./pom.xml"),
                    new File("./pom.zip")
            );
            ArgsName arguments = find(args);
            Path directory = Path.of(arguments.get("d"));
            Path output = Path.of(arguments.get("o"));
            String exclude = arguments.get("e");
            try {
                List<Path> search = Search.search(directory, s -> !s.toFile().getName().endsWith(exclude));
                packFiles(search, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


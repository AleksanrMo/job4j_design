package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

        public static ArgsName validation(String[] args) {
            StringBuilder builder = new StringBuilder();
            for (String arg: args) {
                builder.append(arg);
            }
            if (!builder.toString().contains("-d=") || !builder.toString().contains("-e=")
                    || !builder.toString().contains("-o=")) {
                throw new IllegalArgumentException();
            }
            ArgsName arguments = ArgsName.of(args);
            Path directory = Path.of(arguments.get("d"));
            Path output = Path.of(arguments.get("o"));
            String exclude = arguments.get("e");
                if (args.length != 3 || directory == null || output == null || exclude == null) {
                    throw new IllegalArgumentException();
                    }
            if (!Files.exists(Paths.get(arguments.get("d")))) {
                throw new IllegalArgumentException("The directory does not exist!");
            }

                return arguments;
        }

        public static List<Path> search(String[] args) throws IOException {
            ArgsName arguments = validation(args);
            Path directory = Path.of(arguments.get("d"));
            String exclude = arguments.get("e");
            return Search.search(directory, s -> !s.toFile().getName().endsWith(exclude));
        }

        public static void main(String[] args) throws IOException {
            ArgsName arguments = validation(args);
            Path output = Path.of(arguments.get("o"));
            packFiles(search(args), output);

        }
    }


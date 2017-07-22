package com.pigopoyo.algoquest.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class WordCounter {




    public static void main(String[] args) throws IOException {
        List<String> options = Arrays.asList(new String[] {"-l", "-w", "-c"});
        if (args == null || args.length == 0 || args[0].isEmpty() ||
                (args.length > 1 && options.contains(args[1])) ||
                (args.length > 2 && options.contains(args[2])) ||
                (args.length > 3 && options.contains(args[3])) ) {
            System.out.println("Missing file name argument!!!.");
            System.out.println("**Usage** :");
            System.out.println("*$WordCounter <file name path> [OPTIONS]*");
            System.out.println("*[OPTIONS] Include* :");
            System.out.println("* 1. -l line count of the file *");
            System.out.println("* 2. -w line count of the file *");
            System.out.println("* 3. -c line count of the file *");


        }
        else {
            new WordCounter().wordCount(args[0]);
        }
    }

    void wordCount(String filename) throws IOException {
        long mill = System.currentTimeMillis();
        Supplier<Stream<String>> stringStream = getStreamSupplier(filename);
        long lines = stringStream.get().count();
        long count = stringStream.get().mapToLong(line -> line.split("\\s+").length).sum();
        long chars = stringStream.get().mapToLong(line -> line.length()).sum();
        System.out.println("\t"+lines + "\t" + count + "\t"+chars + "\t" + filename.substring(filename.lastIndexOf(File.separator)+1));

    }

    private Supplier<Stream<String>> getStreamSupplier(String filename) throws IOException {
        return () -> {
            try {
                return Files.lines(Paths.get(filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        };

    }

}

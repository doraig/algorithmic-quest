package com.pigopoyo.algoquest.sort;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExternalMergeSort {


    private static int MAX_TEMP_FILES = 4;

    final Comparator<String> comparator;

    public ExternalMergeSort(Comparator comparator) {
        this.comparator = comparator;
    }
    public static long blockSize(File data) {
        long  fileSize = data.length();
        long blockSize = fileSize/MAX_TEMP_FILES;
        long memory = Runtime.getRuntime().freeMemory();
        if (blockSize < memory/2) {
           // blockSize = memory/2;
        }
        else if(blockSize >= memory) {
            System.err.println("Need more memory to process this sort.");
        }
        return blockSize;
    }

    public List<Path> sortFileInBatch(File pFile) throws IOException {

        final long blockSize = blockSize(pFile);

        BufferedReader reader = new BufferedReader(new FileReader(pFile));
        /*BufferedInputStream  inputStream = new BufferedInputStream(new FileInputStream(pFile));
        inputStream.*/
        byte[] bytes = new byte[(int) blockSize];
        String data = null;
        List<String> tmpList = new ArrayList<>();
        List<Path> paths = new ArrayList<>();
        long currentSize = 0;
        while ((data = reader.readLine()) != null) {
            if (currentSize < blockSize) {
                tmpList.add(data);
                currentSize += data.length();
            } else {
                currentSize = getSaveAndCurrentSize(tmpList, paths);
                tmpList.add(data);
            }
        }
        if (!tmpList.isEmpty()) {
            getSaveAndCurrentSize(tmpList, paths);
            tmpList.clear();
        }
        return paths;
    }

    private long getSaveAndCurrentSize(List<String> tmpList, List<Path> paths) throws IOException {
        long currentSize;
        Collections.sort(tmpList, this.comparator);
        final Path file = Files.createTempFile("temp", UUID.randomUUID().toString());
        file.toFile().deleteOnExit();
        BufferedWriter bufferedWriter = Files.newBufferedWriter(file);
        try {
            tmpList.stream().forEach(x -> {
                try {
                    bufferedWriter.write(x);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        }
        finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        paths.add(file);
        currentSize = 0;
        tmpList.clear();
        return currentSize;
    }

    public void sortAndMerge(File pFile) throws IOException {
       List<Path> paths = this.sortFileInBatch(pFile);
       PriorityQueue<BufferedFileReader> queue = new PriorityQueue<>(new Comparator<BufferedFileReader>() {
           @Override
           public int compare(BufferedFileReader o1, BufferedFileReader o2) {
               try {
                   return comparator.compare(o1.peek(), o2.peek());
               } catch (IOException e) {
                   e.printStackTrace();
               }
               return 0;
           }
       });

       paths.stream().map(x -> {
           try {
               return new BufferedFileReader(x);
           } catch (IOException e) {
               e.printStackTrace();
           }
           return null;
       }).forEach(x -> queue.add(x));
       Path output = Paths.get("./Outpout.txt");
       BufferedWriter bufferedWriter = Files.newBufferedWriter(output);

       while (queue.size() > 0) {
           BufferedFileReader reader = queue.poll();
           String data = reader.pop();
           if (data != null ) {
               bufferedWriter.write(data);
               bufferedWriter.newLine();
               if (!reader.empty()) {
                   queue.add(reader);
               }
           }
           else {
               reader.close();
           }
       }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    class BufferedFileReader {
        BufferedReader file;
        Path path;
        String currentval;

        BufferedFileReader(Path path) throws IOException {
            this.file = Files.newBufferedReader(path);
            this.path = path;
        }

        String peek() throws IOException {
            if (currentval == null) {
               currentval = file.readLine();
            }
            return currentval;
        }

        String pop() {
            String temp = currentval;
            currentval = null;
            return temp;
        }

        public void close() throws IOException {
            this.file.close();
            Files.delete(this.path);

        }

        public boolean empty() throws IOException {
            return (currentval = file.readLine()) == null;
        }
    }

    /**
     * Starting point for the JVM.
     */
    public static void main(String argument[]) throws IOException {
            new ExternalMergeSort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            }).sortAndMerge(Paths.get("C:\\dev\\text.txt").toFile());
    }
}
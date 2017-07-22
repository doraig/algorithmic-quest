package com.pigopoyo.algoquest.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by zenmaster on 7/16/2017.
 */
public class ReadHugeFile {


    void readFile(String fileName) throws IOException {

        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {


            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }

    }

    public static void main(String args[]) throws IOException {
            new ReadHugeFile().readFile("file.xml");
    }


}

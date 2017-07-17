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

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
        byte[] bytes = new byte[1024*1024*10];
        bufferedInputStream.read(bytes);
        System.out.println(new String(bytes));
       /* Scanner scanner = new Scanner(new FileInputStream(fileName));

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }*/

    }

    public static void main(String args[]) throws IOException {
            new ReadHugeFile().readFile("C:\\Users\\zenmaster\\Downloads\\file\\file.xml");
    }


}

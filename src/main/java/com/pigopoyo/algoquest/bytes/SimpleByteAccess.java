package com.pigopoyo.algoquest.bytes;

import javax.lang.model.type.ArrayType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SimpleByteAccess {

    /**
     * Starting point for the JVM.
     */
    public static void main(String argument[]) {
        new SimpleByteAccess().getStringFromByte(2);
    }

    public String getStringFromByte(int size) {
        //byte[] data = new byte[8];
        byte[] data = "A".getBytes();
        System.out.println(data.length);
        System.out.println((float) Runtime.getRuntime().freeMemory()/1024/1024/1024);
        byte[][] obj = new ArrayList<String>(){{add("sample");add("test");}}.stream().map(x -> x.getBytes()).toArray(byte[][]::new);
        //Arrays.stream(obj).toArray(byte[]::new);
        String[][] a = new String[][]{{"a","b"},{"c","d"}};
        System.out.println(obj.length);
        return null;
    }
}

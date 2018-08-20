package com.pigopoyo.funprog;


import java.time.Instant;

public class Sample {

    /**
     * Starting point for the JVM.
     */
    public static void main(String argument[]) {
        Instant instant = Instant.now();
        System.out.println(instant.toString());
    }
}

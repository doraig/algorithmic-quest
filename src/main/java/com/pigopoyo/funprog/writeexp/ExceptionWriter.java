package com.pigopoyo.funprog.writeexp;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionWriter {

    public void exceptionMethod() {
        try {
            throw new IllegalAccessException("Sample error to write is back to a string!");
        }
        catch (Exception exp) {
            StringWriter stringWriter = new StringWriter();
            exp.printStackTrace(new PrintWriter(stringWriter));
            System.out.println(stringWriter.toString());
            System.out.println(exp.getLocalizedMessage());
        }
    }

    /**
     * Starting point for the JVM.
     */
    public static void main(String argument[]) {
            new ExceptionWriter().exceptionMethod();
    }
}

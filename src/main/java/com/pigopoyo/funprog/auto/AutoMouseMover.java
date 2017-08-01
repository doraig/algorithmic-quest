package com.pigopoyo.funprog.auto;

import java.awt.*;
import java.util.Random;

public class AutoMouseMover {

    /**
     * Starting point for the JVM.
     */
    public static void main(String argument[]) throws AWTException, InterruptedException {

        Random random = new Random();
        Robot robot = new Robot();
        while (true) {
            robot.mouseMove(random.nextInt(900),random.nextInt(800));
            Thread.sleep(5000);
        }

    }
}

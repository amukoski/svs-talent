package com.amukoski;

import com.amukoski.thread.NumberPrinterThread;

public class Application {
    public static void main(String[] args) {
        Long countTo = 1_000_000L;
        Long waitTime = 1000L;

        Thread task = new NumberPrinterThread(countTo);

        try {
            task.start();
            task.join(waitTime);

            if (task.isAlive()) {
                task.interrupt();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

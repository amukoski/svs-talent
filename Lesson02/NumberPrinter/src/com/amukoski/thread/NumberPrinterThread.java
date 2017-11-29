package com.amukoski.thread;

public class NumberPrinterThread extends Thread {

    private Long countTo;

    public NumberPrinterThread(Long countTo) {
        this.countTo = countTo;
    }

    @Override
    public void run() {
        Long start = 1L;

        while(start <= countTo){

            if(Thread.interrupted()) {
                System.out.println("NumberPrinterThread Interrupted");
                return;
            }

            System.out.println("NumberPrinterThread: " + start++);
        }
    }
}

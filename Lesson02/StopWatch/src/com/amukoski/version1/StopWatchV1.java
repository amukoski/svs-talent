package com.amukoski.version1;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class StopWatchV1 extends Thread {

    private Long elapsedTimeInSeconds;
    private Boolean paused;

    public StopWatchV1() {
        this.elapsedTimeInSeconds = 0L;
        this.paused = Boolean.FALSE;
    }

    public void startTimer() {
        start();
    }

    public void stopTimer() {
        if (isAlive()) {
            interrupt();
        }
    }

    public void pauseTimer() {
        paused = true;
    }

    public void resumeTimer() {
        synchronized (this) {
            paused = false;
            notify();
        }
    }

    public void resetTimer() {
        elapsedTimeInSeconds = 0L;
    }

    @Override
    public void run() {
        while (true) {

            if (isInterrupted()) {
                System.out.println("StopWatchV2 stopped");
                return;
            }

            if (paused) {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("StopWatchV2 Exception while pause waiting");
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(LocalTime.ofSecondOfDay(elapsedTimeInSeconds++));
                } catch (InterruptedException e) {
                    System.out.println("StopWatchV2 stopped while sleeping");
                    return;
                }
            }
        }
    }
}

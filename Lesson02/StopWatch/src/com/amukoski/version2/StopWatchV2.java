package com.amukoski.version2;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class StopWatchV2 extends Thread {

    private Long elapsedTimeInSeconds;
    private volatile Boolean running;
    private volatile Boolean paused;

    public StopWatchV2(){
        this.elapsedTimeInSeconds = 0L;
        this.running = false;
        this.paused = false;
    }

    public void startTimer() {
        resetTimer();
        resumeTimer();
        super.start();
    }

    public void stopTimer() {
        running = paused = false;
        interrupt();
    }

    public void pauseTimer() {
        running = false;
        paused = true;
    }

    public void resumeTimer() {
        running = true;
        paused = false;
    }

    public void resetTimer() {
        elapsedTimeInSeconds = 0L;
    }

    @Override
    public void run() {
        while (running || paused) {
            if(isInterrupted()){
                return;
            }

            if (running) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(LocalTime.ofSecondOfDay(elapsedTimeInSeconds++));
                } catch (InterruptedException e) {
                    System.out.println("Interrupted while sleeping");
                    return;
                }
            }
        }
    }
}

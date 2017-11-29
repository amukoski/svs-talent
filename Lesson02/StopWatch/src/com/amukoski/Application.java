package com.amukoski;

import com.amukoski.version1.StopWatchV1;
import com.amukoski.version2.StopWatchV2;

import java.util.Scanner;

public class Application {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        StopWatchV1 stopWatch = new StopWatchV1();

        while (true) {
            String command = input.next();      // output have conflict (overlaps) with input in console
            switch (command) {
                case "start":
                    stopWatch.startTimer();
                    break;
                case "stop":
                    stopWatch.stopTimer();
                    break;
                case "pause":
                    stopWatch.pauseTimer();
                    break;
                case "resume":
                    stopWatch.resumeTimer();
                    break;
                case "reset":
                    stopWatch.resetTimer();
                    break;
            }

            if (command.equals("exit")) {
                if (stopWatch.isAlive()) {
                    stopWatch.interrupt();
                }
                break;
            }
        }
    }
}

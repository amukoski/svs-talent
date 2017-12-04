package com.amukoski;

import com.amukoski.alarmchannel.ConsoleAlarmChannel;
import com.amukoski.imagecapturingdevice.ConsoleImageCapturingDevice;
import com.amukoski.motiondetector.MotionDetector;

public class Application {
    public static void main(String[] args) {
        MotionDetector motionDetector = new MotionDetector(new ConsoleImageCapturingDevice());
        motionDetector.registerAlarmChannel(new ConsoleAlarmChannel(1L));
        motionDetector.registerAlarmChannel(new ConsoleAlarmChannel(2L));

        Thread motionDetectorTask = new Thread(motionDetector);
        motionDetectorTask.start();
    }
}

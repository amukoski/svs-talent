package com.amukoski.motiondetector;

import com.amukoski.alarmchannel.AlarmChannel;
import com.amukoski.imagecapturingdevice.ImageCapturingDevice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MotionDetector implements Runnable {

    private ImageCapturingDevice imageCapturingDevice;
    private List<AlarmChannel> alarmChannelList;
    private byte[] previousImage = null;

    public MotionDetector(ImageCapturingDevice imageDevice) {
        this.imageCapturingDevice = imageDevice;
        this.alarmChannelList = new ArrayList<>();
    }

    public void registerAlarmChannel(AlarmChannel alarm) {
        this.alarmChannelList.add(alarm);
    }

    private void notifyAlarmChannels() {
        for (AlarmChannel alarmChannel : this.alarmChannelList) {
            alarmChannel.alarm();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {

                TimeUnit.SECONDS.sleep(1);

                if (previousImage == null) {
                    previousImage = imageCapturingDevice.captureImage();
                } else {
                    byte[] currentImage = imageCapturingDevice.captureImage();

                    if (!Arrays.equals(previousImage, currentImage)) {
                        notifyAlarmChannels();
                    }

                    previousImage = currentImage;
                }

            } catch (InterruptedException e) {
                System.out.println("Thread interrupted while sleeping");
            }
        }
    }
}

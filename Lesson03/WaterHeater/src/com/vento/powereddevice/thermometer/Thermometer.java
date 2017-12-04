package com.vento.powereddevice.thermometer;

import com.vento.exception.NoPowerException;
import com.vento.powereddevice.PoweredDevice;

import java.util.Random;

public class Thermometer implements PoweredDevice {

    private boolean powerEnabled = false;

    private Random random = new Random(System.currentTimeMillis());

    public Integer getTemperature() {
        if (!powerEnabled) {
            throw new NoPowerException();
        }
        return random.nextInt(60);
    }

    @Override
    public void enablePower() {
        powerEnabled = true;
    }

    @Override
    public void disablePower() {
        powerEnabled = false;
    }
}

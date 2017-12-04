package com.vento.powereddevice.heater;

import com.vento.exception.NoPowerException;
import com.vento.powereddevice.PoweredDevice;

public class Heater implements PoweredDevice {

    private boolean powerEnabled = false;

    @Override
    public void enablePower() {
        powerEnabled = true;
    }

    @Override
    public void disablePower() {
        powerEnabled = false;
    }

    public void startHeating() {
        if (!powerEnabled) {
            throw new NoPowerException();
        }
        System.out.println("Heater.startHeating()");
    }

    public void stopHeating() {
        System.out.println("Heater.stopHeating()");
    }
}

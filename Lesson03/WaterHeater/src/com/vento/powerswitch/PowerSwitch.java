package com.vento.powerswitch;

import com.vento.powereddevice.PoweredDevice;

import java.util.ArrayList;

public class PowerSwitch {

    private ArrayList<PoweredDevice> poweredDevices = new ArrayList<PoweredDevice>();

    public void controlPowerFor(PoweredDevice poweredDevice) {
        poweredDevices.add(poweredDevice);
    }

    public void turnOn() {
        for (PoweredDevice device : poweredDevices) {
            device.enablePower();
        }
    }

    public void turnOff() {
        for (PoweredDevice device : poweredDevices) {
            device.disablePower();
        }
    }
}

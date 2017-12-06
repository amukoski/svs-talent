package com.vento.thermoregulator;

import com.vento.powereddevice.PoweredDevice;

public interface Thermoregulator extends PoweredDevice {

    void setTemperature(Integer temperature);
}

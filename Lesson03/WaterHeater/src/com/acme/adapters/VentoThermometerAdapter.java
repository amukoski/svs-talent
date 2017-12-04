package com.acme.adapters;

import com.acme.thermometer.ThermometerDevice;
import com.vento.powereddevice.thermometer.Thermometer;

public class VentoThermometerAdapter implements ThermometerDevice {

    private Thermometer thermometer;

    public VentoThermometerAdapter(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    @Override
    public Integer getTemperature() {
        return thermometer.getTemperature();
    }
}

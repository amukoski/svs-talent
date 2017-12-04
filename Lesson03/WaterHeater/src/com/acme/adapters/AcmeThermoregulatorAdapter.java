package com.acme.adapters;

import com.acme.thermoregulator.ThermoregulatorDevice;
import com.vento.powereddevice.thermoregulator.Thermoregulator;

public class AcmeThermoregulatorAdapter implements Thermoregulator {

    private ThermoregulatorDevice thermoregulator;

    public AcmeThermoregulatorAdapter(ThermoregulatorDevice thermoregulator) {
        this.thermoregulator = thermoregulator;
    }

    @Override
    public void enablePower() {
        thermoregulator.turnOn();
    }

    @Override
    public void disablePower() {
        thermoregulator.turnOff();
    }

    @Override
    public void setTemperature(Integer temperature) {
        thermoregulator.setTemperature(temperature);
    }
}

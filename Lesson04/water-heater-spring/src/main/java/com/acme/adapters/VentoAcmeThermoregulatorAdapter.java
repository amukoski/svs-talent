package com.acme.adapters;

import com.acme.thermoregulator.ThermoregulatorDevice;
import com.vento.thermoregulator.Thermoregulator;
import org.springframework.stereotype.Component;

@Component
public class VentoAcmeThermoregulatorAdapter implements Thermoregulator {

    private ThermoregulatorDevice thermoregulator;

    public VentoAcmeThermoregulatorAdapter(ThermoregulatorDevice thermoregulator) {
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

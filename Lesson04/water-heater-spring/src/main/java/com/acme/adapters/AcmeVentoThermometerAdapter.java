package com.acme.adapters;

import com.acme.thermoregulator.ThermometerDevice;
import com.vento.thermometer.Thermometer;
import org.springframework.stereotype.Component;

@Component
public class AcmeVentoThermometerAdapter implements ThermometerDevice {

    private Thermometer thermometer;

    public AcmeVentoThermometerAdapter(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    @Override
    public Integer getTemperature() {
        return thermometer.getTemperature();
    }
}

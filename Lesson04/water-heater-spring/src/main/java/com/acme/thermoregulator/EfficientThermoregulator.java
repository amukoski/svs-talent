package com.acme.thermoregulator;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("efficient")
public class EfficientThermoregulator extends StandardThermoregulator implements ThermoregulatorDevice {

    public EfficientThermoregulator(HeaterDevice heater, ThermometerDevice thermometer) {
        super(heater, thermometer);
        super.seconds = 1L;
    }
}

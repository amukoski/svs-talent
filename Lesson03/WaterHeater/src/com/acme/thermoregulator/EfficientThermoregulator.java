package com.acme.thermoregulator;

import com.acme.heater.HeaterDevice;
import com.acme.thermometer.ThermometerDevice;

public class EfficientThermoregulator extends StandardThermoregulator implements ThermoregulatorDevice {

    public EfficientThermoregulator(HeaterDevice heater, ThermometerDevice thermometer) {
        super(heater, thermometer);
        super.seconds = 1L;
    }
}

package com.acme.thermoregulator;

public class EfficientThermoregulator extends StandardThermoregulator implements ThermoregulatorDevice {

    public EfficientThermoregulator(HeaterDevice heater, ThermometerDevice thermometer) {
        super(heater, thermometer);
        super.seconds = 1L;
    }
}

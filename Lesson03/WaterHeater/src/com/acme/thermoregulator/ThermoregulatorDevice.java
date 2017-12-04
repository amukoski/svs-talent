package com.acme.thermoregulator;

public interface ThermoregulatorDevice {
    void turnOn();

    void turnOff();

    void setTemperature(Integer temperature);
}

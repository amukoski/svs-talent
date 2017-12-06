package com.acme.thermoregulator;

import java.util.concurrent.TimeUnit;

public class StandardThermoregulator extends Thread implements ThermoregulatorDevice {

    private HeaterDevice heater;
    private ThermometerDevice thermometer;

    private volatile boolean running = false;
    private volatile Integer temperature = 20;  // Default
    Long seconds = 3L;

    public StandardThermoregulator(HeaterDevice heater, ThermometerDevice thermometer) {
        this.heater = heater;
        this.thermometer = thermometer;
    }

    @Override
    public void turnOn() {
        this.running = true;
        start();
    }

    @Override
    public void turnOff() {
        this.running = false;
//        interrupt();
    }

    @Override
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Integer thermometerTemperature = thermometer.getTemperature();
                System.out.printf("Thermometer:%2s | Thermoregulator:%2s | ", thermometerTemperature, this.temperature);
                if (thermometerTemperature.compareTo(this.temperature) < 0) {
                    heater.startHeating();
                } else {
                    heater.stopHeating();
                }

                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                System.out.println("Thermoregulator interrupted while sleeping!");
                break;
            }
        }
    }
}

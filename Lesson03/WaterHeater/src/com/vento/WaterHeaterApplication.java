package com.vento;

import com.acme.adapters.AcmeVentoHeaterAdapter;
import com.acme.adapters.AcmeVentoThermometerAdapter;
import com.acme.adapters.VentoAcmeThermoregulatorAdapter;
import com.acme.thermoregulator.EfficientThermoregulator;
import com.vento.heater.Heater;
import com.vento.thermometer.Thermometer;
import com.vento.thermoregulator.Thermoregulator;
import com.vento.powerswitch.PowerSwitch;
import com.vento.waterheater.WaterHeater;

import java.util.concurrent.TimeUnit;

public class WaterHeaterApplication {

    public static void main(String[] args) throws Exception {
        PowerSwitch powerSwitch = new PowerSwitch();
        Heater heater = new Heater();
        Thermometer thermometer = new Thermometer();

//        // Standard
//        Thermoregulator thermoregulator = new VentoAcmeThermoregulatorAdapter(
//            new StandardThermoregulator(
//                    new AcmeVentoHeaterAdapter(heater),
//                    new AcmeVentoThermometerAdapter(thermometer)));

        // Efficient
        Thermoregulator thermoregulator = new VentoAcmeThermoregulatorAdapter(
                new EfficientThermoregulator(
                        new AcmeVentoHeaterAdapter(heater),
                        new AcmeVentoThermometerAdapter(thermometer)));

        WaterHeater waterHeater = new WaterHeater(powerSwitch, heater, thermometer, thermoregulator);

        simulateRun(waterHeater);
    }

    private static void simulateRun(WaterHeater waterHeater) {
        waterHeater.getThermoregulator().setTemperature(20);
        waterHeater.getPowerSwitch().turnOn();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
        }

        waterHeater.getThermoregulator().setTemperature(40);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
        }

        waterHeater.getPowerSwitch().turnOff();
    }
}

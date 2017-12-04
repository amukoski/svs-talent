package com.vento;

import com.acme.adapters.AcmeThermoregulatorAdapter;
import com.acme.adapters.VentoHeaterAdapter;
import com.acme.adapters.VentoThermometerAdapter;
import com.acme.thermoregulator.EfficientThermoregulator;
import com.acme.thermoregulator.StandardThermoregulator;
import com.vento.powereddevice.heater.Heater;
import com.vento.powereddevice.thermometer.Thermometer;
import com.vento.powereddevice.thermoregulator.Thermoregulator;
import com.vento.powereddevice.PowerSwitch;
import com.vento.waterheater.WaterHeater;

import java.util.concurrent.TimeUnit;

public class WaterHeaterApplication {

    public static void main(String[] args) throws Exception {
        PowerSwitch powerSwitch = new PowerSwitch();
        Heater heater = new Heater();
        Thermometer thermometer = new Thermometer();

//        // Standard
//        Thermoregulator thermoregulator = new AcmeThermoregulatorAdapter(
//            new StandardThermoregulator(
//                    new VentoHeaterAdapter(heater),
//                    new VentoThermometerAdapter(thermometer)));

        // Efficient
        Thermoregulator thermoregulator = new AcmeThermoregulatorAdapter(
                new EfficientThermoregulator(
                        new VentoHeaterAdapter(heater),
                        new VentoThermometerAdapter(thermometer)));

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

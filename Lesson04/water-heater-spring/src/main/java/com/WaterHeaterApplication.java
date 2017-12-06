package com;

import com.vento.waterheater.WaterHeater;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class WaterHeaterApplication {

    public static void main(String[] args) throws Exception {

        ApplicationContext context =
                SpringApplication.run(WaterHeaterApplication.class, args);

        simulateRun(context.getBean(WaterHeater.class));
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

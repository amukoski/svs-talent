package com.acme.adapters;

import com.acme.thermoregulator.HeaterDevice;
import com.vento.heater.Heater;
import org.springframework.stereotype.Component;

@Component
public class AcmeVentoHeaterAdapter implements HeaterDevice {

    private Heater heater;

    public AcmeVentoHeaterAdapter(Heater heater) {
        this.heater = heater;
    }

    @Override
    public void startHeating() {
        heater.startHeating();
    }

    @Override
    public void stopHeating() {
        heater.stopHeating();
    }
}

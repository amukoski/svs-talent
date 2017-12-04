package com.acme.adapters;

import com.acme.heater.HeaterDevice;
import com.vento.powereddevice.heater.Heater;

public class VentoHeaterAdapter implements HeaterDevice {

    private Heater heater;

    public VentoHeaterAdapter(Heater heater) {
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

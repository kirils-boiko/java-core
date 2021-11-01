package com.example.mypackage;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "PLANET");
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getBodyType().equals("MOON"))
            return super.addSatellite(satellite);

        return false;
    }
}

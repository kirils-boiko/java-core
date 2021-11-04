package com.example.mypackage;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getBodyType() == BodyTypes.MOON)
            return super.addSatellite(satellite);

        return false;
    }
}

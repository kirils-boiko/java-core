package com.example.mypackage;

public class Moon extends HeavenlyBody {

    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "MOON");
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        return false;
    }
}

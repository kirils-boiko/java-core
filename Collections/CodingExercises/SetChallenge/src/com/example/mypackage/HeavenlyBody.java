package com.example.mypackage;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final String bodyType;

    public HeavenlyBody(String name, double orbitalPeriod, String bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.bodyType = bodyType;
        this.satellites = new HashSet<>();
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public final String getName() {
        return name;
    }

    public final double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public final Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public final String getBodyType() {
        return bodyType;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;

//        System.out.println("obj.getClass(): " + obj.getClass());
//        System.out.println("this.getClass(): " + this.getClass());

//        if (obj == null || obj.getClass() != this.getClass())
//            return false;

        if (obj instanceof HeavenlyBody) {
            String objName = ((HeavenlyBody) obj).getName();
            String objBodyType = ((HeavenlyBody) obj).getBodyType();
            return this.name.equals(objName) && this.bodyType.equals(objBodyType);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + this.bodyType.hashCode() +57;
    }

}

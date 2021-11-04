package com.example.mypackage;

public class Orc implements Being, Comparable<Orc> {

    private final String name;
    private String weapon;


    public Orc(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public int compareTo(Orc orc) {
        return this.name.compareTo(orc.name);
    }

}

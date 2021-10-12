package kiro.javaCore;

public class Holden extends Car {

    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Holden.startEngine(): engine is running";
    }

    @Override
    public String accelerate() {
        return "Holden.accelerate(): Holden is accelerating...";
    }

    @Override
    public String brake() {
        return "Holden.brake(): Holden is braking...";
    }
}

package kiro.javaCore;

public class Mitsubishi extends Car {

    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Mitsubishi.startEngine(): engine is running";
    }

    @Override
    public String accelerate() {
        return "Mitsubishi.accelerate(): Mitsubishi is accelerating...";
    }

    @Override
    public String brake() {
        return "Mitsubishi.brake(): Mitsubishi is braking...";
    }
}

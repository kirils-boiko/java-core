package kiro.javaCore;

public class Ford extends Car {

    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Ford.startEngine(): engine is running";
    }

    @Override
    public String accelerate() {
        return "Ford.accelerate(): Ford is accelerating...";
    }

    @Override
    public String brake() {
        return "Ford.brake(): Ford is braking...";
    }
}

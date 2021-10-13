package kiro.javaCore;

public class Car {

    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public String startEngine() {
        return "Car.startEngine(): engine is running...";
    }

    public String accelerate() {
        return "Car.accelerate(): car is accelerating...";
    }

    public String brake() {
        return "Car.brake(): car is braking...";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}

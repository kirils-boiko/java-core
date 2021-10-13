package kiro.javaCore;

public class Car {
    // Base class

    private String manufacturer;
    private String model;
    private boolean engine;
    private boolean electric;
    private int cylinders;
    private int wheels;
    private int doors;
    private int maxSpeed;

    public Car(String manufacturer, String model, boolean electric,
               int cylinders, int doors, int maxSpeed) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.electric = electric;
        this.cylinders = (!electric && cylinders > 0) ? cylinders : 0;
        this.doors = doors > 1 ? doors : 1;
        this.maxSpeed = maxSpeed > 0 ? maxSpeed : 0;

        this.wheels = 4;
        this.engine = false;
    }

    public void startEngine() {
        if (engine) {
            System.out.println("Car.startEngine(): engine's already started");
        } else {
            System.out.println("Car.startEngine(): starting the engine...");
        }
    }

    public void accelerate() {
        System.out.println("Car.accelerate(): car is accelerating...");
    }

    public void brake() {
        System.out.println("Car.brake(): car is braking....");
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public boolean isEngine() {
        return engine;
    }

    public boolean isElectric() {
        return electric;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public int getDoors() {
        return doors;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}

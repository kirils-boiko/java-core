package kiro.javaCore;

public class Vehicle {
    // Base class
    private String name;
    private String size;

    private int currentSpeed;
    private int currentDirection;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;

        this.currentSpeed = 0;
        this.currentDirection = 0;
    }

    protected void turn(int delta) {
        currentDirection += delta;
        System.out.println("Vehicle.turn(): moving at " + currentSpeed
                + "km/h in direction of " + currentDirection + " degrees;");
    }

    protected void adjustSpeed(int delta) {
        currentSpeed += delta;
        System.out.println("Vehicle.adjustSpeed(): moving at " + currentSpeed
                + "km/h in direction of " + currentDirection + " degrees;");
    }

    public void changeVelocity(int speed, int direction) {
        currentSpeed = speed;
        currentDirection = direction;
        System.out.println("Vehicle.changeVelocity(): moving at " + currentSpeed
            + "km/h in direction of " + currentDirection + " degrees;");
    }

    public void stop() {
        currentSpeed = 0;
        System.out.println("Vehicle.stop(): moving at " + currentSpeed
                + "km/h in direction of " + currentDirection + " degrees;");
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }
}

package kiro.javaCore;

public class Car extends Vehicle {

    private int wheels;
    private int doors;
    private int gears;
    private int maxSpeed;
    private boolean isManual;

    private int currentGear;

    public Car(String name, String size, int wheels, int doors,
               int gears, int maxSpeed, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.maxSpeed = (maxSpeed > 0) ? maxSpeed : 0;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void setCurrentGear(int currentGear) {
        if (!isManual) {
            System.out.println("Car.setCurrentGear(): cannot manually change the gear;");
            return;
        }
        if (currentGear < 1)
            currentGear = 1;
        if (currentGear > this.gears)
            currentGear = this.gears;

        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear(): changed to " +
                this.currentGear + " gear;");
    }

    public void steer(int degreeChange) {
        System.out.println("Car.steer() called");
        super.turn(degreeChange);
    }

    public void accelerate(int speedIncrease) {
        if (speedIncrease < 0)
            speedIncrease = 0;
        System.out.println("Car.accelerate() called");
        super.adjustSpeed(speedIncrease);
    }

    public void brake(int speedDecrease) {
        if (speedDecrease < 0)
            speedDecrease = 0;
        System.out.println("Car.brake() called");
        super.adjustSpeed(-speedDecrease);
    }

    @Override
    public void stop() {
        System.out.println("Car.stop() called");
        super.stop();
    }

    public int getWheels() {
        return wheels;
    }

    public int getDoors() {
        return doors;
    }

    public int getGears() {
        return gears;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public boolean isManual() {
        return isManual;
    }

    public int getCurrentGear() {
        return currentGear;
    }
}

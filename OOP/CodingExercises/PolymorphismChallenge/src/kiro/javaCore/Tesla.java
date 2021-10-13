package kiro.javaCore;

public class Tesla extends Car {

    public Tesla(String model, int doors, int maxSpeed) {
        super("Tesla", model, true, -1, doors, maxSpeed);
    }

    @Override
    public void startEngine() {
        System.out.println("Tesla doesn't need its engine started, silly, just drive!");
    }

    @Override
    public void accelerate() {
        System.out.println("The silent beast is accelerating...");
    }

    @Override
    public void brake() {
        System.out.println("Even the car itself is surprised by how fast it brakes");
    }

    @Override
    public boolean isElectric() {
        System.out.println("Of course it's electric, you silly!");
        return super.isElectric();
    }

    @Override
    public boolean isEngine() {
        System.out.println("Tesla's engine is always on!");
        return true;
    }

    @Override
    public int getCylinders() {
        System.out.println("Tesla doesn't have cylinders, you silly!");
        return -1;
    }
}

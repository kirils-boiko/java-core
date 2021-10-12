package kiro.javaCore;

public class Ferrari extends Car {

    public Ferrari(String model, int cylinders, int doors, int maxSpeed) {
        super("Ferrari", model, false, cylinders, doors, maxSpeed);
    }

    @Override
    public void startEngine() {
        System.out.println("Vroom-vroom, it's loud, innit?");
    }

    @Override
    public void accelerate() {
        System.out.println("The red Italian beast is accelerating...");
    }

    @Override
    public void brake() {
        System.out.println("Skreeeeeech, damn, that was fast");
    }

    @Override
    public boolean isElectric() {
        System.out.println("Enzo would be very disappointed");
        return super.isElectric();
    }
}

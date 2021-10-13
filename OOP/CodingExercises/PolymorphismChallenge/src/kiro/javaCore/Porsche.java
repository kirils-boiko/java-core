package kiro.javaCore;

public class Porsche extends Car {

    public Porsche(String model, boolean electric, int cylinders, int doors, int maxSpeed) {
        super("Porsche", model, electric, cylinders, doors, maxSpeed);
        System.out.println("Porsche ist eines der besten Autos der Welt. Tausende fleißiger Ingenieure haben...");
        System.out.println("Something in German, I don't understand...");
    }

    @Override
    public void startEngine() {
        System.out.println("Motor wird gestartet...");
    }

    @Override
    public void accelerate() {
        System.out.println("Wildes Pferd beschleunigt...");
    }

    @Override
    public void brake() {
        System.out.println("Ach ja, obwohl wir Deutschen Straßen ohne Geschwindigkeitsbegrenzung haben, neigen wir dennoch dazu, vorsichtig zu fahren");
    }
}

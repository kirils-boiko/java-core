package kiro.javaCore;

public class Dog extends Animal {

    // characteristics in addition to the basic characteristics of Animal
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs,
               int tail, int teeth, String coat) {
        // basic characteristics initialization
        super(name, 1, 1, size, weight);

        // Dog-unique characteristics initialization
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Dog.chew() called");
    }

    private void moveLegs() {
        System.out.println("Dog.moveLegs() called");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        this.moveLegs();
        super.move(speed);
    }

    public void bark() {
        System.out.println("Dog.bark() called");
    }

    public void walk() {
        System.out.println("Dog.walk() called");
        move(5);        // calls the overridden method
    }

    public void run() {
        System.out.println("Dog.run() called");
        move(15);       // calls the overridden method
    }

    public void kick() {
        System.out.println("Dog.kick() called");
        super.move(70); // calls the superclass' method
    }
}

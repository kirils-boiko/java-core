package kiro.AbstractClassesAndInterfaces;

public abstract class Bird extends Animal implements CanFly {

    public Bird(String name) {
        super(name);
    }


    // methods implemented from abstract class Animal
    @Override
    public void eat() {
        System.out.println(getName() + " is pecking");
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " is breathing");
    }

    // methods implemented from interface CanFly
    @Override
    public void fly() {
        System.out.println(getName() + " is flapping its wings");
    }
}

package kiro.AbstractClassesAndInterfaces;

public class Main {

    public static void main(String[] args) {
	    Dog dog = new Dog("Bulldog");
        dog.breathe();
        dog.eat();

        Bird parrot = new Parrot("Ringneck");
        // Parrot parrot = new Parrot("Ringneck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Bird penguin = new Penguin("King Penguin");
        penguin.breathe();
        penguin.eat();
        penguin.fly();

        Animal.staticMethod();
    }
}

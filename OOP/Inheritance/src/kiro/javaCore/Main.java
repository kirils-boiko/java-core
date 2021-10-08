package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Animal", 1, 1,
                5, 5);

        Dog dog = new Dog("German Shepherd", 8, 20,
                2,4,1,20,"double coat");

        animal.eat();
        animal.move(1);
        System.out.println();

        // inherited from base class (and overridden)
        dog.eat();
        dog.move(10);
        System.out.println();

        // unique to Dog class, but calls super's methods
        dog.walk();
        dog.run();
        dog.kick();
        System.out.println();

        // unique to Dog class, no calls to superclass's methods
        dog.bark();
        System.out.println();

        // Fish class's methods that utilize private class methods as well
        //  as methods inherited from superclass;
        Fish fish = new Fish("Salmon", 1, 100,
                2, 2, 3);
        fish.swim(40);


    }
}

package kiro.AbstractClassesAndInterfaces;

public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();
    public abstract void breathe();

    public String getName() {
        return name;
    }

    public static void staticMethod() {
        System.out.println("static method of abstract class");
    }
}

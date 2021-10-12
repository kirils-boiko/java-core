package kiro.javaCore;

public class DeluxeBurger extends Hamburger{

    public DeluxeBurger() {
        super("Deluxe", "beef patty", 19.10, "sesame seed");
        super.addHamburgerAddition1("Tomato", 0);
        super.addHamburgerAddition2("Cheddar", 0);
        super.addHamburgerAddition3("Onion Rings", 0);
        super.addHamburgerAddition4("Bacon", 0);
        System.out.println("Added Chips for an extra 0.00");
        System.out.println("Added Drink for an extra 0.00");
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Cannot add additional items to a Deluxe hamburger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        this.addHamburgerAddition1("", 0);
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        this.addHamburgerAddition1("", 0);
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        this.addHamburgerAddition1("", 0);
    }
}

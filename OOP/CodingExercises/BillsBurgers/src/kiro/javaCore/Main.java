package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        Hamburger baseHamburger = new Hamburger("Base", "beef",
                "standard", 5.50, 4);
        baseHamburger.addAddition(1, "lettuce", 0.50);
        baseHamburger.addAddition(2, "tomato", 0.50);
        baseHamburger.addAddition(3, "bacon", 1.00);
        baseHamburger.addAddition(4, "onion rings", 1.50);
        baseHamburger.printTotal();

        System.out.println();
        Hamburger healthyHamburger = new HealthyHamburger("beef", 8.50);
        healthyHamburger.addAddition(1, "lettuce", 0.50);
        healthyHamburger.addAddition(2, "tomato",0.50);
        healthyHamburger.addAddition(3, "carrot", 0.50);
        healthyHamburger.addAddition(4, "pickles", 0.50);
        healthyHamburger.addAddition(5, "greek sauce", 1.00);
        healthyHamburger.addAddition(6, "goat cheese", 1.50);
        healthyHamburger.printTotal();

        System.out.println();
        Hamburger deluxeHamburger = new DeluxeHamburger("beef", "standard", 8.50);
        deluxeHamburger.addAddition(1, "lettuce", 0.50);
        deluxeHamburger.addAddition(2, "tomato",0.50);
        deluxeHamburger.addAddition(3, "bacon", 1.00);
        deluxeHamburger.addAddition(4, "pickles", 0.50);
        deluxeHamburger.addAddition(5, "greek sauce", 1.00);
        deluxeHamburger.addAddition(6, "goat cheese", 1.50);
        deluxeHamburger.printTotal();
    }
}

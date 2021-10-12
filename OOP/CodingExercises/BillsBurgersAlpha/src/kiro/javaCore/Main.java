package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
	    Hamburger hamburger = new Hamburger("Basic", "Sausage",
                 3.56, "White");
        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.65);
        hamburger.addHamburgerAddition3("Cheese", 1.50);
        hamburger.addHamburgerAddition4("Bacon", 1.50);
        System.out.println("Total burger price is " + hamburger.itemizeHamburger());
        System.out.println();

        HealthyBurger healthyBurger = new HealthyBurger("Beef patty", 5.67);
        healthyBurger.addHamburgerAddition1("Bacon", 1.50);
        healthyBurger.addHamburgerAddition2("Tomato", 0.27);
        healthyBurger.addHealthyAddition1("Egg", 1.50);
        healthyBurger.addHealthyAddition2("Lentils", 1.50);
        System.out.println("Total burger price is " + healthyBurger.itemizeHamburger());
        System.out.println();

        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.addHamburgerAddition1("Lettuce", 0.75);
        deluxeBurger.addHamburgerAddition3("Cheese", 1.50);
        System.out.println("Total burger price is " + deluxeBurger.itemizeHamburger());
        System.out.println();




    }
}

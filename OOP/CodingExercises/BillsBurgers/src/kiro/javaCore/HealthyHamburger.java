package kiro.javaCore;

public class HealthyHamburger extends Hamburger{

    public HealthyHamburger(String meat, double price) {
        super("Healthy", meat, "brown rye",
                price, NUMBER_OF_ADDITIONS + 2);
    }

    @Override
    public void addAddition(int additionNumber, String name, double price) {
        super.addAddition(additionNumber, name, 0);
    }
}

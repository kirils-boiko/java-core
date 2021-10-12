package kiro.javaCore;

public class DeluxeHamburger extends Hamburger {

    public DeluxeHamburger(String meat, String breadRollType, double price) {
        super("Deluxe", meat, breadRollType, price, NUMBER_OF_ADDITIONS);
        super.addAddition(super.getNumberOfAdditions() -1,
                "chips", 0.0);
        super.addAddition(super.getNumberOfAdditions(), "drink", 0.0);
    }

    @Override
    public void addAddition(int additionNumber, String name, double price) {
        if (additionNumber > super.getNumberOfAdditions() - 2) {
            System.out.println(String.format("Only additions 1-%d are allowed for %s hamburger",
                    super.getNumberOfAdditions() - 2, super.getName()));
            return;
        }
        super.addAddition(additionNumber, name, price);
    }

}

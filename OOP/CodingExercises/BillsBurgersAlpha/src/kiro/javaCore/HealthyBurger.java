package kiro.javaCore;

public class HealthyBurger extends Hamburger {

    private String healthyExtra1Name;
    private String healthyExtra2Name;

    private double healthyExtra1Price;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, price, "Brown rye");
    }

    public void addHealthyAddition1(String name, double price) {
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price > 0 ? price : 0;

        System.out.println(String.format("Added %s for an extra %.02f",
                name, this.healthyExtra1Price));
    }

    public void addHealthyAddition2(String name, double price) {
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price > 0 ? price : 0;

        System.out.println(String.format("Added %s for an extra %.02f",
                name, this.healthyExtra2Price));
    }

    @Override
    public double itemizeHamburger() {
        return super.itemizeHamburger() + this.healthyExtra1Price  +
                this.healthyExtra2Price;
    }
}

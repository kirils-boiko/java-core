package kiro.javaCore;

public class Hamburger {

    private String name;
    private String meat;
    private String breadRollType;
    private double price;

    private String addition1Name;
    private String addition2Name;
    private String addition3Name;
    private String addition4Name;

    private double addition1Price;
    private double addition2Price;
    private double addition3Price;
    private double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.breadRollType = breadRollType;
        this.price = price > 0 ? price : 0;

        System.out.println(String.format("%s hamburger on a %s roll with %s, " +
                "price is %.02f", name, breadRollType, meat, this.price));
    }

    public void addHamburgerAddition1(String name, double price) {
        this.addition1Name = name;
        this.addition1Price = price > 0 ? price : 0;

        System.out.println(String.format("Added %s for an extra %.02f",
                name, this.addition1Price));
    }

    public void addHamburgerAddition2(String name, double price) {
        this.addition2Name = name;
        this.addition2Price = price > 0 ? price : 0;

        System.out.println(String.format("Added %s for an extra %.02f",
                name, this.addition2Price));
    }

    public void addHamburgerAddition3(String name, double price) {
        this.addition3Name = name;
        this.addition3Price = price > 0 ? price : 0;

        System.out.println(String.format("Added %s for an extra %.02f",
                name, this.addition3Price));
    }

    public void addHamburgerAddition4(String name, double price) {
        this.addition4Name = name;
        this.addition4Price = price > 0 ? price : 0;

        System.out.println(String.format("Added %s for an extra %.02f",
                name, this.addition4Price));
    }

    public double itemizeHamburger() {
        return this.price + addition1Price + addition2Price + addition3Price +
                addition4Price;
    }
}

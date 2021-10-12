package kiro.javaCore;

import java.util.Arrays;

public class Hamburger {
    protected static int NUMBER_OF_ADDITIONS;

    // Base Hamburger class
    private String name;
    private String meat;
    private String breadRollType;
    private double price;

    private int numberOfAdditions;
    private String[] additionNames;
    private double[] additionPrices;

    public Hamburger(String name, String meat, String breadRollType,
                     double price, int numberOfAdditions) {
        this.name = name;
        this.meat = meat;
        this.breadRollType = breadRollType;
        this.price = price;
        this.numberOfAdditions = numberOfAdditions > 0 ? numberOfAdditions : 4;
        NUMBER_OF_ADDITIONS = numberOfAdditions;

        additionNames = new String[this.numberOfAdditions];
        additionPrices = new double[this.numberOfAdditions];
        Arrays.fill(additionNames, "");
        Arrays.fill(additionPrices, 0.0);
    }

    public void addAddition(int additionNumber, String name, double price) {
        if (additionNumber < 1 || additionNumber > this.numberOfAdditions) {
            System.out.println(String.format("Only additions 1-%d are allowed for %s hamburger",
                    this.numberOfAdditions, this.name));
            return;
        }
        this.additionNames[additionNumber - 1] = name;
        this.additionPrices[additionNumber - 1] = price;
    }

    public void removeAddition(int additionNumber) {
        addAddition(additionNumber, "", 0.0);
    }

    public String getAdditionInfo(int additionNumber) {
        if (additionNumber < 1 || additionNumber > this.numberOfAdditions) {
            System.out.println(String.format("Only additions 1-%d are allowed for %s hamburger",
                    this.numberOfAdditions, this.name));
            return "";
        }
        if (!additionNames[additionNumber - 1].equals("")) {
            return String.format("Addition #%d: %-15s= $%.02f", additionNumber,
                    additionNames[additionNumber - 1], additionPrices[additionNumber - 1]);
        }
        return "Addition #" + additionNumber + ": not added";
    }

    public String getName() {
        return name;
    }

    public String getMeat() {
        return meat;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfAdditions() {
        return numberOfAdditions;
    }

    public void printTotal() {
        double totalPrice = this.price;
        System.out.println(String.format("%-28s= $%.2f", this.name + " hamburger", this.price));
        System.out.println("\tMeat: " + this.meat);
        System.out.println("\tBread roll: " + this.breadRollType);
        for (int i = 0; i < this.numberOfAdditions; i++) {
            totalPrice += additionPrices[i];
            System.out.println(getAdditionInfo(i+1));
        }
        System.out.println(String.format("%-28s= $%.2f", "Grand Total", totalPrice));
    }
}

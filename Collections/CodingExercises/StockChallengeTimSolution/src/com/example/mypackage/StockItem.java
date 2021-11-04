package com.example.mypackage;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int quantityInStock;
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableStock() {
        return quantityInStock - reserved;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0)
            this.quantityInStock = newQuantity;
    }

    public int reserveStock(int quantity) {
        if (quantity <= getAvailableStock()) {
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity) {
        if (quantity <= reserved) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int finaliseStock(int quantity) {
        if (quantity <= reserved) {
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 69;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int compareTo(StockItem obj) {
        if (this == obj)
            return 0;

        if (obj != null) {
            return this.name.compareTo(obj.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ", " + price + " ; stock: " +
                this.quantityInStock + "; reserved: " + this.reserved;
    }
}

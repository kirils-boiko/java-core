package com.example.mypackage;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int stock;
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.stock = 0;
    }

    public StockItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.stock = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getReserved() {
        return reserved;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    public boolean adjustStock(int quantity) {
        int newQuantity = this.stock + quantity;
        if (newQuantity >= 0) {
            this.stock = newQuantity;
            return true;
        }
        return false;
    }

    public boolean reserve(int quantity) {
        if (quantity > 0) {
            if (quantity <= this.stock - this.reserved) {
                reserved += quantity;
                return true;
            }
        }
        return false;
    }

    public boolean unreserve(int quantity) {
        if (quantity > 0) {
            if (quantity <= this.reserved) {
                reserved -= quantity;
                return true;
            }
        }
        return false;
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
        return this.name + ", " + price + " : " + this.stock;
    }
}

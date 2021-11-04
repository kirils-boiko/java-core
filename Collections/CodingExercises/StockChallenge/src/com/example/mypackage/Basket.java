package com.example.mypackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {

    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();    // doesn't need Comparator cause compareTo() for StockItem provided
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            if (item.reserve(quantity)) {
                list.put(item, inBasket + quantity);
                return inBasket + quantity;
            }
        }
        return -1;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            if (quantity > inBasket)
                return -1;
            if (item.unreserve(quantity)) {
                list.put(item, inBasket - quantity);
                return inBasket - quantity;
            }
        }
        return -1;
    }

    public Map<StockItem, Integer> getItems() {
        return Collections.unmodifiableMap(list);
    }

    public void checkOut() {
        // adjustStock and clear the Basket
        for (StockItem item : list.keySet()) {
            int reserved = item.getReserved();
            item.unreserve(reserved);
            item.adjustStock(-reserved);
        }

        System.out.println(this);
        list.clear();
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + " positions\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s += item.getKey() + "; " + item.getValue() + " purchased\n";
            totalCost += item.getValue() * item.getKey().getPrice();
        }
        return s + "Total Cost: " + totalCost;
    }
}

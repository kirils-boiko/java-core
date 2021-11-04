package com.example.mypackage;

import java.util.*;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // check if already have quantities of this item
            StockItem inStock = list.get(item.getName());
            // if there are already stocks on this item, adjust quantity
            if (inStock != null) {
                item.adjustStock(inStock.getAvailableStock());
            }

            list.put(item.getName(), item);
            return item.getAvailableStock();
        }
        return 0;
    }

    public int sellStock(String itemName, int quantity) {

        StockItem inStock = list.get(itemName);
        if (inStock != null && quantity > 0) {
            return inStock.finaliseStock(quantity);
        }
        return 0;
    }

    public int reserveStock(String itemName, int quantity) {
        StockItem inStock = list.get(itemName);

        if ((inStock != null) && (quantity > 0)) {
            return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String itemName, int quantity) {
        StockItem inStock = list.get(itemName);

        if ((inStock != null) && (quantity > 0)) {
            return inStock.unreserveStock(quantity);
        }
        return 0;
    }


    public StockItem get(String itemName) {
        return list.get(itemName);
    }

    public Map<String, Double> getPriceList() {
        // possible alternative to getItems() if you don't want elements
        // to be accessed for modification
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }

        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> getItems() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStockList\n";
        double totalCost = 0.0;

        Map<String, StockItem> tMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        tMap.putAll(list);

        for (Map.Entry<String, StockItem> item : tMap.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.getAvailableStock();

            s += "\t" + stockItem + "; Item Value = " + itemValue + ";\n";
            totalCost += itemValue;
        }

        return s + "Total Stock Value: " + totalCost;
    }
}

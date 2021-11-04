package com.example.mypackage;

import java.util.Map;

public class Main {

    private final static StockList stockList = new StockList();
    private final static Basket myBasket = new Basket("My Basket");

    public static void main(String[] args) {
	    StockItem temp = new StockItem("Bread", 0.99, 100);
        stockList.addStock(temp);

        temp = new StockItem("Cheesecake", 3.00, 10);
        stockList.addStock(temp);

        temp = new StockItem("Spooky Oreo", 1.49, 20);
        stockList.addStock(temp);

        temp = new StockItem("Oven-baked Barbeque", 1.50, 15);
        stockList.addStock(temp);
        stockList.addStock(temp);

        temp = new StockItem("Rucola", 1.00, 20);
        stockList.addStock(temp);

        temp = new StockItem("E-cake (NFT)", 19.00, 15);
        stockList.addStock(temp);

        temp = new StockItem("Strawberry", 6.00, 10);
        stockList.addStock(temp);

        System.out.println(stockList);

        sellItem(myBasket, "Oven-baked Barbeque", 10);
        sellItem(myBasket, "Rucola", 2);
        sellItem(myBasket, "Cheesecake", 7);
        sellItem(myBasket, "Cheesecake", 5);    // out of stock
        sellItem(myBasket, "Blueberry", 5);    // non-existent item

        System.out.println(myBasket);

        // print the priceList

        System.out.println("\nPrice List: ");
        for (Map.Entry<String, Double> item : stockList.getPriceList().entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }

    }

    public static int sellItem(Basket basket, String itemName, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            System.out.println("We don't sell " + itemName);
            return 0;
        }

        if (stockList.sellStock(itemName,quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }

        return 0;
    }
}

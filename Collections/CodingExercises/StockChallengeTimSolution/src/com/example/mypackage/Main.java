package com.example.mypackage;

/*

    Modify the program so that adding items to the shopping basket doesn't
    actually reduce the stock count but, instead, reserves the requested
    number of items.

    You will need to add a "reserved" field to the StockItem class to store the
    number of items reserved.

    Items can continue to be added to the basket, but it should not be possible to
    reserve more than the available stock of any item. An item's available stock
    is the stock count less the reserved amount.

    The stock count for each item is reduced when a basket is checked out, at which
    point all reserved items in the basket have their actual stock count reduced.

    Once checkout is complete, the contents of the basket are cleared.

    It should also be possible to "unreserve" items that were added to the basket
    by mistake.

    The program should prevent any attempt to unreserve more items than were
    reserved for a basket.

    Add code to Main that will unreserve items after they have been added to the basket,
    as well as unreserving items that have not been added to make sure that the code
    can cope with invalid requests like that.

    After checking out the baskets, display the full stock list and the contents of each
    basket that you created.

     */

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

        Basket customerBasket = new Basket("customer");
        sellItem(customerBasket, "Spooky Oreo", 2);
        sellItem(customerBasket, "E-cake (NFT)", 10);
        sellItem(customerBasket, "Strawberry", 7);
        removeItem(customerBasket, "Spooky Oreo", 1);
        System.out.println(customerBasket);

        removeItem(myBasket, "Rucola", 1);
        removeItem(myBasket, "Rucola", 1);
        removeItem(myBasket, "Rucola", 1);
        removeItem(myBasket, "Blueberry", 1);
        System.out.println(myBasket);


        System.out.println("\n\n========================================");
        System.out.println("Stock list before the checkout");
        System.out.println(stockList);

        checkOut(myBasket);
        checkOut(customerBasket);

        System.out.println("\n\n========================================");
        System.out.println("Stock list after the checkout");
        System.out.println(stockList);

    }

    public static int sellItem(Basket basket, String itemName, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            System.out.println("We don't sell " + itemName);
            return 0;
        }

        if (stockList.reserveStock(itemName,quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }

        return 0;
    }

    public static int removeItem(Basket basket, String itemName, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(itemName);
        if (stockItem == null) {
            System.out.println("We don't sell " + itemName);
            return 0;
        }

        if (basket.removeFromBasket(stockItem, quantity) != 0) {
            return stockList.unreserveStock(itemName, quantity);
        }

        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.getItems().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}


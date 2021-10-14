package kiro.javaCore;

import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>();

    //-----------------------------------
    // non-modifying methods

    public int getSize() {
        return groceryList.size();
    }

    public String getGroceryItem(int position) {
        if (position < 0 || position > groceryList.size() - 1) {
            System.out.println("error: item number is not in the list;");
            return null;
        }

        return groceryList.get(position);
    }

    public int findItem(String searchItem) {
        // boolean exists = groceryList.contains(searchItem);
        int position = groceryList.indexOf(searchItem);
        return position;
    }


    //-----------------------------------
    // modifying methods

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        if (position > -1 && position < groceryList.size()) {
            modifyGroceryItem(position, newItem);
        } else {
            System.out.println("error: item is not in the list;");
            return;
        }

        System.out.println("Grocery item \"" + currentItem +
                "\" has been modified");
    }


    public void removeGroceryItem(String currentItem) {
        int position = findItem(currentItem);
        if (position > -1 && position < groceryList.size()) {
            removeGroceryItem(position);
        } else {
            System.out.println("error: item is not in the list;");
            return;
        }

        System.out.println("Grocery item \"" + currentItem +
                "\" has been removed");
    }


    //-----------------------------------
    // hidden functionality methods (optional)

    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
    }

    private void removeGroceryItem(int position) {
        groceryList.remove(position);
    }

    //-----------------------------------
    // functionality for copying the ArrayList (getter)

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }
}

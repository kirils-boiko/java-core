package kiro.javaCore;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (item == null) {
            return false;
        }

        if (this.root == null) {
            // the list is empty
            root = item;
            return true;
        }

        ListItem currentItem = root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                // item is greater than currentItem, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // end of the list, enter here
                    item.setNext(null);
                    currentItem.setNext(item).setPrev(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                // item is less than currentItem, insert before currentItem
                if (currentItem.prev() != null) {
                    // not the root
                    currentItem.prev().setNext(item).setPrev(currentItem.prev());
                    currentItem.setPrev(item).setNext(currentItem);
                } else {
                    // node is the root
                    item.setPrev(null);
                    item.setNext(root).setPrev(item);
                    root = item;
                }
                return true;
            } else {
                System.out.println(item.getValue() + " is a duplicate, not added.");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null) {
            System.out.println("The item is null");
            return false;
        }

        if (root == null) {
            System.out.println("The list is empty");
            return false;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);

            if (comparison == 0) { // element found, remove it
                if (currentItem.prev() != null) { // not root
                    currentItem.prev().setNext(currentItem.next());
                } else { // currentItem is root
                    root = currentItem.next();
                }

                if (currentItem.next() != null) { // currentItem not the last element
                    currentItem.next().setPrev(currentItem.prev());
                }
                return true;
            } else if (comparison > 0) {    // we're past the point
                break;
            }

            currentItem = currentItem.next();
        }

        return false; // element not found
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
            return;
        }

        System.out.println("Linked List:");
        System.out.println("===================================");
        while (root != null) {
            System.out.println(root.getValue());
            root = root.next();
        }
        System.out.println("===================================\n");
    }

    public ListItem get(int index) {
        if (index < 0)
            return null;

        ListItem currentItem = this.root;
        while(index != 0 && currentItem != null) {
            currentItem = currentItem.next();
            index--;
        }

        return currentItem;
    }
}

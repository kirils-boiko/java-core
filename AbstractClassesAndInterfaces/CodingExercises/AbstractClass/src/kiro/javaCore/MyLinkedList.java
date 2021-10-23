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
                    currentItem.setNext(item).setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                // item is less than currentItem, insert before currentItem
                if (currentItem.previous() != null) {
                    // not the root
                    currentItem.previous().setNext(item).setPrevious(currentItem.previous());
                    currentItem.setPrevious(item).setNext(currentItem);
                } else {
                    // node is the root
                    item.setPrevious(null);
                    item.setNext(root).setPrevious(item);
                    root = item;
                }
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null) {
            return false;
        }

        if (root == null) {
            return false;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);

            if (comparison == 0) { // element found, remove it
                if (currentItem.previous() != null) { // not root
                    currentItem.previous().setNext(currentItem.next());
                } else { // currentItem is root
                    root = currentItem.next();
                }

                if (currentItem.next() != null) { // currentItem not the last element
                    currentItem.next().setPrevious(currentItem.previous());
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

        while (root != null) {
            System.out.println(root.getValue());
            root = root.next();
        }
    }

}


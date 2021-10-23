package kiro.javaCore;

public class CustomLinkedList {

    Item head;
    int size;

    public CustomLinkedList() {
        this.head = null;
        size = 0;
    }

    public CustomLinkedList(Item head) {
        this.head = head;
        size = 1;
    }

    public boolean add(Item item) {
        if (item == null)
            return false;

        if (head == null) {
            item.setPrev(null);
            item.setNext(null);
            head = item;
            size++;
            return true;
        }

        Item currentItem = head;
        while (true) {
            if (currentItem.compareTo(item) == 0) {
                return false;
            } else if (currentItem.compareTo(item) > 0) {
                currentItem.setPrev(item);
                size++;
                if (currentItem == head)
                    head = currentItem.prev();
                return true;
            }

            if (currentItem.next() != null) {
                currentItem = currentItem.next();
                continue;
            }
            currentItem.setNext(item);
            size++;
            return true;
        }
    }

    public boolean remove(Item item) {
        if (item == null || head == null)
            return false;       // not found or empty

        Item currentItem = head;
        while (currentItem != null) {
            if (currentItem.compareTo(item) == 0) {
                if (currentItem == head) {
                    head = currentItem.next();
                    currentItem.setPrev(null);
                } else if (currentItem.next() != null) {
                    currentItem.next().setPrev(currentItem.prev());
                } else if (currentItem.prev() != null) {
                    currentItem.prev().setNext(null);
                }
                size--;
                return true;
            }
            currentItem = currentItem.next();
        }
        return false;   // not found
    }

    public Item get(int index) {
        if (index < 0 || index > (size - 1) || head == null)
            return null;

        Item toReturn = head;
        while (index != 0) {
            toReturn = toReturn.next();
            index--;
        }
        return toReturn;
    }

    public Item getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }
}

package kiro.javaCore;

public abstract class Item {

    protected Object value;
    protected Item next;
    protected Item prev;

    public Item(Object value, Item next, Item prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    // methods for next and prev links
    public Item next() {
//        if (this.next != null) {
//            this.prev = next.prev;
//            this.value = next.value;
//            this.next = next.next;
//            return this;
//        } else {
//            return null;
//        }
        return this.next;
    }

    public void setNext(Item nextItem) {

        if (nextItem == null) {
            this.next = null;
            return;
        }

        if (this.next != null) {
            nextItem.next = this.next;
            this.next.prev = nextItem;
            nextItem.prev = this;
            this.next = nextItem;
        } else {
            nextItem.next = null;
            nextItem.prev = this;
            this.next = nextItem;
        }
    }

    public Item prev() {
//        if (this.prev != null) {
//            this.next = prev.next;
//            this.value = prev.value;
//            this.prev = prev.prev;
//            return this;
//        } else {
//            return null;
//        }
        return this.prev;
    }

    public void setPrev(Item prevItem) {
        if (prevItem == null) {
            this.prev = null;
            return;
        }

        if (this.prev != null) {
            this.prev.next = prevItem;
            prevItem.prev = this.prev;
            this.prev = prevItem;
            prevItem.next = this;
        } else {
            prevItem.prev = null;
            prevItem.next = this;
            this.prev = prevItem;
        }
    }

    public Object getValue() {
        return value;
    }

    public abstract int compareTo(Item item);
}


package kiro.javaCore;

public abstract class ListItem {

    protected ListItem rightLink = null;
    protected ListItem leftLink = null;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    ListItem next() {
        return this.rightLink;
    }

    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    ListItem prev() {
        return this.leftLink;
    }

    ListItem setPrev(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    abstract int compareTo(ListItem item);
}

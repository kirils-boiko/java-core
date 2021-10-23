package kiro.javaCore;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return super.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        super.rightLink = item;
        return super.rightLink;
    }

    @Override
    ListItem previous() {
        return super.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        super.leftLink = item;
        return super.leftLink;
    }

    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        }
        return -1;
    }
}


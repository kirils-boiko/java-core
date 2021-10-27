package kiro.javaCore;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        }
        return -1;
    }
}

package kiro.javaCore;

public class StringItem extends Item {

    public StringItem(String value) {
        super(value, null, null);
    }

    public StringItem(String value, StringItem next, StringItem prev) {
        super(value, next, prev);
    }

    @Override
    public int compareTo(Item item) {
        return ((String)super.value).compareTo((String)(item.value));
    }
}

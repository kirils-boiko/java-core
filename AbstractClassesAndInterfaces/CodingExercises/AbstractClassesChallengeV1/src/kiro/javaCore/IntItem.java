package kiro.javaCore;

public class IntItem extends Item {

    public IntItem(Integer value) {
        super(value, null, null);
    }

    public IntItem(Integer value, IntItem next, IntItem prev) {
        super(value, next, prev);
    }

    @Override
    public int compareTo(Item item) {
        if (item != null)
            return Integer.compare((int)(super.value), (int)(item.value));
        return 0;
    }
}

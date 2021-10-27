package kiro.javaCore;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arrayEven = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] arrayOdd = new int[]{1,2,3,4,5,6,7,8,9};

        ReverseArray.reverse(arrayEven);
        ReverseArray.reverse(arrayOdd);

    }
}

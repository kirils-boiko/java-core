package com.example.binsearch;

//  Custom binary search inspired by java.util.Collections

import java.util.Collection;
import java.util.List;

public class BinarySearch {

    public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            System.out.print('.');
            int mid = (low + high) / 2;
            int cmp = list.get(mid).compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                System.out.println();
                return mid;
            }
        }

        System.out.println();
        return -1;

    }
}

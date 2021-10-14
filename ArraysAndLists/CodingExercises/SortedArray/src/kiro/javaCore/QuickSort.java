package kiro.javaCore;

//Pseudo Code for recursive QuickSort function:
//low --> starting index, high --> ending index;
//
//quickSort(arr[], low, high) {
//    if (low < high) {
//        /*  pi is partitioning index, arr[pi] is now at right place */
//        pi = partition(arr, low, high);
//
//        quickSort(arr, low, pi - 1);        // before pi
//        quickSort(arr, pi + 1, high);       // after pi
//    }
//}

//CLRS method for partitioning
//Logic: take last element as pivot, place it at its correct position in
//sorted array, and place all smaller than pivot to the left, and all larger
//than pivot to the right;
//
//partition(arr[], low, high) {
//    // pivot(Element to be placed at right position)
//    pivot = arr[high];
//
//    i = (low - 1);  // index of smaller element and indicates the right
//                    // position of pivot found so far
//    for (j = low; j <= high -1; j++) {
//        // if current element is smaller than the pivot
//        if (arr[j] < pivot) {
//            i++;        // increment index of smaller element
//            swap arr[i] and arr[j];
//        }
//    }
//    swap arr[i+1] and arr[high];
//    return (i+1);
//}

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return (i+1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

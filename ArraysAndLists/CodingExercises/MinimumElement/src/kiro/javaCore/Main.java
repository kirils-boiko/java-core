package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
	    int n = MinimumElement.readInteger();
        int[] array = MinimumElement.readElements(n);
        int min = MinimumElement.findMin(array);
        System.out.println("Minimum value of array: " + min);
    }
}

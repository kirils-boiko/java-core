package com.example.mypackage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares.");
        System.out.println("There are " + cubes.size() + " cubes.");

        // Set Interface Bulk Operations

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements.");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements.");
        for (int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i));
            System.out.println(i + " is the cube of " + Math.round(Math.pow(i, 1.0/3.0)));
        }

        Set<String> words = new HashSet<>();
        String sentence = "Imprisoned for ten thousand years and banished from my own homeland";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for (String word : words) {
            System.out.println(word);
        }


        // Asymmetric difference
        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine: ");
        Set<String> natureTakeDivine = new HashSet<>(nature);
        natureTakeDivine.removeAll(divine);
       printSet(natureTakeDivine);

        System.out.println("divine - nature: ");
        Set<String> divineTakeNature = new HashSet<>(divine);
        divineTakeNature.removeAll(nature);
        printSet(divineTakeNature);

        // Symmetric difference
        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric difference: ");
        Set<String> symmetricDifference = new HashSet<>(unionTest);
        symmetricDifference.removeAll(intersectionTest);
        printSet(symmetricDifference);


        // Checking superset/subset relations
        if (nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature");
        }

        if (nature.containsAll(intersectionTest)) {
            System.out.println("intersection between nature and divine is a subset of nature");
        }

        if (divine.containsAll(nature)) {
            System.out.println("nature is a subset of divine");
        }

        if (divine.containsAll(intersectionTest)) {
            System.out.println("intersection between nature and divine is a subset of divine");
        }

        if (unionTest.containsAll(nature)) {
            System.out.println("nature is a subset of union of nature and divine");
        }

        if (unionTest.containsAll(divine)) {
            System.out.println("divine is a subset of union of nature and divine");
        }


    }

    private static <T> void printSet(Set<T> set) {
        System.out.print("\t");
        for (T element : set) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

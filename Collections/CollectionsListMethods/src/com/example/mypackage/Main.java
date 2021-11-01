package com.example.mypackage;


/* IMPORTANT NOTE:
    I CONSIDER THE EXAMPLE OF THEATRE GIVEN BY TIM BUCHALKA TO BE UNNECESSARILY
    COMPLICATED FOR THE ILLUSTRATION OF THE USE OF COLLECTIONS LIST METHODS;
    THEREFORE, I PROCEED WITH MY OWN CLASSES TO OFFER A BETTER ILLUSTRATION
    OF THE SAME CONCEPTS;
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Orc> legendaryOrcs = new ArrayList<>();
        legendaryOrcs.add(new Orc("Thrall", "Doomhammer"));
        legendaryOrcs.add(new Orc("Durotan", "Axe of Durotan"));
        legendaryOrcs.add(new Orc("Orgrim", "Doomhammer"));
        legendaryOrcs.add(new Orc("Garrosh", "Gorehowl"));

        List<Orc> legendaryOrcsShallowCopy = new ArrayList<>(legendaryOrcs);   // shallow copy
        legendaryOrcs.add(new Orc("Grommash", "Xal'atoh")); // adds only to legendaryOrcs
        Collections.sort(legendaryOrcsShallowCopy);  // still a separate list despite being shallow copy

        System.out.println("\nPrinting the list of legendary orcs:");
        printList(legendaryOrcs);
        System.out.println("\nPrinting the shallow copy of the list of legendary orcs:");
        printList(legendaryOrcsShallowCopy);

        // changes to both legendaryOrcs and legendaryOrcsShallowCopy element
        legendaryOrcs.get(2).setWeapon("Basic Hammer");     // Orgrim's weapon got changed
        System.out.println(legendaryOrcsShallowCopy.get(2).getWeapon());

        //================================================
        // Useful Collections List methods

        System.out.println();
        System.out.println("First legendary orc (alphabetically): " +
                Collections.min(legendaryOrcs).getName());
        System.out.println("Last legendary orc (alphabetically): " +
                Collections.max(legendaryOrcs).getName());

        System.out.println();
        Collections.shuffle(legendaryOrcs);
        System.out.println("Printing the shuffled list of legendary orcs:");
        printList(legendaryOrcs);

        System.out.println();
        Collections.reverse(legendaryOrcs);
        System.out.println("Printing the reversed shuffled list of legendary orcs:");
        printList(legendaryOrcs);

        System.out.println();
        Collections.sort(legendaryOrcs, Collections.reverseOrder());
        System.out.println("Printing the alphabetically reverse-sorted list of legendary orcs:");
        printList(legendaryOrcs);

        System.out.println();
        Collections.sort(legendaryOrcs);
        System.out.println("Printing the alphabetically sorted list of legendary orcs:");
        printList(legendaryOrcs);

        // custom defined bubble sort (not efficient)
        System.out.println();
        sortList(legendaryOrcsShallowCopy);
        System.out.println("Printing the alphabetically sorted shallow copy" +
                " of the list of legendary orcs:");
        printList(legendaryOrcsShallowCopy);

    }

    public static void printList(List<? extends Being> list) {
        System.out.println("=============================================");
        for (Being being : list) {
            System.out.println(being.getName());
        }
        System.out.println("=============================================");
    }

    public static <T extends Comparable<T>> void sortList(
            List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}

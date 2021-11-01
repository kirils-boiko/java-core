package com.example.mypackage;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        languages.put("Java", "Compiled, object-oriented, platform independent high-level language");
        languages.put("Python", "Interpreted, object-oriented, high-level programming language");
        languages.put("Algol", "Algorithmic language");
        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");

        System.out.println(languages.get("Java"));  // passing a key
        System.out.println("Old value for \"List\": " + languages.put("Lisp", "List Processor")); // overwrites the value for existing key
        System.out.println("New value for \"List\": " + languages.get("Lisp"));

        //==================================
        // adding (key,value) pair only if it's not already in the map
        if (languages.containsKey("C++")) {
            System.out.println("C++ is already in the map");
        } else {
            languages.put("C++", "Compiled general-purpose programming language");
            System.out.println("C++ added to the map successfully");
        }

        printMap(languages);

        //==================================
        // removing based on key and (key,value) pair
        languages.remove("Lisp");
        if (languages.remove("Python", "Snake")) {
            System.out.println("Python removed");
        } else {
            System.out.println("Python not removed, (key,value) pair not found");
        }

        printMap(languages);

        //==================================
        // replace() method replaces the value for a key only if it exists in the map
        if (languages.replace("Python", "Snake") != null)
            System.out.println("Value for \"Python\" has been replaced");
        else
            System.out.println("\"Python\" is not in the map");


        if (languages.replace("Scala",
                "Statically typed general-purpose programming language") != null)
            System.out.println("Value for \"Scala\" has been replaced");
        else
            System.out.println("\"Scala\" is not in the map");

        printMap(languages);

        //==================================
        // replacing value for a key based on (key, oldValue) pair
        if (languages.replace("Python", "Snake",
                "Interpreted, object-oriented, high-level programming language"))
            System.out.println("Value for \"Python\" has been replaced");
        else
            System.out.println("(key,value) pair is not in the map");

        if (languages.replace("Algol", "Favorite language",
                "family of Germanic languages"))
            System.out.println("Value for \"Algol\" has been replaced");
        else
            System.out.println("(key,value) pair is not in the map");

        printMap(languages);
    }

    public static <K, V> void printMap(Map<K,V> map) {
        System.out.println("\n========================================");
        for (K key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        System.out.println("========================================\n");
    }
}

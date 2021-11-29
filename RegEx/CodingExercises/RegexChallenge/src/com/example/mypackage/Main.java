package com.example.mypackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	    // Challenge 1 and 2: regex matching "I want a bike.";
        String challenge1 = "I want a bike.";
        String challenge1Regex = "^[A-Z]+\\s[a-z]+\\s[a-z]+\\s[a-z]+\\.$";
        System.out.println("Challenge 1&2: " + challenge1.matches(challenge1Regex));

        // Challenge 3: use matcher to check for matches "I want a bike." or "I want a ball."
        String challenge3 = "I want a ball.";
        String challenge3Regex = "^\\w+\\s\\w+\\s\\w+\\s\\w+\\.";
        Pattern challenge3Pattern = Pattern.compile(challenge3Regex);
        Matcher challenge3Matcher1 = challenge3Pattern.matcher(challenge3);
        Matcher challenge3Matcher2 = challenge3Pattern.matcher(challenge1);

        System.out.println("Challenge 3: " + challenge3Matcher1.matches());
        System.out.println("Challenge 3: " + challenge3Matcher2.matches());

        // Challenge 4: replace blanks
        String challenge4 = "Replace all blanks with underscores.";
        System.out.println("Challenge 4: " + challenge4.replaceAll("\\s", "_"));

        // Challenge 5: regex matching the string in entirety
        String challenge5 = "aaabbbccccddddeeeefffgggg";
        System.out.println("Challenge 5: " + challenge5.matches("\\w+"));
        System.out.println("Challenge 5: " + challenge5.matches("[a-g]+"));

        // Challenge 6: regex matching particular string in entirety
        String challenge6 = "aaabbbccccddddeeeefffgggg";
        String challenge6Regex = "^a{3}b{3}c{4}d{4}e{4}f{3}g{4}$";
        System.out.println("Challenge 6: " + challenge6.matches(challenge6Regex));

        // Challenge 7: regex to match string starting with letters, then period, then digits
        String challenge7 = "abcd.135";
        String challenge7Regex = "^[a-zA-z]+\\.\\d+$";
        System.out.println("Challenge 7: " + challenge7.matches(challenge7Regex));

        // Challenge 8: modify challenge 7 to use a group to print all the digits occurring
        //  in a string containing multiple occurrences of the pattern;
        String challenge8 = "abcd.135uvqz.7tzik.999";
        String challenge8Regex = "([a-zA-z]+)(\\.)(\\d+)";
        Pattern challenge8Pattern = Pattern.compile(challenge8Regex);
        Matcher challenge8Matcher = challenge8Pattern.matcher(challenge8);
        int count = 0;
        while (challenge8Matcher.find()) {
            count++;
            System.out.println("Challenge 8, occurrence " + count + ": " +
                    challenge8Matcher.group(3));
        }

        // Challenge 9: modified challenge 8 where matches are separated by tabs
        //  (last one is separated by newline);
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        String challenge9Regex = "([a-zA-z]+)(\\.)(\\d+)(\\t|\\n)";
        Pattern challenge9Pattern = Pattern.compile(challenge9Regex);
        Matcher challenge9Matcher = challenge9Pattern.matcher(challenge9);
        count = 0;
        while (challenge9Matcher.find()) {
            count++;
            System.out.println("Challenge 9, occurrence " + count + ": " +
                    challenge9Matcher.group(3));
        }

        // Challenge 10: challenge 9 but print indices of digits
        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";
        String challenge10Regex = "([a-zA-z]+)(\\.)(\\d+)(\\t|\\n)";
        Pattern challenge10Pattern = Pattern.compile(challenge10Regex);
        Matcher challenge10Matcher = challenge10Pattern.matcher(challenge10);
        count = 0;
        while (challenge10Matcher.find()) {
            count++;
            System.out.println("Challenge 10, occurrence " + count + ": [" +
                    challenge10Matcher.start(3) + "," +
                    (challenge10Matcher.end(3) - 1) + "]");
        }

        // Challenge 11: extract from curly braces
        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        String challenge11Regex = "\\{(.+?)\\},?";
        Pattern challenge11Pattern = Pattern.compile(challenge11Regex);
        Matcher challenge11Matcher = challenge11Pattern.matcher(challenge11);
        count = 0;
        while (challenge11Matcher.find()) {
            count++;
            System.out.println("Challenge 11, occurrence " + count + ": " +
                    challenge11Matcher.group(1));
        }

        // Challenge 12: regex matching 5-digit US zip code
        String challenge12 = "11111";
        String challenge12Regex = "^\\d{5}$";
        System.out.println("Challenge 12: " + challenge12.matches(challenge12Regex));

        // Challenge 13: regex matching 5-digit(plus optional dash and 4 digits) zip code
        String challenge13 = "11111-2222";
        String challenge13Regex = "^\\d{5}(\\-\\d{4})?$";
        System.out.println("Challenge 13: " + challenge12.matches(challenge13Regex));
        System.out.println("Challenge 13: " + challenge13.matches(challenge13Regex));
    }

}

package com.example.mypackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	    String string = "I am a string. Yes, I am.";
        System.out.println(string);

        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeeF12Ghisssiiikjdf99zabcDeeee";
        System.out.println(alphanumeric.replaceAll(".", "Y"));
        System.out.println(alphanumeric.replaceAll("^abcDeeee", "YYY"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("^abcDeee[a-zA-Z0-9]*"));
        System.out.println(alphanumeric.matches("^abcDeeee.*"));
        System.out.println(alphanumeric.matches(".*abcDeeee$"));
        System.out.println(alphanumeric.replaceAll("abcDeeee$", " THE END"));
        System.out.println(alphanumeric.replaceAll("[abi]", "X"));
        System.out.println(alphanumeric.replaceAll("[abi][bck]", "X"));


        String anotherAlphanumberic = "abdsAACddfjj93iiiiiijk8752kj";
        System.out.println("================================================");
        System.out.println(anotherAlphanumberic);
        System.out.println(anotherAlphanumberic.replaceAll("[^ij]","X"));   // replace except i or j
        System.out.println(anotherAlphanumberic.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(anotherAlphanumberic.replaceAll("(?i)[a-f3-8]", "X"));   //case-insensitive
        System.out.println(anotherAlphanumberic.replaceAll("\\d", "X"));    // replace digits
        System.out.println(anotherAlphanumberic.replaceAll("\\D", "X"));    // replace except digits

        String hasWhitespaces = "I have blanks and a\ttab, and also a newline\n";
        System.out.println("================================================");
        System.out.println(hasWhitespaces);
        System.out.println(hasWhitespaces.replaceAll("\\s", "X"));   // replace whitespaces
        System.out.println(hasWhitespaces.replaceAll("\\S", "X"));  // replace non-whitespaces
        System.out.println(hasWhitespaces.replaceAll("\\w", "X"));  // replace words
        System.out.println(hasWhitespaces.replaceAll("\\W", "X"));  // replace non-words
        System.out.println(hasWhitespaces.replaceAll("\\b", "X"));  // replace word boundaries

        // Quantifiers
        System.out.println("================================================");
        System.out.println(alphanumeric);
        System.out.println(alphanumeric.replaceAll("^abcDe{4}", "YYY"));
        System.out.println(alphanumeric.replaceAll("^abcDe+", "YYY"));
        System.out.println(alphanumeric.replaceAll("^abcDH*", "XXX"));
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(alphanumeric.replaceAll("s+i*k", "_QWERTY_"));

        // Pattern and Matchers
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>My Sub-Heading</h2>");
        htmlText.append("<p>My paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlText);

        System.out.println("================================================");
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + ": " +
                    matcher.start() + " to " + matcher.end());
        }


        // Printing the <h2> tags with text inside
        String h2GroupPattern = "(<h2>.+?</h2>)";    // use reluctant quantifier instead of greedy
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();
        count = 0;
        while(groupMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + ": " + groupMatcher.group(1));
        }

        // Printing just the text inside <h2> tags;
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";     // using reluctant quantifier
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);
        System.out.println(h2TextMatcher.matches());

        h2TextMatcher.reset();
        count = 0;
        while(h2TextMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + ": " + h2TextMatcher.group(2));
        }


        // Using And, Or & Not
        System.out.println("================================================");

        // Or
        System.out.println("harry".replaceAll("[Hh]arry", "Larry"));
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        // Not (using negative look ahead)
        String tvTest = "tstvtkt";
        String tNotVRegExp = "t(?!v)";  // t that is not followed by v (could be followed by no character at all)
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + ": " + tNotVMatcher.start() +
                    " to " + tNotVMatcher.end());
        }
        // t(?=v) positive look-ahead match


        // Validating a US phone number
        // Sample US phone number: (800) 123-4567
        String phoneTest1 = "(800) 123-4567";
        String phoneTest2 = "(800) 1234567";
        String phoneTest3 = "(80O) 123-4567";
        String phoneRegExp = "^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$";

        System.out.println(phoneTest1.matches(phoneRegExp));
        System.out.println(phoneTest2.matches(phoneRegExp));
        System.out.println(phoneTest3.matches(phoneRegExp));

    }


}

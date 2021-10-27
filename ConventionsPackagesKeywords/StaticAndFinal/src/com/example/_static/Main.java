package com.example._static;

public class Main {

    private static int multiplier = 7;

    public static void main(String[] args) {
        System.out.println("===============================");

//	    StaticTest firstInstance = new StaticTest("1st Instance");
//        System.out.println(firstInstance.getName() + " is instance number " +
//                StaticTest.getNumInstances());
//
//        StaticTest secondInstance = new StaticTest("2nd Instance");
//        System.out.println(secondInstance.getName() + " is instance number " +
//                StaticTest.getNumInstances());
//
//        StaticTest thirdInstance = new StaticTest("3rd Instance");
//        System.out.println(thirdInstance.getName() + " is instance number " +
//                StaticTest.getNumInstances());
//
//        System.out.println("The result of multiplying 3 by 7: " + multiply(3));

//        FinalTest one = new FinalTest("Terenas");
//        FinalTest two = new FinalTest("Arthas");
//        FinalTest three = new FinalTest("Ner'zhul");
//
//        System.out.println(one.getInstanceNumber());
//        System.out.println(two.getInstanceNumber());
//        System.out.println(three.getInstanceNumber());
//
//        int pw = 7337;
//        Password password = new Password(pw);
//        password.storePassword();
//        password.letMeIn(2000);
//        password.letMeIn(pw);

        System.out.println("Main method called");
        SIBTest sibTest = new SIBTest();
        sibTest.someMethod();
        System.out.println("Owner is " + SIBTest.owner);



        System.out.println("===============================");


    }

    public static int multiply(int number) {
        return number * multiplier;
    }
}

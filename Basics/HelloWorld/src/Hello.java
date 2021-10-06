public class Hello {

    public static void main(String[] args) {
        System.out.println("Hello Kiro");

        int myFirstNumber = 5;
        System.out.println(myFirstNumber);

        int mySecondNumber = 12;
        int myThirdNumber = myFirstNumber * 10;
        int myTotal = myFirstNumber + mySecondNumber + myThirdNumber;
        int myLastOne = 1000 - myTotal;
        System.out.println(myTotal);
        String stringFormat1 = String.format("myLastOne is %d", myLastOne);
        System.out.println(stringFormat1);
    }
}


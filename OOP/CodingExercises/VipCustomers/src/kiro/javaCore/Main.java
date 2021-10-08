package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        VipCustomer defaultCustomer = new VipCustomer();
        defaultCustomer.printInfo();

        VipCustomer noEmailCustomer = new VipCustomer("Brad Smith", 200.00);
        noEmailCustomer.printInfo();

        VipCustomer exemplarCustomer = new VipCustomer("Nice guy", 777.00, "niceguy@myBank.com");
        exemplarCustomer.printInfo();
    }

}

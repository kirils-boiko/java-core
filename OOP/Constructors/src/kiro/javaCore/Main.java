package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        System.out.println(account.getInfo());

        account.setAccountNumber("FR1420041010050500013M02606");
        account.setBalance(700_000.98);
        account.setCustomerName("Maximilien Robespierre");
        account.setEmail("robespierre@catacombs.fr");
        account.setPhoneNumber("+33599776688");

        System.out.println(account.getAccountNumber());
        System.out.println(account.getBalance());
        System.out.println(account.getCustomerName());
        System.out.println(account.getEmail());
        System.out.println(account.getPhoneNumber());

        System.out.println();

        account.depositFunds(92000.02);
        System.out.println(account.getBalance());
        account.depositFunds(-60000.47);
        System.out.println(account.getBalance());
        account.withdrawFunds(47000.90);
        System.out.println(account.getBalance());
        account.withdrawFunds(-7000);
        System.out.println(account.getBalance());
        account.withdrawFunds(1_000_000);
        System.out.println(account.getBalance());

        System.out.println();

        BankAccount example = new BankAccount("12345", 100.00, "Jordan Peterson",
                "peterson@learning.com", "7777777");
        System.out.println(example.getInfo());

        BankAccount kiroAccount = new BankAccount("Kiro", "kiro@github.com", "77777");
        System.out.println(kiroAccount.getInfo());
    }
}

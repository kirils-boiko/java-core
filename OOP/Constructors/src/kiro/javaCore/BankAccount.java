package kiro.javaCore;

public class BankAccount {

    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    // defining a constructor
    public BankAccount() {
        this("123456789", 0.0, "Default name",
                "Default email", "default phone");
        System.out.println("Empty constructor called");
    }

    public BankAccount(String accountNumber, double balance, String customerName,
                       String email, String phoneNumber) {
        System.out.println("Constructor with parameters called");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(String customerName, String email, String phoneNumber) {
        this("123456789", 0.0, customerName,
                email, phoneNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getInfo() {
        return "accountNumber: " + this.accountNumber + "\n" +
                "balance: " + this.balance + "\n" +
                "customerName: " + this.customerName + "\n" +
                "email: " + this.email + "\n" +
                "phoneNumber: " + this.phoneNumber + "\n";
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double amount) {
        if (amount <= 0) {
            System.out.println("error: cannot deposit non-positive amount");
            return;
        }
        balance += amount;
        System.out.println(amount + " deposited successfully. Current balance: " +
                this.balance);
    }

    public double withdrawFunds(double amount) {
        if (amount <= 0) {
            System.out.println("error: cannot withdraw non-positive amount");
            return -1;
        }
        if (amount > balance) {
            System.out.println("error: insufficient balance to withdraw the amount");
            return -1;
        }

        balance -= amount;
        System.out.println("Withdrawal of " + amount +
                " processed. Current balance: " + this.balance);
        return amount;
    }
}

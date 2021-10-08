package kiro.javaCore;

public class VipCustomer {

    private String customerName;
    private double creditLimit;
    private String customerEmail;

    public VipCustomer() {
        this("Default", 0.0, "default@myBank.com");
        System.out.println("Empty constructor called");
    }

    public VipCustomer(String customerName, double creditLimit) {
        this(customerName, creditLimit, "default@myBank.com");
        System.out.println("Constructor with 2 parameters called");
    }

    public VipCustomer(String customerName, double creditLimit, String customerEmail) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        if (creditLimit < 0)  {
            this.creditLimit = 0;
            System.out.println("error: creditLimit cannot be negative; set to default value");
        } else {
            this.creditLimit = creditLimit;
        }
        System.out.println("Constructor with 3 parameters called");
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void printInfo() {
        System.out.println(String.format("customerName: %s\n" +
                "customerEmail: %s\n" +
                "creditLimit: %.02f\n",
                this.customerName, this.customerEmail, this.creditLimit));
    }
}

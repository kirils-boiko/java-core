package com.example._static;

public class Password {

    // to prevent subclass from overriding the methods, declare them as final

    private static final int key = 748239842;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private final int encryptDecrypt(int password) {
        return password ^ key;
    }

    public final void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public final boolean letMeIn(int password) {
        if (encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Wrong password");
            return false;
        }
    }
}

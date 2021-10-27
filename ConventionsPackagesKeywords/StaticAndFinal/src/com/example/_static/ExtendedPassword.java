package com.example._static;

public class ExtendedPassword extends Password {

    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }


    // cannot override final methods
//    @Override
//    public void storePassword() {
//        // do your password hacking here
//    }
}

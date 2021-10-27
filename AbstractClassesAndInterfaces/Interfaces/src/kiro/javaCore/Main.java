package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        ITelephone myPhone = new DeskPhone(123456);
        myPhone.powerOn();
        myPhone.callPhone(123456);
        myPhone.answer();

        ITelephone myMobilePhone = new MobilePhone(24565);
        myMobilePhone.powerOn();
        myMobilePhone.callPhone(24565);
        myMobilePhone.answer();
    }
}

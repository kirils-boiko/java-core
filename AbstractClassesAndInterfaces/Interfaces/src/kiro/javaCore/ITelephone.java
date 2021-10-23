package kiro.javaCore;

public interface ITelephone {

    // not actually defining - only creating signatures that form the interface;
    // note: you don't really need access modifiers in the interface
    public void powerOn();
    public void dial(int phoneNumber);
    public void answer();
    public boolean callPhone(int phoneNumber);
    public boolean isRinging();

}

package kiro.javaCore;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public int getSize() {
        return contacts.size();
    }

    public Contact getContact(int position) {
        if (position > -1 && position < contacts.size()) {
            return contacts.get(position);
        }
        return null;
    }

    public void storeContact(String name, String phoneNumber) {
        if (!containsName(name)) {    // no existing name
            contacts.add(new Contact(name, phoneNumber));
        } else {
            System.out.println("error: contact already exists");
            return;
        }
    }

    public void modifyContactName(String name, String newName) {
        if (containsName(name)) {
            getContact(name).setName(newName);
        } else {
            System.out.println("error: cannot modify non-existing contact");
            return;
        }
    }

    public void modifyContactNumber(String name, String newPhoneNumber) {
        if (containsName(name)) {
            getContact(name).setPhoneNumber(newPhoneNumber);
        } else {
            System.out.println("error: cannot modify non-existing contact");
            return;
        }
    }

    public void removeContact(String name) {
        if (containsName(name)) {
            contacts.removeIf(obj -> obj.getName().equals(name));
        } else {
            System.out.println("error: cannot remove non-existing contact");
        }
    }

    public Contact findContact(String name) {
        return getContact(name);
    }

    //-----------------------------------
    // Hidden functionality methods

    private boolean containsName(String name) {
        return contacts.stream().filter(obj -> obj.getName().equals(name)).findFirst().isPresent();
    }

    private Contact getContact(String name) {
        if (containsName(name)) {
            return contacts.stream().filter(obj -> obj.getName().equals(name)).findFirst().get();
        }
        return null;
    }

}

package kiro.javaCore;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) > -1) {
            System.out.println("error: contact " + contact.getName() +
                    " already exists;");
            return false;
        }
        myContacts.add(contact);
        System.out.println("Contact " + contact.getName() +
                " added successfully");
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact.getName());
        if (position < 0) {
            System.out.println("error: contact " + oldContact.getName() +
                    " does not exist;");
            return false;       // contact does not exist
        }

        if (findContact(newContact.getName()) > -1) {
            System.out.println("error: contact " + newContact.getName() +
                    " already exists;");
            return false;
        }

        myContacts.set(position, newContact);
        System.out.println("Contact " + oldContact.getName() +
                " updated successfully");
        return true;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact.getName());
        if (position < 0) {
            System.out.println("error: contact " + contact.getName() +
                    " does not exist;");
            return false;       // contact does not exist
        }

        myContacts.remove(position);
        System.out.println("Contact " + contact.getName() +
                " removed successfully");
        return true;
    }


    public Contact queryContact(String name) {
       int position = findContact(name);
        if (position < 0)
           return null;         // contact does not exist

        return myContacts.get(position);
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact toPrint = myContacts.get(i);
            System.out.println((i+1) + ". " + toPrint.getName() + " -> " +
                    toPrint.getPhoneNumber());
        }
    }

    //----------------------------------------
    // Hidden functionality

    private int findContact(Contact contact) {
//        for (int i = 0; i < myContacts.size(); i++) {
//            if (myContacts.get(i).getName().equals(contact.getName())) {
//                return i;       // contact found, returning index
//            }
//        }
//        return -1;

        // alternatively:
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;       // contact found, returning index
            }
        }
        return -1;
    }
}

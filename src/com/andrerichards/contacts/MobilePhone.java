package com.andrerichards.contacts;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists");
            return false;
        }

        myContacts.add(contact);
        System.out.println("New contact added:\n -> Name: " + contact.getName() +
                "\n -> Phone: " + contact.getPhoneNumber());
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println("Contact \"" + oldContact.getName() + "\" not found");
            return false;
        } else if(findContact(newContact.getName()) != -1) {
            System.out.println("Contact \"" + oldContact.getName() + "\" already exists");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println("Contact \"" + oldContact.getName() + "\" updated to:" +
                "\n -> Name: " + newContact.getName() +
                "\n -> Phone Number: " + newContact.getPhoneNumber());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println("Contact \"" + contact.getName() + "\" not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println("Contact \"" + contact.getName() + "\" removed");
        return true;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String contactName) {
        int foundPosition = findContact(contactName);
        if (foundPosition >= 0) {
            return this.myContacts.get(foundPosition);
        }
        return null;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public void printContacts() {
        if (this.myContacts.size() < 1) {
            System.out.println("Contact List is empty");
            return;
        }
        System.out.println("Contact List:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println(" " + (i + 1) + ". " +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}

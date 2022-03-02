package com.andrerichards.contacts;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("9175550011");

    public static void main(String[] args) {
        boolean quit = false;
        bootUpPhone();
        printMenuActions();
        while (!quit) {
            System.out.println("\n>>> Choose your action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printMenuActions();
                    break;

                default:
                    System.out.println("Invalid Entry");
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);

        if (!mobilePhone.addNewContact(newContact)) {
            System.out.println("Contact \"" + name + "\" already on file");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact oldContact = mobilePhone.queryContact(name);
        if (oldContact == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = new Contact(newName, newNumber);
        if (!mobilePhone.updateContact(oldContact, newContact)) {
            System.out.println("Contact update error");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if (contact == null) {
            System.out.println("Contact not found");
            return;
        }

        if (mobilePhone.removeContact(contact)) {
            System.out.println("Contact deleted");
        } else System.out.println("Contact deletion error");
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if (contact == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + contact.getName() + "\nPhone Number: " + contact.getPhoneNumber());
    }

    private static void bootUpPhone() {
        System.out.println("Phone booting up...");
    }

    private static void printMenuActions() {
        System.out.println("\nAvailable actions:");
        System.out.println("0  - To shutdown\n" +
            "1  - To print contacts\n" +
            "2  - To add a new contact\n" +
            "3  - To update existing an existing contact\n" +
            "4  - To remove an existing contact\n" +
            "5  - Query if an existing contact exists\n" +
            "6  - To print a list of available actions.");
    }
}

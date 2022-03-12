package com.andrerichards.bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Bank of America");
        bank.addBranch("Dunwoody");
        bank.addCustomer("Dunwoody", "Joey Lee", 190.40);
        bank.addCustomer("Dunwoody", "Rei Poneua", 890.66);
        bank.addCustomer("Dunwoody", "Mofa Jimas", 35.44);

        bank.addBranch("Riverdale");
        bank.addCustomer("Riverdale", "Iseua Ladkam", 6451.61);
        bank.addCustomer("Riverdale", "Ponra Quamfih", 451.51);
        bank.addCustomer("Riverdale", "Hadakin Kasaej", 78946.41);

        bank.addCustomerTransaction("Dunwoody", "Joey Lee", 846.51);
        bank.addCustomerTransaction("Riverdale", "Ponra Quamfih", -46.51);

        bank.listCustomers("Riverdale", true);
        bank.listCustomers("Dunwoody", true);
    }
}

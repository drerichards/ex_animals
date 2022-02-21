package com.andrerichards;

public class Dog extends Animal {
    private String coat;
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;

    public Dog(String name, int brain, int body, int size, int weight) {
        // set variables as default to parent class for copies of Dog class
        super(name, 1, 1, size, weight);
    }
}

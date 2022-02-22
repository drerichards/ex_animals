package com.andrerichards.animals;

public class Dog extends Animal {
    private String coat;
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;

    public Dog(String name, int size, int weight, String coat, int eyes, int legs, int tail, int teeth) {
        // send variables as default to parent super class for new copies of Dog class
        super(name, 1, 1, size, weight);
        this.coat = coat;
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
    }

    private void chewFood() {
        System.out.println("Dog.chewFood() called");
    }

    private void stopMovement() {
        System.out.println("Dog.stop() called");
        super.move(0);
    }


    public void walk(int speed) {
        System.out.println("Dog.walk() called");
        // call with "super" to call default method without overrides
        super.move(speed);
    }

    public void run(int speed) {
        System.out.println("Dog.run() called");
        // call without "super" to get default method with overrides
        this.move(speed);
    }

    @Override // inherits super props and allows adding more within this context
    public void eat() {
        System.out.println("Override - " + this.getName() + ".chewFood() called");
        chewFood();
        super.eat();
    }

    @Override
    public void move(int speed) {
        System.out.println("Override - " + this.getName() + ".move() called");
        super.move(speed);
        stopMovement();
    }
}

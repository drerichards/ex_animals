package com.andrerichards;

public class Main {
    public static void main(String[] args) {
//        Animal animal = new Animal("Animal", 1,1,5,50);
        Dog dog = new Dog("Pug", 3, 20, "short", 2, 4, 1, 28);
        dog.eat();
        System.out.println("");
        dog.walk(4);
        System.out.println("");
        dog.run(10);
    }
}

package com.andrerichards.animals;

import com.andrerichards.animals.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Pug", 3, 20, "short", 2, 4, 1, 28);
        dog.eat();
        dog.walk(4);
        dog.run(10);
    }
}

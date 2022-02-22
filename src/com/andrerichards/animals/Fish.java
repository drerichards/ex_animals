package com.andrerichards.animals;

public class Fish extends Animal {
    private int eyes;
    private int gills;
    private int fins;

    public Fish(String name, int brain, int body, int size, int weight, int eyes, int gills, int fins) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.gills = gills;
        this.fins = fins;
    }

    private void rest() {

    }

    private void moveSideFins() {

    }

    private void moveBackFin() {

    }

    private void swim(int speed) {
        moveSideFins();
        moveBackFin();
        super.move(speed  );
    }
}
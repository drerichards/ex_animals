package com.andrerichards.vehicle;

public class Car extends Vehicle {
    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;
    private int currentGear;

    public Car(String name, String size, int wheels, int doors, int gears, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeCurrentGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.changeCurrentGear changed to " + currentGear + " gear.");
    }

    public void changeCurrentVelocity(int currentVelocity, int currentHeading) {
        System.out.println("Car.changeCurrentVelocity called");
        super.move(currentVelocity, currentHeading);
    }
}

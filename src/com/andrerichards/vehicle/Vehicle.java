package com.andrerichards.vehicle;

public class Vehicle {
    private String name;
    private String size;
    private int currentVelocity;
    private int currentHeading;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;
        this.currentVelocity = 0;
        this.currentHeading = 0;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentHeading() {
        return currentHeading;
    }

    public void steer(int heading) {
        this.currentHeading += heading;
        System.out.println("Vehicle.steering at " + currentHeading + " degrees");
        System.out.println();
    }

    public void move(int velocity, int heading) {
        currentVelocity = velocity;
        currentHeading = heading;
        System.out.println("Vehicle.moving at " + currentVelocity + "mph to " + currentHeading + " degrees");
        System.out.println();
    }
}

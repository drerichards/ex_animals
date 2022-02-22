package com.andrerichards.rectangle;

public class Rectangle extends Shape {
    // constructor chaining example
    private int width;
    private int height;

    // 1st constructor
    public Rectangle(int x, int y) {
        this(x, y, 0, 0); // calls 2nd constructor
    }

    public int getHeight() {
        return height;
    }

    // 2nd constructor
    public Rectangle(int x, int y, int width, int height) {
        // initialize all variables
        // calls constructor from parent (Shape)
        super(x, y);
        this.width = width;
        this.height = height;
    }
}

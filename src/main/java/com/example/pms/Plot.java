package com.example.pms;

/* Class: CMSC203
        * Instructor:
        * Description: (Give a brief description for each Class)
        * Due: MM/DD/YYYY
        * Platform/compiler: Intellij Idea
        * I pledge that I have completed the programming
        * assignment independently. I have not copied the code
        * from a student or any source. I have not given my code
        * to any student.
        Print your Name here:
*/

public class Plot {
    // Private Fields
    private int x;
    private int y;
    private int width;
    private int depth;

    // Default constructor
    public Plot() {
        this(0, 0, 1, 1); // Default width and depth set to 1
    }

    // Parameterized constructor
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    // Copy constructor
    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    // Determines if the given plot instance is overlapped by the current plot.
    public boolean overlaps(Plot plot) {
        return this.x < plot.x + plot.width &&
                this.x + this.width > plot.x &&
                this.y < plot.y + plot.depth &&
                this.y + this.depth > plot.y;
    }

    //Determines if the given plot is encompassed by (is contained by) this plot.
    public boolean encompasses(Plot plot) {
        return (plot.x >= this.x &&
                plot.x + plot.width <= this.x + this.width &&
                plot.y >= this.y &&
                plot.y + plot.depth <= this.y + this.depth);
    }

    // Setters and Getters
    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    // toString method
    @Override
    public String toString() {
        System.out.println(x + "," + y + "," + width + "," + depth);
        return x + "," + y + "," + width + "," + depth;
    }
}

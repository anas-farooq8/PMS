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

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Default constructor
    public Property() {
        this("", "", 0.0, "");
    }

    // Constructor with basic property information
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
    }

    // Constructor with detailed property and plot information
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    // Copy constructor
    public Property(Property otherProperty) {
        this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount, otherProperty.owner,
                otherProperty.plot.getX(), otherProperty.plot.getY(), otherProperty.plot.getWidth(), otherProperty.plot.getDepth());
    }

    // Getter methods
    public Plot getPlot() {
        return plot;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%.2f", propertyName, city, owner, rentAmount);
    }
}

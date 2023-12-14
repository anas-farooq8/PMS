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

public class ManagementCompany {
    // Constants Fields
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    // Private Fields
    private String name;
    private String taxID;
    private double mgmFee;
    private Plot plot;
    private Property[] properties;

    // Default constructor
    public ManagementCompany() {
        this("", "", 0.0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    // Parameterized constructors
    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
    }

    // Copy constructor
    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFee,
                otherCompany.plot.getX(), otherCompany.plot.getY(),
                otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
        // Copy properties
        this.properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < otherCompany.properties.length; i++) {
            if (otherCompany.properties[i] != null) {
                this.properties[i] = new Property(otherCompany.properties[i]);
            }
        }
    }


    // Getters and setters
    public String getName() {
        return name;
    }

    public Plot getPlot() {
        return plot;
    }
    public String getTaxID() {return taxID;}

    public double getManagementFee() {
        return mgmFee;
    }

    public void setManagementFee(Double mgFee) {
        this.mgmFee = mgFee;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setTaxID(String newTaxID) {
        this.taxID = newTaxID;
    }

    public int addProperty(Property property) {
        if (property == null) return -2;
        if (this.isPropertiesFull()) return -1;
        if (!this.plot.encompasses(property.getPlot())) return -3;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) return -4;
            if (properties[i] == null) {
                properties[i] = new Property(property);
                return i;
            }
        }
        return -1;
    }

    // Calculates the max rent index
    public int maxRentPropertyIndex() {
        int maxIndex = -1;
        double maxRent = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null && properties[i].getRentAmount() > maxRent) {
                maxRent = properties[i].getRentAmount();
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Gives the Property Object that has the maxRent rate
    public Property getHighestRentProperty() {
        int index = maxRentPropertyIndex();
        return (index != -1) ? properties[index] : null;
    }


    // Calculates the Total rent
    public double getTotalRent() {
        double total = 0;
        for (Property prop : properties) {
            if (prop != null) total += prop.getRentAmount();
        }
        return total;
    }

    // Checks if the Property is full
    public boolean isPropertiesFull() {
        for (Property property : properties) {
            if (property == null) return false;
        }
        return true;
    }

    // Returns the count of total properties
    public int getPropertiesCount() {
        int count = 0;
        for (Property property : properties) {
            if (property != null) count++;
        }
        return count;
    }

    // removes the last added property
    public void removeLastProperty() {
        int lastIndex = -1;

        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i] != null) {
                lastIndex = i;
                break;
            }
        }

        if (lastIndex != -1) {
            // Found the last non-null property
            properties[lastIndex] = null;
        }
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Management Company Name: ").append(name)
                .append("\nTax ID: ").append(taxID)
                .append("\nManagement Fee: ").append(mgmFee)
                .append("\n--- Properties List ---\n");

        for (Property property : properties) {
            if (property != null) {
                sb.append(property.toString()).append("\n");
            }
        }
        return sb.toString();
    }

}


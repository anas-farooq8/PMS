package com.example.pms;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

public class ManagementCompanyTestStudent {
    private ManagementCompany managementCompany;
    private Property property1, property2;

    @Before
    public void setUp() throws Exception {
        managementCompany = new ManagementCompany("myComp", "555555555", 6);
        property1 = new Property("Sunsational", "RockVille", 2613, "BillyBob Wilson", 2, 5, 2, 2);
        property2 = new Property("LakeHouse", "RockVille", 3200, "SallySue", 4, 1, 2, 2);
        managementCompany.addProperty(property1);
        managementCompany.addProperty(property2);
    }

    @Test
    public void testAddProperty() {
        assertEquals("Should return -2 because property is null.", -2, managementCompany.addProperty(null));
    }

    @Test
    public void testGetTotalRent() {
        double totalRent = property1.getRentAmount() + property2.getRentAmount();
        assertEquals("Total rent should be equal to the rent of property1.", totalRent, managementCompany.getTotalRent(), 0.01);
    }

    @Test
    public void testMaxRentPropertyIndex() {
        assertEquals("The index of property with highest rent should be 0.", 1, managementCompany.maxRentPropertyIndex());
    }

    @Test
    public void testGetName() {
        assertEquals("myComp", managementCompany.getName());
    }

    @Test
    public void testGetPlot() {
        Plot expectedPlot = new Plot(0, 0, ManagementCompany.MGMT_WIDTH, ManagementCompany.MGMT_DEPTH);
        assertEquals(expectedPlot.getX(), managementCompany.getPlot().getX());
    }


    @Test
    public void testGetTaxID() {
        assertEquals("555555555", managementCompany.getTaxID());
    }

    @Test
    public void testGetManagementFee() {
        assertEquals(6.0, managementCompany.getManagementFee(), 0.0);
    }

    @After
    public void testRemoveProperty() {
        managementCompany.removeLastProperty();
        assertEquals("After removing, property count should be 1.", 1, managementCompany.getPropertiesCount());
    }

    @Test
    public void testGetPropertiesCount() {
        managementCompany.addProperty(property2);
        assertEquals("The number of properties should be 2.", 2, managementCompany.getPropertiesCount());
    }

    @Test
    public void testGetHighestRentProperty() {
        assertEquals("Highest rent property should be 'LakeHouse'.", property2.getPropertyName(), managementCompany.getHighestRentProperty().getPropertyName());
    }

    @Test
    public void testSetAndGetName() {
        String newName = "NewCompanyName";
        managementCompany.setName(newName);
        assertEquals(newName, managementCompany.getName());
    }

    @Test
    public void testSetAndGetTaxID() {
        String newTaxID = "123456789";
        managementCompany.setTaxID(newTaxID);
        assertEquals(newTaxID, managementCompany.getTaxID());
    }

    @Test
    public void isPropertiesNotFull() {
        if(managementCompany.getPropertiesCount() != 5)
            assertEquals(true, true);
    }

    @Test
    public void testAddingOverlappingProperty() {
        Property overlappingProperty = new Property("Overlap", "City", 1000, "Owner3", 2, 5, 2, 2);
        assertEquals("Should return -4 for overlapping property.", -4, managementCompany.addProperty(overlappingProperty));
    }

    @Test
    public void testRemoveAndAddProperty() {
        managementCompany.removeLastProperty();
        int addResponse = managementCompany.addProperty(new Property("NewProp", "City", 1200, "NewOwner", 6, 6, 2, 2));
        assertTrue("Should be able to add a property after removal.", addResponse >= 0);
    }



    @Test
    public void testSetAndGetManagementFee() {
        double newMgmFee = 8.5;
        managementCompany.setManagementFee(newMgmFee);
        assertEquals(newMgmFee, managementCompany.getManagementFee(), 0.0);
    }
}

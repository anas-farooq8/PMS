package com.example.pms;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PropertyTestStudent {
    private Property property;

    @Before
    public void setUp() {
        property = new Property("SeaView", "OceanCity", 5000.0, "Alice", 5, 5, 2, 2);
    }

    @Test
    public void testGetPropertyName() {
        assertEquals("SeaView", property.getPropertyName());
    }

    @Test
    public void testGetCity() {
        assertEquals("OceanCity", property.getCity());
    }

    @Test
    public void testGetRentAmount() {
        assertEquals("Rent amount should be 5000.0.", 5000.0, property.getRentAmount(), 0.0);
    }

    @Test
    public void testGetPlot() {
        assertEquals(5, property.getPlot().getX());
        assertEquals(5, property.getPlot().getY());
        assertEquals(2, property.getPlot().getWidth());
        assertEquals(2, property.getPlot().getDepth());
    }

    @Test
    public void testGetOwner() {
        assertEquals("Alice", property.getOwner());
    }

    @Test
    public void testToString() {
        String expectedString = "SeaView,OceanCity,Alice,5000.00";
        assertEquals("toString output is not as expected.", expectedString, property.toString());
    }
}

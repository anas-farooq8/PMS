package com.example.pms;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PlotTestStudent {
    private Plot plot1;
    private Plot plot2;
    private Plot plot3;

    @Before
    public void setUp() {
        plot1 = new Plot(2, 2, 6, 6);
        plot2 = new Plot(3, 4, 4, 3);
        plot3 = new Plot(2, 8, 2, 2);
    }

    @Test
    public void testGetX() {
        assertEquals(2, plot1.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(2, plot1.getY());
    }

    @Test
    public void testGetWidth() {
        assertEquals(6, plot1.getWidth());
    }

    @Test
    public void testGetDepth() {
        assertEquals(6, plot1.getDepth());
    }

    @Test
    public void testOverlaps() {
        assertTrue("plot2 is inside plot1, therefore it overlaps.", plot1.overlaps(plot2));
        assertFalse("plot3 should not overlap plot1.", plot1.overlaps(plot3));
    }

    @Test
    public void testEncompasses() {
        assertTrue("plot1 should encompass plot2.", plot1.encompasses(plot2));
        assertFalse("plot1 should not encompass plot3.", plot1.encompasses(plot3));
    }

    @Test
    public void testToString() {
        String expected = "2,2,6,6";
        Assert.assertEquals("toString should return the string in the format x,y,width,depth.", plot1.toString(), expected);
    }
}

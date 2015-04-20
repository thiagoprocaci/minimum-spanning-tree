package com.tbp.minspanningtree.graph;


import com.tbp.minspanningtree.graph.Edge;
import org.junit.Test;
import static org.junit.Assert.*;

public class EdgeTest {

    @Test
    public void testOther() {
        Edge edge = new Edge(1, 2, 2d);
        assertEquals(1, edge.other(2));
        assertEquals(2, edge.other(1));
        try {
            edge.other(3);
            fail("this code should not be executed");
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }

    }

    @Test
    public void testEither() {
        Edge edge = new Edge(1, 2, 2d);
        assertEquals(1, edge.either());
    }

    @Test
    public void testGetWeight() {
        double weight = 6d;
        Edge edge = new Edge(1, 2, weight);
        assertEquals(weight, edge.weight(), 0.001);
    }


    @Test
    public void testCompareTo() {
        Edge edge1 = new Edge(1, 2, 1d);
        Edge edge2 = new Edge(1, 2, 2d);
        assertEquals(1, edge2.compareTo(edge1));
        assertEquals(-1, edge1.compareTo(edge2));
        assertEquals(0, edge1.compareTo(edge1));
        assertEquals(0, edge2.compareTo(edge2));
    }

    @Test
    public void testConstructor() {
        try {
            new Edge(-1, 1, 1d);
            fail("this code should not be executed");
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
        try {
            new Edge(1, -1, 1d);
            fail("this code should not be executed");
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
        try {
            new Edge(1, 1, Double.NaN);
            fail("this code should not be executed");
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
        try {
            Edge edge = new Edge(1, 1, 1d);
            assertNotNull(edge);
        } catch (IllegalArgumentException e) {
            fail("this code should not be executed");

        }

    }



}

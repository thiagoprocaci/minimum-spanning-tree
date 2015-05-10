package com.tbp.graph;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeWeightedGraphTest {

    private EdgeWeightedGraph graph;

    @Before
    public void doBefore() {
        graph = new EdgeWeightedGraph(3);
    }

    @Test
    public void testInitialization() {
        assertEquals(3, graph.V());
        assertEquals(0, graph.E());
        assertNotNull(graph.adj(0));
        assertNotNull(graph.adj(1));
        assertNotNull(graph.adj(2));

        try {
            assertNotNull(graph.adj(3));
            fail("This code should not be executed");
        } catch (IndexOutOfBoundsException e) {
            assertNotNull(e);
        }
    }


    @Test
    public void testAddEdge() {
        Edge edge = new Edge(0,1,1d);
        graph.addEdge(edge);
        assertEquals(1, graph.E());

        Edge[] edges = new Edge[graph.E()];
        int index = 0;
        for(Edge e: graph.adj(0)) {
            edges[index] = e;
            index++;
        }
        assertEquals(1, edges.length);
        assertEquals(edge.weight(), edges[0].weight(), 0.01);
        assertEquals(edge.either(), edges[0].either());
        assertEquals(edge.other(edge.either()), edges[0].other(edges[0].either()));

        Edge edge2 = new Edge(0,2,2d);
        graph.addEdge(edge2);
        assertEquals(2, graph.E());

        edges = new Edge[graph.E()];
        index = 0;
        for(Edge e: graph.adj(0)) {
            edges[index] = e;
            index++;
        }
        assertEquals(2, edges.length);
        assertEquals(edge2.weight(), edges[0].weight(), 0.01);
        assertEquals(edge2.either(), edges[0].either());
        assertEquals(edge2.other(edge2.either()), edges[0].other(edges[0].either()));

        assertEquals(edge.weight(), edges[1].weight(), 0.01);
        assertEquals(edge.either(), edges[1].either());
        assertEquals(edge.other(edge.either()), edges[1].other(edges[1].either()));

    }



}

package com.tbp.search;


import com.tbp.graph.Edge;
import com.tbp.graph.EdgeWeightedGraph;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepthFirstSearchTest {

    @Test
    public void testDFS() {
        EdgeWeightedGraph graph  = new EdgeWeightedGraph(7);
        graph.addEdge(new Edge(0,1,1d));
        graph.addEdge(new Edge(3,4,9d));
        graph.addEdge(new Edge(4,5,7d));
        graph.addEdge(new Edge(0,3,4d));
        graph.addEdge(new Edge(1,4,2d));
        graph.addEdge(new Edge(2,5,5d));
        graph.addEdge(new Edge(3,1,6d));
        graph.addEdge(new Edge(4,2,4d));
        graph.addEdge(new Edge(0,4,3d));

        assertEquals(7, graph.V());
        assertEquals(9, graph.E());


        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        for(int v = 0; v < graph.V(); v++ ) {
            if(v != (graph.V() - 1)) {
                Assert.assertTrue(depthFirstSearch.marked(v));
            } else {
                Assert.assertFalse(depthFirstSearch.marked(v));
            }
        }

    }
}

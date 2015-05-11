package com.tbp.minspanningtree;


import com.tbp.minspanningtree.clustering.Clustering;
import com.tbp.graph.Edge;
import com.tbp.graph.EdgeWeightedGraph;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class ClusteringTest {

    private Clustering clustering;


    @Test
    public void testClustering() {
        EdgeWeightedGraph graph  = new EdgeWeightedGraph(6);
        graph.addEdge(new Edge(0,1,1d));
        graph.addEdge(new Edge(3,4,9d));
        graph.addEdge(new Edge(4,5,7d));
        graph.addEdge(new Edge(0,3,4d));
        graph.addEdge(new Edge(1,4,2d));
        graph.addEdge(new Edge(2,5,5d));
        graph.addEdge(new Edge(3,1,6d));
        graph.addEdge(new Edge(4,2,4d));
        graph.addEdge(new Edge(0,4,3d));

        assertEquals(6, graph.V());
        assertEquals(9, graph.E());

        clustering = new Clustering(graph, 2);
        assertEquals(clustering.getCluster(0), clustering.getCluster(1));
        assertEquals(clustering.getCluster(0), clustering.getCluster(2));
        assertEquals(clustering.getCluster(0), clustering.getCluster(3));
        assertEquals(clustering.getCluster(0), clustering.getCluster(4));
        assertNotSame(clustering.getCluster(0), clustering.getCluster(5));

    }
}

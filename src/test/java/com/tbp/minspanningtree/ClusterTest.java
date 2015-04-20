package com.tbp.minspanningtree;


import com.tbp.minspanningtree.clustering.Cluster;
import com.tbp.minspanningtree.graph.Edge;
import com.tbp.minspanningtree.graph.EdgeWeightedGraph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClusterTest {

    private Cluster cluster;

    @Before
    public void doBefore() {
        cluster = new Cluster();
    }

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

        cluster.createClusters(graph, 2);
        cluster.print();


    }
}

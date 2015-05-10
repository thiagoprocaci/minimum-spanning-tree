package com.tbp.minspanningtree;


import com.tbp.graph.Edge;
import com.tbp.graph.EdgeWeightedGraph;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KruskalMSTTest {

    private KruskalMST kruskalQuickUnion;
    private KruskalMST kruskalQuickFind;

    @Before
    public void doBefore() {
        kruskalQuickFind = new KruskalQuickFind();
        kruskalQuickUnion = new KruskalQuickUnion();
    }

    @Test
    public void testRun() {
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

        kruskalQuickUnion.run(graph);
        kruskalQuickFind.run(graph);

        assertEquals(16, kruskalQuickUnion.weight(), 0.001);
        assertEquals(16, kruskalQuickFind.weight(), 0.001);
        int count = 0;
        for(Edge edge: kruskalQuickUnion.edges()) {
            count++;
        }
        count = 0;
        for(Edge edge: kruskalQuickFind.edges()) {
            count++;
        }

        assertEquals(5, count);



    }
}

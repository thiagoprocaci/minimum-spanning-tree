package com.tbp.minspanningtree;


import com.tbp.graph.Edge;
import com.tbp.graph.EdgeWeightedGraph;
import com.tbp.support.Queue;
import com.tbp.priorityqueues.MinPriorityQueue;
import com.tbp.priorityqueues.PriorityQueue;
import com.tbp.unionfind.UnionFind;

public abstract class KruskalMST {
    // MST = minimun spanning tree (arvore geradora minima)

    private double weight;  // weight of MST
    private Queue<Edge> mst;  // edges in MST
    private UnionFind uf;   // selected union-find algorithm



    public void run(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        weight = 0d;
        // more efficient to build heap by passing array of edges
        PriorityQueue<Edge> pq = new MinPriorityQueue<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        uf = createUnionFindAlgorithm(G.V());
        // run greedy algorithm
        while (!pq.isEmpty() && (mst.size() < G.V() - 1)) {
            Edge e = pq.delete();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) { // v-w does not create a cycle
                uf.union(v, w);  // merge v and w components
                mst.enqueue(e);  // add edge e to mst
                weight += e.weight();
            }
        }
    }

    public UnionFind getUf() {
        return uf;
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }

    public abstract UnionFind createUnionFindAlgorithm(int numberOfNodes);
}

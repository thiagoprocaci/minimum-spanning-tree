package com.tbp.minspanningtree.clustering;


import com.tbp.graph.Edge;
import com.tbp.graph.EdgeWeightedGraph;
import com.tbp.support.Queue;
import com.tbp.priorityqueues.MinPriorityQueue;
import com.tbp.priorityqueues.PriorityQueue;
import com.tbp.unionfind.QuickFind;
import com.tbp.unionfind.UnionFind;

public class Clustering {

    private  Queue<Edge> mst;
    private UnionFind uf;

    public Clustering(EdgeWeightedGraph G, int clusterNumber) {
        mst = new Queue<Edge>();
        // more efficient to build heap by passing array of edges
        PriorityQueue<Edge> pq = new MinPriorityQueue<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        uf = new QuickFind(G.V());
        // run greedy algorithm
        while (!pq.isEmpty() && (mst.size() < G.V() - 1)) {
            Edge e = pq.delete();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) { // v-w does not create a cycle
                uf.union(v, w);  // merge v and w components
                mst.enqueue(e);  // add edge e to mst

            }
            int remainingEdges = (G.V() - 1) - mst.size();
            if (remainingEdges == (clusterNumber - 1)) {
                break;
            }
        }
    }

    /**
     * @param v vertex
     * @return Returns the cluster number of vertex v
     */
    public int getCluster(int v) {
        return uf.find(v);
    }

}

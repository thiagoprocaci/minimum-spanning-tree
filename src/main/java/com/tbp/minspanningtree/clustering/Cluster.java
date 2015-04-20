package com.tbp.minspanningtree.clustering;


import com.tbp.minspanningtree.graph.Edge;
import com.tbp.minspanningtree.graph.EdgeWeightedGraph;
import com.tbp.minspanningtree.support.Queue;
import com.tbp.priorityqueues.MinPriorityQueue;
import com.tbp.priorityqueues.PriorityQueue;
import com.tbp.unionfind.QuickFind;
import com.tbp.unionfind.UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cluster {

    private int clusterNumber;
    private  Queue<Edge> mst;
    private Map<Integer, List<Integer>> clusters;

    public Cluster() {

    }

    public void createClusters(EdgeWeightedGraph G, int clusterNumber) {
        mst = new Queue<Edge>();
        this.clusterNumber = clusterNumber;
        clusters = new HashMap<Integer, List<Integer>>();
        // more efficient to build heap by passing array of edges
        PriorityQueue<Edge> pq = new MinPriorityQueue<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        UnionFind uf = new QuickFind(G.V());
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
        for(int v = 0; v < G.V(); v++) {
            int componentId = uf.find(v);
            if (clusters.get(componentId) == null) {
                clusters.put(componentId, new ArrayList<Integer>());
            }
            clusters.get(componentId).add(v);
        }
    }

    public void print() {
        System.out.println(clusters);
    }



}

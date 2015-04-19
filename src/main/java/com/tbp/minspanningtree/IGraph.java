package com.tbp.minspanningtree;


public interface IGraph {

    /**
     * Returns the number of vertices in the graph.
     * @return the number of vertices in the graph
     */
     int V();

    /**
     * Returns the number of edges in the graph.
     * @return the number of edges in the graph
     */
     int E();

    /**
     * Adds the undirected edge <tt>e</tt> to the edge-weighted graph.
     * @param e the edge
     * @throws java.lang.IndexOutOfBoundsException unless both endpoints are between 0 and V-1
     */
     void addEdge(Edge e);

    /**
     * Returns the edges incident on vertex v.
     * @return the edges incident on vertex v as an Iterable
     * @param v the vertex
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
     */
    Iterable<Edge> adj(int v);

    /**
     * Returns the degree of vertex v.
     * @return the degree of vertex v
     * @param v the vertex
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
     */
     int degree(int v);

    /**
     * Returns all edges in the graph.
     * To iterate over the edges in the graph, use foreach notation:
     * for (Edge e : G.edges()).
     * @return all edges in the graph as an Iterable.
     */
     Iterable<Edge> edges();
}

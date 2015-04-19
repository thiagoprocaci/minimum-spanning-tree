package com.tbp.minspanningtree;


public interface IEdge extends Comparable<IEdge> {

    /**
     * @return Returns the edge weight
     */
    double weight();

    /**
     * @return Returns either endpoint of the edge.
     */
    public int either();

    /**
     * Returns the endpoint of the edge that is different from the given vertex
     * (unless the edge represents a self-loop in which case it returns the same vertex).
     * @param vertex one endpoint of the edge
     * @return the endpoint of the edge that is different from the given vertex
     *   (unless the edge represents a self-loop in which case it returns the same vertex)
     * @throws java.lang.IllegalArgumentException if the vertex is not one of the endpoints
     *   of the edge
     */
     int other(int vertex);
}

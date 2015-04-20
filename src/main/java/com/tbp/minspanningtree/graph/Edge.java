package com.tbp.minspanningtree.graph;


public class Edge implements IEdge {

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        if ((v < 0) || (w < 0)) {
            throw new IllegalArgumentException("Vertex name must be a nonnegative integer");
        }
        if (Double.isNaN(weight)) {
            throw new IllegalArgumentException("Weight is NaN");
        }
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public int either() {
        return v;
    }

    @Override
    public int other(int vertex) {
        if (vertex == v){
            return w;
        }
        if (vertex == w) {
            return v;
        }
        throw new IllegalArgumentException("Illegal endpoint");
    }

    @Override
    public int compareTo(IEdge o) {
        if (this.weight() < o.weight()){
            return -1;
        }
        if (this.weight() > o.weight()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return v + " - " + w + " : " + weight;
    }
}

package com.tbp.unionfind;

public interface UnionFind {

    /**
     * add connection between p and q
     * @param p node p
     * @param q node q
     */
    void union(int p, int q);

    /**
     * @param p node p
     * @return Retorns the component identifier for p
     */
    int find(int p);

    /**
     * @param p node p
     * @param q node q
     * @return Return true id p and q are in the same component
     */
    boolean connected(int p, int q);

    /**
     * @return Returns the number od components
     */
    int count();

    /**
     *
     * @return Returns number of times union was invoked
     */
    int countUnion();

    /**
     *
     * @return Returns number of times find was invoked
     */
    int countFind();

}

package com.tbp.unionfind;


import com.tbp.unionfind.support.ArrayValidator;

public class QuickUnion implements UnionFind {
    private int[] parent;  // parent[i] = parent of i
    private int count;   // number of componentArray
    // number of times union was invoked
    private int countUnion;
    // number of times find was invoked
    private int countFind;


    public QuickUnion(int N) {
        // O(n) constructor
        countFind = 0;
        countUnion = 0;
        parent = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    /**
     *  Merges the component containing node p with the component containing node q
     * @param p node p
     * @param q node q
     */
    @Override
    public void union(int p, int q) {
        countUnion++;
        // O(tree height)
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ){
            return;
        }
        parent[rootP] = rootQ;
        count = count - 1;
    }

    /**
     *
     * @param p node p
     * @return Returns the component identifier for the component containing node p.
     */
    @Override
    public int find(int p) {
        countFind++;
        // O(tree height)
        ArrayValidator.validate(p, parent);
        while (p != parent[p])           {
            p = parent[p];
        }
        return p;
    }

    /**
     *
     * @param p node p
     * @param q node q
     * @return Returns true if node p and node q are in the same component; Otherwise false.
     */
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     *
     * @return Returns the number of componentArray
     */
    @Override
    public int count() {
        return count;
    }

    @Override
    public int countUnion() {
        return countUnion;
    }

    @Override
    public int countFind() {
        return countFind;
    }

}

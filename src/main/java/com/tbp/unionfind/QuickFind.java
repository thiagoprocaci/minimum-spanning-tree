package com.tbp.unionfind;


import com.tbp.unionfind.support.ArrayValidator;

public class QuickFind implements UnionFind {

    private int[] componentArray; // componentArray[i] = component identifier of i
    private int componentArraySize;   // number of components
    // number of times union was invoked
    private int countUnion;
    // number of times find was invoked
    private int countFind;


    public QuickFind(int N) {
        // O(n) constructor
        countFind = 0;
        countUnion = 0;
        componentArraySize = N;
        componentArray = new int[N];
        for (int i = 0; i < N; i++) {
            componentArray[i] = i;
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
        if (connected(p, q)) {
            return;
        }
        // O(n)
        int pid = componentArray[p];
        for (int i = 0; i < componentArray.length; i++) {
            if (componentArray[i] == pid) {
                componentArray[i] = componentArray[q];
            }
        }
        componentArraySize = componentArraySize - 1;
    }

    /**
     *
     * @param p node p
     * @return Returns the component identifier for the component containing node p.
     */
    @Override
    public int find(int p) {
        countFind++;
        // O(1)
        ArrayValidator.validate(p, componentArray);
        return componentArray[p];
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
        return componentArraySize;
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

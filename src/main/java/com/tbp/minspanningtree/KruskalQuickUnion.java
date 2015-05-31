package com.tbp.minspanningtree;

import com.tbp.unionfind.QuickUnion;
import com.tbp.unionfind.UnionFind;

public class KruskalQuickUnion extends KruskalMST {

    @Override
    public UnionFind createUnionFindAlgorithm(int numberOfNodes) {
        return new QuickUnion(numberOfNodes);
    }
}

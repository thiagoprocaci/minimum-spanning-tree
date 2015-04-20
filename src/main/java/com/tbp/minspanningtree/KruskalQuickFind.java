package com.tbp.minspanningtree;

import com.tbp.unionfind.QuickFind;
import com.tbp.unionfind.UnionFind;


public class KruskalQuickFind extends KruskalMST {

    @Override
    public UnionFind getUnionFindAlgorithm(int numberOfNodes) {
        return new QuickFind(numberOfNodes);
    }
}

package com.tbp.apa;


import com.tbp.apa.reader.FileSupport;
import com.tbp.apa.reader.LineSupport;
import com.tbp.minspanningtree.KruskalQuickFind;
import com.tbp.minspanningtree.KruskalQuickUnion;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            ExecuteMST executeMST = new ExecuteMST(new FileSupport(), new LineSupport(), new KruskalQuickFind());
            executeMST.run("grafosesparsos");
            executeMST.run("grafocompleto");

            executeMST = new ExecuteMST(new FileSupport(), new LineSupport(), new KruskalQuickUnion());
            executeMST.run("grafosesparsos");
            executeMST.run("grafocompleto");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

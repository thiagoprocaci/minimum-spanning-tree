package com.tbp.apa.reader;


import com.tbp.graph.IGraph;

import java.io.File;

public class GraphDto {

    private IGraph graph = null;
    private int numberNode = -1;
    private int numberEdges = -1;
    private int lineCount = 0;
    private boolean ready = false;
    private File file;



    public GraphDto(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public IGraph getGraph() {
        return graph;
    }

    public void setGraph(IGraph graph) {
        this.graph = graph;
    }

    public int getNumberNode() {
        return numberNode;
    }

    public void setNumberNode(int numberNode) {
        this.numberNode = numberNode;
    }

    public int getNumberEdges() {
        return numberEdges;
    }

    public void setNumberEdges(int numberEdges) {
        this.numberEdges = numberEdges;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }
}

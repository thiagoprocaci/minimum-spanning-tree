package com.tbp.apa;


public class Report {

    private long startTime;
    private long endTime;
    private String fileName;
    private int numberNodes;
    private int numberEdges;
    private String kruskalInstance;
    private int countUnion;
    private int countFind;

    public String getKruskalInstance() {
        return kruskalInstance;
    }

    public void setKruskalInstance(String kruskalInstance) {
        this.kruskalInstance = kruskalInstance;
    }

    public int getCountUnion() {
        return countUnion;
    }

    public void setCountUnion(int countUnion) {
        this.countUnion = countUnion;
    }

    public int getCountFind() {
        return countFind;
    }

    public void setCountFind(int countFind) {
        this.countFind = countFind;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getNumberNodes() {
        return numberNodes;
    }

    public void setNumberNodes(int numberNodes) {
        this.numberNodes = numberNodes;
    }

    public int getNumberEdges() {
        return numberEdges;
    }

    public void setNumberEdges(int numberEdges) {
        this.numberEdges = numberEdges;
    }

    public double getDuration() {
        return (endTime - startTime);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("File: ");
        builder.append(fileName);
        builder.append("\n");
        builder.append("Kruskal Instance: ");
        builder.append(kruskalInstance);
        builder.append("\n");
        builder.append("Duration: ");
        builder.append(getDuration());
        builder.append(" ms \n");
        builder.append("#Unions: ");
        builder.append(countUnion);
        builder.append("\n");
        builder.append("#Finds: ");
        builder.append(countFind);
        builder.append("\n");
        builder.append("Start time: ");
        builder.append(startTime);
        builder.append("\n");
        builder.append("End time: ");
        builder.append(endTime);
        builder.append("\n");
        builder.append("#Nodes: ");
        builder.append(numberNodes);
        builder.append("\n");
        builder.append("#Edges: ");
        builder.append(numberEdges);
        builder.append("\n");
        builder.append(" ----------------------------------------- ");
        return builder.toString();
    }
}

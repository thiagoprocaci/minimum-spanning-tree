package com.tbp.apa.reader;


import com.tbp.graph.Edge;
import com.tbp.graph.EdgeWeightedGraph;

public class LineSupport {

    public void handleLine(GraphDto graphDto, String line) {
        String lineArray[];
        if (graphDto.getGraph() == null && line.startsWith("UNDIRECTED") ) {
            return;
        }
        if (line.startsWith("NB_GRAPHS") || line.startsWith("LIST_OF_EDGES") || line.startsWith("END")) {
            return;
        }
        if (line.startsWith("NB_NODES")) {
            lineArray = line.split("NB_NODES");
            graphDto.setNumberNode(Integer.parseInt(lineArray[1].trim()));
            graphDto.setGraph(new EdgeWeightedGraph(graphDto.getNumberNode()));
        } else if (line.startsWith("NB_EDGES")) {
            lineArray = line.split("NB_EDGES");
            graphDto.setNumberEdges(Integer.parseInt(lineArray[1].trim()));
        } else if ((graphDto.getGraph() != null && line.startsWith("UNDIRECTED"))  || line.startsWith("<Graph") || graphDto.getLineCount() == graphDto.getNumberEdges()) {
            graphDto.setReady(true);
        } else {
            graphDto.setLineCount(graphDto.getLineCount() + 1);
            lineArray = line.split("\\s+");
            if(lineArray.length == 4) {
                int node1 = Integer.parseInt(lineArray[1]);
                int node2 = Integer.parseInt(lineArray[2]);
                double cost = Double.parseDouble(lineArray[3]);
                graphDto.getGraph().addEdge(new Edge(node1, node2, cost));
            } else {
                int node1 = Integer.parseInt(lineArray[0]);
                int node2 = Integer.parseInt(lineArray[1]);
                double cost = Double.parseDouble(lineArray[2]);
                graphDto.getGraph().addEdge(new Edge(node1, node2, cost));
            }

        }
    }
}

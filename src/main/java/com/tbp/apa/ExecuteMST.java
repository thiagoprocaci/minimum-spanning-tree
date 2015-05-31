package com.tbp.apa;


import com.tbp.apa.reader.FileSupport;
import com.tbp.apa.reader.GraphDto;
import com.tbp.apa.reader.LineSupport;
import com.tbp.minspanningtree.KruskalMST;

import java.io.*;
import java.util.List;

public class ExecuteMST {

    private FileSupport fileSupport;
    private LineSupport lineSupport;
    private KruskalMST kruskalMST;

    public ExecuteMST(FileSupport fileSupport, LineSupport lineSupport, KruskalMST kruskalMST) {
        this.fileSupport = fileSupport;
        this.lineSupport = lineSupport;
        this.kruskalMST = kruskalMST;
    }

    public void run(String folderData) throws IOException {
        List<File> fileList = fileSupport.listFiles(folderData);
        for (File file : fileList) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            GraphDto graphDto = new GraphDto(file);
            while ((line = br.readLine()) != null) {
                lineSupport.handleLine(graphDto, line);
                if (graphDto.isReady()) {
                    long startTime = System.currentTimeMillis();
                    kruskalMST.run((com.tbp.graph.EdgeWeightedGraph) graphDto.getGraph());
                    long endTime = System.currentTimeMillis();
                    generateReport(graphDto, startTime, endTime, kruskalMST);
                    graphDto = new GraphDto(file);
                }
            }
        }
    }

    private void generateReport(GraphDto graphDto, long startTime, long endTime, KruskalMST kruskalMST) {
        Report report = new Report();
        report.setNumberEdges(graphDto.getGraph().E());
        report.setNumberNodes(graphDto.getGraph().V());
        report.setFileName(graphDto.getFile().getAbsolutePath());
        report.setEndTime(endTime);
        report.setStartTime(startTime);
        report.setKruskalInstance(kruskalMST.getClass().getSimpleName());
        report.setCountFind(kruskalMST.getUf().countFind());
        report.setCountUnion(kruskalMST.getUf().countUnion());
        System.out.println(report.toString());
    }


    public FileSupport getFileSupport() {
        return fileSupport;
    }

    public void setFileSupport(FileSupport fileSupport) {
        this.fileSupport = fileSupport;
    }

    public LineSupport getLineSupport() {
        return lineSupport;
    }

    public void setLineSupport(LineSupport lineSupport) {
        this.lineSupport = lineSupport;
    }
}

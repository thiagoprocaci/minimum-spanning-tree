package com.tbp.apa;


import com.tbp.apa.reader.FileSupport;
import com.tbp.apa.reader.GraphDto;
import com.tbp.apa.reader.LineSupport;
import com.tbp.minspanningtree.KruskalMST;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExecuteMST {

    private FileSupport fileSupport;
    private LineSupport lineSupport;
    private KruskalMST kruskalMST;
    private String reportName;
    private InstanceResult instanceResult;

    public ExecuteMST(FileSupport fileSupport, LineSupport lineSupport, KruskalMST kruskalMST) {
        this.fileSupport = fileSupport;
        this.lineSupport = lineSupport;
        this.kruskalMST = kruskalMST;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        this.reportName = kruskalMST.getClass().getSimpleName() + "-" + simpleDateFormat.format(new Date())  + ".csv";
        writeToReport(InstanceResult.generateCSVHeader());
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
                    generateResult(graphDto, startTime, endTime);
                    graphDto = new GraphDto(file);
                }
            }
        }
    }

    private void generateResult(GraphDto graphDto, long startTime, long endTime) {
        InstanceResult instanceResult = new InstanceResult();
        instanceResult.setNumberEdges(graphDto.getGraph().E());
        instanceResult.setNumberNodes(graphDto.getGraph().V());
        instanceResult.setFileName(graphDto.getFile().getAbsolutePath());
        instanceResult.setEndTime(endTime);
        instanceResult.setStartTime(startTime);
        instanceResult.setKruskalInstance(kruskalMST.getClass().getSimpleName());
        instanceResult.setCountFind(kruskalMST.getUf().countFind());
        instanceResult.setCountUnion(kruskalMST.getUf().countUnion());
        writeToReport(instanceResult.generateCSVRow());
    }

    private void writeToReport(String content) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(reportName, true)));
            out.println(content);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

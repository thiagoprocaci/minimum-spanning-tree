package com.tbp.apa;


import com.tbp.apa.reader.FileSupport;
import com.tbp.apa.reader.LineSupport;
import com.tbp.minspanningtree.KruskalQuickFind;
import com.tbp.minspanningtree.KruskalQuickUnion;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{

            String pathGrafosEsparsos;
            String pathGrafosCompletos;
            if(args.length == 0) {
                final File jarFile = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
                if(jarFile.isFile()) {  // Run with JAR file
                    pathGrafosEsparsos = "classes" + File.separator + "grafosesparsos";
                    pathGrafosCompletos = "classes" + File.separator + "grafocompleto";
                } else {
                    // run wih IDE
                    pathGrafosEsparsos =  Main.class.getResource("/grafosesparsos").getPath();
                    pathGrafosCompletos = Main.class.getResource("/grafocompleto").getPath();
                }
            } else {
                pathGrafosEsparsos = args[0];
                pathGrafosCompletos = args[1];
            }

            ExecuteMST executeMST = new ExecuteMST(new FileSupport(), new LineSupport(), new KruskalQuickFind());
            executeMST.run(pathGrafosEsparsos);
            executeMST.run(pathGrafosCompletos);

            executeMST = new ExecuteMST(new FileSupport(), new LineSupport(), new KruskalQuickUnion());
            executeMST.run(pathGrafosEsparsos);
            executeMST.run(pathGrafosCompletos);

    }
}

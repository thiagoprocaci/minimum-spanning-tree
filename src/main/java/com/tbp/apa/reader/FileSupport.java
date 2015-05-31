package com.tbp.apa.reader;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSupport {

    public String getAbsPathInResourceFolder(String resourceName) {
        String path = FileSupport.class.getResource("/" + resourceName).getPath();
        return path;
    }

    public List<File> listFiles(File folder) {
        List<File> fileList = new ArrayList<File>();
        for (final File fileEntry : folder.listFiles()) {
            fileList.add(fileEntry);
        }
        return fileList;
    }

}

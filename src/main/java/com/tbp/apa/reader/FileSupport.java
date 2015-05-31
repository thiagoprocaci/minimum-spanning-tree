package com.tbp.apa.reader;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class FileSupport {

    public String getAbsPathInResourceFolder(String resourceName)  {
        return FileSupport.class.getResource("/" + resourceName).getPath();

    }

    public List<File> listFiles(String path) {
        File folder = new File(path);
        List<File> fileList = new ArrayList<File>();
        for (final File fileEntry : folder.listFiles()) {
            fileList.add(fileEntry);
        }
        return fileList;
    }



}

package com.tbp.apa;

import com.tbp.apa.reader.FileSupport;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class FileSupportTest {

    private FileSupport fileSupport;

    @Before
    public void doBefore() {
        fileSupport = new FileSupport();
    }

    @Test
    public void testGetAbsPathInResourceFolder() {
        String path = fileSupport.getAbsPathInResourceFolder("grafosesparsos");
        assertTrue(path.endsWith("grafosesparsos"));
        File file = new File(path);
        assertTrue(file.exists());
    }

    @Test
    public void testListFiles() {
        String path = fileSupport.getAbsPathInResourceFolder("grafosesparsos");
        List<File> fileNameList = fileSupport.listFiles(path);
        assertEquals(10, fileNameList.size());
        for(File f: fileNameList) {
            assertTrue(f.getName().endsWith("gs.txt"));
            assertTrue(f.getName().startsWith("i"));
        }
    }
}

package com.epam.lab.spring.core.work;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event){
        try {
            FileUtils.writeStringToFile(file, fileName, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  void init() throws IOException{
        this.file = new File(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

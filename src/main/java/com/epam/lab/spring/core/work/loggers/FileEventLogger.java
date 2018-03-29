package com.epam.lab.spring.core.work.loggers;

import com.epam.lab.spring.core.work.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.beans.ConstructorProperties;
import java.io.File;
import java.io.IOException;

@Component
public class FileEventLogger implements EventLogger {
    @Value("d:/java/files/fileforspring.txt")
    private String fileName;
    private File file;

    public FileEventLogger() {
    }

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event){
        try {
            String message = event.getMsg() + "\n";
            FileUtils.writeStringToFile(file, message, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    private  void init() throws IOException{
        this.file = new File(fileName);

        if (!file.canWrite()) {
            throw new IOException("!!!!! > Can't write into this file");
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

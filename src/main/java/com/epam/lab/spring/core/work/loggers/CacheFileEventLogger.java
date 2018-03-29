package com.epam.lab.spring.core.work.loggers;

import com.epam.lab.spring.core.work.Event;

import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if(cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
        super.logEvent(event);
    }

    private void writeEventsFromCache(){
        for (Event event : cache){
            super.logEvent(event);
        }
    }

    public void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
    }
}

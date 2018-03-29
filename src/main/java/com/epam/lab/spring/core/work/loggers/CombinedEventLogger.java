package com.epam.lab.spring.core.work.loggers;

import com.epam.lab.spring.core.work.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {
    Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for(EventLogger logger : loggers){
            logger.logEvent(event);
        }
    }
}

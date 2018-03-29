package com.epam.lab.spring.core.work.loggers;

import com.epam.lab.spring.core.work.Event;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
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

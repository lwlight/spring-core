package com.epam.lab.spring.core.work.loggers;

import com.epam.lab.spring.core.work.Event;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event){
        System.out.println(event);
    }
}

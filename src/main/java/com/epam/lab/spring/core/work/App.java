package com.epam.lab.spring.core.work;

import com.epam.lab.spring.core.work.loggers.EventLogger;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;

    public App() {
    }

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(Event event, EventType eventType){
        EventLogger logger = loggers.get(eventType);
        if(logger == null){
            logger = eventLogger;
        }
        String message = event.getMsg().replaceAll(client.getId()+"", client.getFullName());
        event.setMsg(message);
        logger.logEvent(event);
    }
}

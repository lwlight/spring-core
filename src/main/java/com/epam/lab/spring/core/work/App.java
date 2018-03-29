package com.epam.lab.spring.core.work;

import com.epam.lab.spring.core.work.loggers.CombinedEventLogger;
import com.epam.lab.spring.core.work.loggers.ConsoleEventLogger;
import com.epam.lab.spring.core.work.loggers.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Qualifier("app")
@Scope("prototype")
public class App {

    @Autowired
//    @Qualifier("client")
    private Client client;

    @Autowired
    private EventLogger eventLogger;

    @Autowired
    private Map<EventType, EventLogger> loggers;

    public App(){
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

    @PostConstruct
    private void init(){
        Map<EventType, EventLogger> map = new HashMap<>(2);
        map.put(EventType.INFO, new ConsoleEventLogger());
        map.put(EventType.ERROR, new CombinedEventLogger());
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public EventLogger getEventLogger() {
        return eventLogger;
    }

    public void setEventLogger(EventLogger eventLogger) {
        this.eventLogger = eventLogger;
    }

    public Map<EventType, EventLogger> getLoggers() {
        return loggers;
    }

    public void setLoggers(Map<EventType, EventLogger> loggers) {
        this.loggers = loggers;
    }
}

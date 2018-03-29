package com.epam.lab.spring.core.work.loggers;

import com.epam.lab.spring.core.work.Event;

public interface EventLogger {
    void logEvent(Event event);
}

package com.epam.lab.spring.core.Main;

import com.epam.lab.spring.core.work.App;
import com.epam.lab.spring.core.work.Client;
import com.epam.lab.spring.core.work.Event;
//import org.springframework.context.ApplicationContext;
import com.epam.lab.spring.core.work.EventType;
import com.epam.lab.spring.core.work.loggers.ConsoleEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(App.class);
        context.register(Client.class);
        context.register(ConsoleEventLogger.class);
        context.register(Event.class);
        context.refresh();
        Object appBean = context.getBean("app");
        App app = (App) appBean;
        Object eventBean = context.getBean("event");
        Event event = (Event) eventBean;
        event.setMsg("some message for 1");
        app.logEvent(event, EventType.INFO);
        event.setMsg("someCriticalMsg for 1");
        app.logEvent(event, EventType.ERROR);
    }

/*    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext();

    }*/
}

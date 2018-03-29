package com.epam.lab.spring.core.Main;

import com.epam.lab.spring.core.work.App;
import com.epam.lab.spring.core.work.Event;
//import org.springframework.context.ApplicationContext;
import com.epam.lab.spring.core.work.EventType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Object appBean = applicationContext.getBean("app");
        App app = (App) appBean;
        Object eventBean = applicationContext.getBean("event");
        Event event = (Event) eventBean;
        event.setMsg("some message for 1");
        app.logEvent(event, EventType.INFO);
        event.setMsg("someCriticalMsg for 1");
        app.logEvent(event, EventType.ERROR);
    }
}

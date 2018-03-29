package com.epam.lab.spring.core.work;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

@Component
@Qualifier("event")
//@Scope("prototype")
public class Event implements Serializable {
    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;


    public Event() {
    }

    public Event(Date date, DateFormat dateFormat) {
        this.id = new Random().nextInt(10000);
        this.date = date;
        this.dateFormat = dateFormat;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

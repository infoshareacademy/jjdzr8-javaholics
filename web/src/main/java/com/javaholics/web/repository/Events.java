package com.javaholics.web.repository;

import com.javaholics.web.repository.Event;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

@Component
public class Events {

    private List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void simpleAdd(Event event) {
        events.add(event);
        System.out.println("Nowy event dodany: " + event.toString());
    }
}

package com.javaholics.web.repository;

import com.javaholics.web.domain.Event;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.TreeMap;

@Repository
public class Events {

    private Map<Long, Event> events = new TreeMap<>();

    public Map<Long, Event> getEvents() {
        return events;
    }

    public void setEvents(Map<Long, Event> events) {
        this.events = events;
    }

    public void simpleAdd(Event event) {
        events.put(event.getId(), event);
        System.out.println("Nowy event dodany: " + event.toString());
    }
}

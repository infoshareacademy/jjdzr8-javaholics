package org.infoshareacademy.javaholics.event;

import java.util.HashMap;
import java.util.Map;

public class Events {

    private Map<Long, Event> events = new HashMap();

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

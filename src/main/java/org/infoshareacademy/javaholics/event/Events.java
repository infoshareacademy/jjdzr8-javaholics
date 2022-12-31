package org.infoshareacademy.javaholics.event;

import java.util.ArrayList;
import java.util.List;

public class Events {

    private List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(final List<Event> events) {
        this.events = events;
    }

    public void add(Event event) {
        events.add(event);
        System.out.println("Nowy event dodany: " + event.toString());
    }
}

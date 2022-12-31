package org.infoshareacademy.javaholics.event;

import org.infoshareacademy.javaholics.user.User;

import java.util.ArrayList;
import java.util.List;

public class Events {

    private static List<Event> eventArrayList = new ArrayList<>();

    public List<Event> getEvents() {
        return eventArrayList;
    }

    public static List<Event> getEventArrayList() {
        return eventArrayList;
    }

    public void setUserArrayList(List<Event> userArrayList) {
        this.eventArrayList = userArrayList;
    }

    public static void add(Event event) {
        eventArrayList.add(event);
        System.out.println("Nowy event dodany: " + event.toString());
    }
}
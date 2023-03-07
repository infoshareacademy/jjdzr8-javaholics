package com.javaholics.web.repository;

import java.util.Date;
import java.util.Objects;

public class Event {

    private Long id;
    private String eventName;
    private Date date;
    private String time;
    private String place;
    private String region;
    private User ownerOfEvent;
    private String description;
    private Integer usersCount;


    // constructors


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Event(Long id, String time) {
        this.eventName = eventName;
        this.id = id;
        this.date = date;
        this.time = time;
        this.ownerOfEvent = ownerOfEvent;
    }

    // getters and setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public User getOwnerOfEvent() {
        return ownerOfEvent;
    }
    public void setOwnerOfEvent(User ownerOfEvent) {
        this.ownerOfEvent = ownerOfEvent;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
//    public Route getEventRoute() {
//        return eventRoute;
//    }
//    public void setEventRoute(Route eventRoute) {
//        this.eventRoute = eventRoute;
//    }
    public Integer getUsersCount() {
        return usersCount;
    }
    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", region='" + region + '\'' +
                ", ownerOfEvent=" + ownerOfEvent +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(eventName, event.eventName) && Objects.equals(date, event.date) && Objects.equals(time, event.time) && Objects.equals(place, event.place) && Objects.equals(region, event.region) && Objects.equals(ownerOfEvent, event.ownerOfEvent) && Objects.equals(description, event.description) && Objects.equals(usersCount, event.usersCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, date, time, place, region, ownerOfEvent, description, usersCount);
    }
}


package org.infoshareacademy.javaholics.Event;

import java.util.Date;

public class Event {

    private Integer eventId;

    private Date eventDate;
    //do dyskusji czy nie Time poźniej
    private String eventTime;

    private String eventPlace;

    private String eventRegion;
    //tu odniesienie do klasy User
    private String eventOwner;

    private String eventDescr;
    // tu odniesienie do trasy
    private String eventRoute;

    private Integer eventUserCount;

    // getters and setters

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventRegion() {
        return eventRegion;
    }

    public void setEventRegion(String eventRegion) {
        this.eventRegion = eventRegion;
    }

    public String getEventOwner() {
        return eventOwner;
    }

    public void setEventOwner(String eventOwner) {
        this.eventOwner = eventOwner;
    }

    public String getEventDescr() {
        return eventDescr;
    }

    public void setEventDescr(String eventDescr) {
        this.eventDescr = eventDescr;
    }

    public String getEventRoute() {
        return eventRoute;
    }

    public void setEventRoute(String eventRoute) {
        this.eventRoute = eventRoute;
    }

    public Integer getEventUserCount() {
        return eventUserCount;
    }

    public void setEventUserCount(Integer eventUserCount) {
        this.eventUserCount = eventUserCount;
    }
}

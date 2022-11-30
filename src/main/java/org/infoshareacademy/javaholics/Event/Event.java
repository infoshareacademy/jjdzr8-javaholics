package org.infoshareacademy.javaholics.Event;

import org.infoshareacademy.javaholics.User.User;

import java.util.Date;

public class Event {

    private Integer eventId;

    private Date eventDate;
    //do dyskusji czy nie Time poźniej nie znam do końca tej klasy
    private String eventTime;

    private String eventPlace;

    private String eventRegion;

    private User eventOwner;

    private String eventDescr;
    // todo tu odniesienie do trasy konieczna nazwa i import i aktualizacja gettera settera
    private Route eventRoute;

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

    public User getEventOwner() {
        return eventOwner;
    }

    public void setEventOwner(User eventOwner) {
        this.eventOwner = eventOwner;
    }

    public String getEventDescr() {
        return eventDescr;
    }

    public void setEventDescr(String eventDescr) {
        this.eventDescr = eventDescr;
    }

    public Route getEventRoute() {
        return eventRoute;
    }

    public void setEventRoute(Route eventRoute) {
        this.eventRoute = eventRoute;
    }

    public Integer getEventUserCount() {
        return eventUserCount;
    }

    public void setEventUserCount(Integer eventUserCount) {
        this.eventUserCount = eventUserCount;
    }
}

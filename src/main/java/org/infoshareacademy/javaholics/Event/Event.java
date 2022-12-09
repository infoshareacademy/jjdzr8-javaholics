package org.infoshareacademy.javaholics.Event;

import org.infoshareacademy.javaholics.User.User;

import java.util.Date;

public class Event {

    private Long id;
    private Date date;
    //suggestion: do dyskusji czy nie Time poźniej nie znam do końca tej klasy
    private String time;
    private String place;
    private String region;
    private User ownerOfEvent;
    private String description;
    // todo tu odniesienie do trasy konieczna nazwa i import oraz aktualizacja gettera settera - na razie bład
    private Route id;
    private Integer usersCount;


    // constructors

    public Event(Long id, Date date, String time, User ownerOfEvent) {
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
    public Route getEventRoute() {
        return eventRoute;
    }
    public void setEventRoute(Route eventRoute) {
        this.eventRoute = eventRoute;
    }
    public Integer getUsersCount() {
        return usersCount;
    }
    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }
}

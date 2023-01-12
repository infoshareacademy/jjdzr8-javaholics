package org.infoshareacademy.javaholics.event;

import org.infoshareacademy.javaholics.user.User;
import org.infoshareacademy.javaholics.route.Route;
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

    public Event(String eventName, Long id, Date date, String time, User ownerOfEvent) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;

        if (!Objects.equals(id, event.id)) return false;
        if (!Objects.equals(eventName, event.eventName)) return false;
        if (!Objects.equals(date, event.date)) return false;
        if (!Objects.equals(time, event.time)) return false;
        if (!Objects.equals(place, event.place)) return false;
        if (!Objects.equals(region, event.region)) return false;
        if (!Objects.equals(ownerOfEvent, event.ownerOfEvent)) return false;
        if (!Objects.equals(description, event.description)) return false;
        return Objects.equals(usersCount, event.usersCount);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (ownerOfEvent != null ? ownerOfEvent.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (usersCount != null ? usersCount.hashCode() : 0);
        return result;
    }
}


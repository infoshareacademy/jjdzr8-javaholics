package com.javaholics.web.repository;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

public class Event {

    private Long id;
    @NotBlank
    private String eventName;
    private String time;
    @NotBlank
    private String place;
    @NotBlank
    private String region;
    private long ownerOfEvent;
    private String description;
    @Min(value = 1)
    private Integer usersCount;
    @FutureOrPresent()
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;

    // constructors
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Event(Long id, String eventName) {
        this.eventName = eventName;
        this.id = id;
    }

    // getters and setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
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
    public long getOwnerOfEvent() {
        return ownerOfEvent;
    }
    public void setOwnerOfEvent(long ownerOfEvent) {
        this.ownerOfEvent = ownerOfEvent;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
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
                ", ownerOfEvent='" + ownerOfEvent + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(eventName, event.eventName) && Objects.equals(date, event.date) && Objects.equals(time, event.time) && Objects.equals(place, event.place) && Objects.equals(region, event.region)  && Objects.equals(ownerOfEvent, event.ownerOfEvent) && Objects.equals(description, event.description) && Objects.equals(usersCount, event.usersCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, date, time, place, region, ownerOfEvent, description, usersCount);
    }
}


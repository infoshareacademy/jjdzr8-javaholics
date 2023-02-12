package org.infoshareacademy.javaholics.route;

import org.infoshareacademy.javaholics.user.User;
import org.infoshareacademy.javaholics.event.Event;

import java.io.File;
import java.util.Date;
import java.util.Objects;

public class Route {

    private long id;
    private String name;
    private String locality;
    private String placeStart;
    private String placeStop;
    private RouteDifficulty difficulty;
    private String routeFile;
    private long userId;
    private double avgRating;
    private String type;
    private double length;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Route(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPlaceStart() {
        return placeStart;
    }

    public void setPlaceStart(String placeStart) {
        this.placeStart = placeStart;
    }

    public String getPlaceStop() {
        return placeStop;
    }

    public void setPlaceStop(String placeStop) {
        this.placeStop = placeStop;
    }


    public String getRouteFile() {
        return routeFile;
    }

    public void setRouteFile(String  routeFile) {
        this.routeFile = routeFile;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public RouteDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(RouteDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locality='" + locality + '\'' +
                ", placeStart='" + placeStart + '\'' +
                ", placeStop='" + placeStop + '\'' +
                ", difficulty=" + difficulty +
                ", userId=" + userId +
                ", avgRating=" + avgRating +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", date=" + date +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(id, route.id) && Objects.equals(name, route.name) && Objects.equals(locality, route.locality) && Objects.equals(placeStart, route.placeStart) && Objects.equals(placeStop, route.placeStop) && Objects.equals(difficulty, route.difficulty) && Objects.equals(type, route.type) && Objects.equals(avgRating, route.avgRating) && Objects.equals(userId, route.userId)&& Objects.equals(length, route.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, locality, placeStart, placeStop, difficulty, userId, avgRating, type, length, date);
    }
}


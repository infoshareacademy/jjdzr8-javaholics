package org.infoshareacademy.javaholics.route;

import org.infoshareacademy.javaholics.user.User;
import org.infoshareacademy.javaholics.event.Event;

import java.io.File;
import java.util.Date;

public class Route {

    private long id;
    private String name;
    private String locality;
    private String placeStart;
    private String placeStop;
    private RouteDifficulty difficulty;
    private String routeFile;
    private User userId;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
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
}

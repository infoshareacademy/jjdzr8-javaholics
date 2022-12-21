package org.infoshareacademy.javaholics;

import java.io.File;

public class Route {

    private long id;
    private String name;
    private String locality;
    private String placeStart;
    private String placeStop;
    private RouteDifficulty difficulty;
    private File routeFile;
//    private User userId;
    private double avgRating;
    private String type;
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RouteDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(RouteDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setId(long id) {
        this.id = id;
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


    public File getRouteFile() {
        return routeFile;
    }

    public void setRouteFile(File routeFile) {
        this.routeFile = routeFile;
    }

//    public Event getLastEvent() {
//        return lastEvent;
//    }
//
//    public void setLastEvent(Event lastEvent) {
//        this.lastEvent = lastEvent;
//    }
//
//    public User getUserId() {
//        return userId;
//    }
//
//    public void setUserId(User userId) {
//        this.userId = userId;
//    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}

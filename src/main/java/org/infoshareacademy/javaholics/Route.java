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
    private Event lastEvent;
    private User authorRoute;
    private double avgRating;


    public Route(long id, String name) {
        this.id = id;
        this.name = name;
        this.locality = locality;
        this.placeStart = placeStart;
        this.placeStop = placeStop;
        this.difficulty = difficulty;
        this.routeFile = routeFile;
        this.lastEvent = lastEvent;
        this.authorRoute = authorRoute;
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

    public RouteDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(RouteDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public File getRouteFile() {
        return routeFile;
    }

    public void setRouteFile(File routeFile) {
        this.routeFile = routeFile;
    }

    public Event getLastEvent() {
        return lastEvent;
    }

    public void setLastEvent(Event lastEvent) {
        this.lastEvent = lastEvent;
    }

    public User getAuthorRoute() {
        return authorRoute;
    }

    public void setAuthorRoute(User authorRoute) {
        this.authorRoute = authorRoute;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}

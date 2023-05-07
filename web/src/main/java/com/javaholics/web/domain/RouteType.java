package com.javaholics.web.domain;

public enum RouteType {

    WALKING("Piesza"),
    RUNNING("Bieg"),
    BIKE("Rower"),
    OTHER("Inna");

public final String typeOfRoute;

    RouteType(String typeOfRoute) {
        this.typeOfRoute = typeOfRoute;
    }

    public String getTypeOfRoute() {
        return typeOfRoute;
    }
}

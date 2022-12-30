package org.infoshareacademy.javaholics.route;

import org.infoshareacademy.javaholics.event.Event;

import java.util.ArrayList;
import java.util.List;

public class Routes {
    private static List<Route> routeArrayList = new ArrayList<>();

    public List<Route> getRoutes() {
        return routeArrayList;
    }

    public static List<Route> getRouteArrayList() {
        return routeArrayList;
    }

    public void setUserArrayList(List<Route> userArrayList) {
        this.routeArrayList = userArrayList;
    }

    public static void add(Route route) {
        routeArrayList.add(route);
        System.out.println("Nowa trasa dodana: " + route.toString());
    }
}

package org.infoshareacademy.javaholics.route;

import java.util.ArrayList;
import java.util.List;

public class Routes {

    private List<Route> routes = new ArrayList<>();

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(final List<Route> routes) {
        this.routes = routes;
    }

    public void add(Route route) {
        routes.add(route);
        System.out.println("Nowa trasa dodana: " + route.toString());
    }
}

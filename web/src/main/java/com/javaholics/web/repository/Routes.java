package com.javaholics.web.repository;

import com.javaholics.web.repository.Route;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
@Component
public class Routes {
    private List<Route> routes = new ArrayList<>();

    public List<Route> getRoutes() {
        return routes;
    }

    public void setUserArrayList(List<Route> userArrayList) {
        this.routes = userArrayList;
    }

    public void add(Route route) {
        routes.add(route);
        System.out.println("Nowa trasa dodana: " + route.toString());
    }
}




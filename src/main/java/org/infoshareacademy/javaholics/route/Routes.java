package org.infoshareacademy.javaholics.route;

import java.util.Map;
import java.util.TreeMap;

public class Routes {
    Route routes;
    private Map<Long, Route> routeMap = new TreeMap<>();
    public Map<Long, Route> getRouteMap(){
        return routeMap;
    }
    public void setRouteMap(Map<Long, Route> routeMap) {
        this.routeMap = routeMap;
    }
    public void simpleAddRoute(Route routes){
        routeMap.put(routes.getId(), routes);
        System.out.println("Nowa trasa została dodana : " + routes.toString());
    }

//    private List<Route> routes = new ArrayList<>();
//
//    public List<Route> getRoutes() {
//        return routes;
//    }
//
//    public void setUserArrayList(List<Route> userArrayList) {
//        this.routes = userArrayList;
//    }
//
//    public void add(Route route) {
//        routes.add(route);
//        System.out.println("Nowa trasa dodana: " + route.toString());
//    }
}


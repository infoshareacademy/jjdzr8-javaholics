package org.infoshareacademy.javaholics.route;

import java.util.Map;
import java.util.TreeMap;

public class Routes {
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
}


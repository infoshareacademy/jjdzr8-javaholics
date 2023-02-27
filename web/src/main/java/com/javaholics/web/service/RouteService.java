package com.javaholics.web.service;

import com.google.gson.JsonObject;
import com.javaholics.web.controller.Menu;
import com.javaholics.web.exception.RouteNotFoundException;
import com.javaholics.web.repository.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.javaholics.web.repository.Route;

@Service
public class RouteService implements IdNumbers{

    private List<Route> routes;
    private FileService fileService;

    public RouteService(FileService fileService) {
        this.fileService = fileService;
        List<Route> routeList = fileService.readRoutesFromFile().getRoutes();
        routes = routeList;
    }
    public List<Route> getRoutes() {
        return routes;
    }

    public List<Route> getRoutesSearch(String key) {
        if (key == null) {
            return routes;
        }
        return routes.stream()
                .filter(route -> StringUtils.containsIgnoreCase( route.getType(), key)
                        || StringUtils.containsIgnoreCase( route.getDifficulty().name(), key )
                        || StringUtils.containsIgnoreCase(route.getLocality(), key))
                        .collect(Collectors.toList() );
    }
    public void deleteRouteById(long id) {
        Route foundRout = findRouteById(id);
        routes.remove(foundRout);
    }

    public Route findRouteById(Long id) {
        return routes.stream()
                .filter(route -> route.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RouteNotFoundException("Not found car with ID: %s".formatted(id)));
    }

    public void editRouteById(Long id, Route route) throws ParseException {
        Route routeToEdit = findRouteById(id);

        routeToEdit.setName(route.getName());
        routeToEdit.setLocality(route.getLocality());
        routeToEdit.setPlaceStart(route.getPlaceStart());
        routeToEdit.setPlaceStop(route.getPlaceStop());
        routeToEdit.setDifficulty(route.getDifficulty());
        routeToEdit.setRouteFile(route.getRouteFile());
        routeToEdit.setUserId(route.getUserId());
        routeToEdit.setAvgRating(route.getAvgRating());
        routeToEdit.setType(route.getType());
        routeToEdit.setLength(route.getLength());
        routeToEdit.setDate(route.getDate());

    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public void saveRoutesToJson(){

        Routes routesCopy = new Routes();
        for (int i = 0; i <routes.size() ; i++) {
            routesCopy.add(routes.get(i));
        }
        fileService.writeToJsonFile(routesCopy);
    }


    @Override
    public long getCurrentIdNoSaveToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIdsFromJsonFile();
        return iDsNumbers.getIpRoute();
    }

    @Override
    public long getCurrentIdWithSaveNextIdToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIdsFromJsonFile();
        long idRoute = iDsNumbers.getIpRoute();
        iDsNumbers.setIpRoute(idRoute+1);
        fileUtils.saveIdsToJsonFile(iDsNumbers);
        return idRoute;

}
}
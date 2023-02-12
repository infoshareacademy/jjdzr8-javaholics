package com.javaholics.web.controller;

import com.javaholics.web.repository.Event;
import com.javaholics.web.repository.Events;
import com.javaholics.web.repository.Route;
import com.javaholics.web.repository.Routes;
import com.javaholics.web.service.EventService;
import com.javaholics.web.service.FileService;
import com.javaholics.web.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class RouteController {

    private FileService fileService;
    private RouteService routeService;

    public RouteController(FileService fileService, RouteService routeService) {
        this.fileService = fileService;
        this.routeService = routeService;
    }

    @GetMapping("/route")
    public String showEvents(Model model) {
        Routes routes = new Routes();

        routes = fileService.readRoutesFromFile();

        List<Route> routeList = new ArrayList<>(routes.getRoutes());

        model.addAttribute("routes", routeList);

        return "routes";

    }


}

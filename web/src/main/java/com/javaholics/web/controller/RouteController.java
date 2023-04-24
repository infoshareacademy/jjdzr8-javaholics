package com.javaholics.web.controller;

import com.javaholics.web.dto.RouteDto;
import com.javaholics.web.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RouteController {


    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String showRoutes(Model model) {
        List<RouteDto> routeList = routeService.getRoutes();
        model.addAttribute("routes", routeList);
        return "routes/routes";
    }

    @PostMapping("/routes")
    public String createRoute(@Valid @ModelAttribute RouteDto routeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "routes/addroute";
        }
        routeService.addRoute(routeDto);
        return "redirect:/routes";
    }

    @GetMapping("/routes/create")
    public String addRoute(Model model) {
        model.addAttribute("route", new RouteDto());
        return "routes/addroute";
    }

    @GetMapping("/routes/{routeId}")
    public String getRouteById(@PathVariable("routeId") Long routeId, Model model) {
        RouteDto route = routeService.findRouteById(routeId);
        model.addAttribute("route", route);
        return "routes/modifyroute";
    }

    @PostMapping("/routes/{routeId}/edit")
    public String editRoute(@PathVariable("routeId")@Valid @ModelAttribute RouteDto route, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "routes/modifyroute";
        }
        routeService.editRouteById(route);
        return "redirect:/routes";
    }

    @GetMapping("routes/delete-route/{id}")
    public String deleteRoute(@PathVariable long id) {
        routeService.deleteRouteById(id);
        return "redirect:/routes";
    }

    @GetMapping("/routes/get-error")
    public String getRouteWithWrongIdAndThrowError() {
        routeService.findRouteById(-1L);
        return "routes/routes";
    }
}
    /*
    @GetMapping("/routes")
    public String showRoutes(@RequestParam(required = false) String keyword, @RequestParam (required = false) String typeWord, @RequestParam (required = false) String difficulty, Model model) {
        List<Route> routeList = routeService.getRoutesSearch(keyword, typeWord, difficulty);
        model.addAttribute("routes", routeList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("typeWord", typeWord);
        model.addAttribute("difficulty", difficulty);
        return "routes/routes";
    }*/




package com.javaholics.web.controller;

import com.javaholics.web.dto.RouteDto;
import com.javaholics.web.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    /*
    @GetMapping("/routes")
    public String showRoutes(@RequestParam(required = false) String keyword, @RequestParam (required = false) String typeWord, @RequestParam (required = false) String difficulty, Model model) {
        List<Route> routeList = routeService.getRoutesSearch(keyword, typeWord, difficulty);
        model.addAttribute("routes", routeList);
        model.addAttribute("keyword", keyword);
        model.addAttribute("typeWord", typeWord);
        model.addAttribute("difficulty", difficulty);
        return "routes/routes";
    }

    @GetMapping("/routes/{routeId}")
    public String getRouteById(@PathVariable("routeId") Long routeId, Model model) {
        Route route = routeService.findRouteById(routeId);
        model.addAttribute("route", route);
        return "routes/modifyroute";
    }

    @PostMapping("/routes/{routeId}/edit")
    public String editRoute(@PathVariable("routeId") Long routeId, @Valid @ModelAttribute Route route,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "routes/modifyroute";
        }
        routeService.editRouteById(routeId, route);
        return "redirect:/routes";
    }

    @GetMapping("routes/delete-route/{id}")
    public String deleteRoute(@PathVariable long id) {
        routeService.deleteRouteById(id);
        return "redirect:/routes";
    }

    @GetMapping("/routes/create")
    public String showCreateForm(Model model) {
        Long id = routeService.getCurrentIdWithSaveNextIdToJson();
        model.addAttribute("route", new Route(id,"routeName"));
        return "routes/addroute";
    }

    @PostMapping("/routes")
    public String createRoute(@Valid @ModelAttribute Route route, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "routes/addroute";
        }
        routeService.addRoute(route);
        return "redirect:/routes";
    }

    @GetMapping("/routes/get-error")
    public String getRouteWithWrongIdAndThrowError() {
        routeService.findRouteById(-1L);
        return "routes/routes";
    }

    @GetMapping("routes/save")
    public String saveRoutes(){
        routeService.saveRoutesToJson();
        return "redirect:/routes";
    }*/

}

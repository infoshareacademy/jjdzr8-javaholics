package com.javaholics.web.controller;

import com.javaholics.web.repository.Route;
import com.javaholics.web.repository.Routes;
import com.javaholics.web.service.FileService;
import com.javaholics.web.service.RouteService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
public class RouteController {

    private FileService fileService;
    private RouteService routeService;
    private Routes routes;


    public RouteController(FileService fileService, RouteService routeService, Routes routes) {
        this.fileService = fileService;
        this.routeService = routeService;
        this.routes = routes;
    }
//    @GetMapping("/routes/{routeAre}")
//    public String routeSearch(@PathVariable("routeAre") String are, Model model) {
//        List<Route> routeListSearch = routeService.searchRoute(are);
//        model.addAttribute("searchRoutes", routeListSearch);
//        return "/routes/{routeAre}";
//    }
        @GetMapping("/routes/{dif}")
        public List<Route> searchRoute (@PathVariable String dif, Model model){
        List<Route> routeList = routeService.searchRoute(dif);
        model.addAttribute("routes", routeList);
            return routeService.searchRoute(dif);
}

    @GetMapping("/routes")
    public String showRoutes(@RequestParam(required = false) String keyword, Model model) {
        List<Route> routeList = routeService.getRoutes(keyword);
        model.addAttribute("routes", routeList);
        return "routes/routes";
    }

    @GetMapping("/routes/{routeId}")
    public String getRouteById(@PathVariable("routeId") Long routeId, Model model) {
        Route route = routeService.findRouteById(routeId);
        model.addAttribute("route", route);
        return "routes/modifyroute";
    }
    @PostMapping("/routes/{routeId}/edit")
    public String editRoute(@PathVariable("routeId") Long routeId, @Valid @ModelAttribute Route route, Model model) throws ParseException {
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
            return "routes/routes";
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
    }

}

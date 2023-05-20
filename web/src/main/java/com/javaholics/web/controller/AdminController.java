package com.javaholics.web.controller;

import com.javaholics.web.dto.EventDto;
import com.javaholics.web.dto.RouteDto;
import com.javaholics.web.dto.UserDto;
import com.javaholics.web.service.EventService;
import com.javaholics.web.service.RouteService;
import com.javaholics.web.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RouteService routeService;
    private final EventService eventService;
    private final UserService userService;

    public AdminController(RouteService routeService, EventService eventService, UserService userService) {
        this.routeService = routeService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @Secured("ADMIN")
    @GetMapping("/api")
    public String getAdminPanel(){
        return "adminpanel/adminmain";
    }

    @Secured("ADMIN")
    @GetMapping("/routes")
    public String showRoutes(Model model) {
        List<RouteDto> routeList = routeService.getRoutes();
        model.addAttribute("routes", routeList);
        return "adminpanel/adminroutes";
    }
    @Secured("ADMIN")
    @GetMapping("/events")
    public String showEvents(Model model) {
        List<EventDto> eventList = eventService.getEvents();
        model.addAttribute("events", eventList);
        return "adminpanel/adminevents";
    }

    @Secured("ADMIN")
    @GetMapping("/users")
    public String showUsers(Model model) {
        List<UserDto> userList = userService.getUsers();
        model.addAttribute("users", userList);
        return "adminpanel/adminusers";
    }
    @Secured("ADMIN")
    @GetMapping("users/delete-user/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }
}

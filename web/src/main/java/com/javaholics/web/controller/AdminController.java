package com.javaholics.web.controller;

import com.javaholics.web.dto.EventDto;
import com.javaholics.web.dto.RouteDto;
import com.javaholics.web.dto.UserDto;
import com.javaholics.web.service.EventService;
import com.javaholics.web.service.RouteService;
import com.javaholics.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String getAdminPanel(Model model1, Model model2, Model model3){
        List<RouteDto> routeList = routeService.getRoutes();
        model1.addAttribute("routes", routeList);
        List<EventDto> eventList = eventService.getEvents();
        model2.addAttribute("events", eventList);
        List<UserDto> userList = userService.getUsers();
        model3.addAttribute("users", userList);

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
    @GetMapping("routes/delete-route/{id}")
    public String deleteRoute(@PathVariable long id) {
        routeService.deleteRouteById(id);
        return "redirect:/admin/routes";
    }
    @Secured("ADMIN")
    @PostMapping("/routes/edit")
    public String editRoute(@ModelAttribute RouteDto route, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "routes/modifyroute";
        }
        routeService.updateRoute(route);
        return "redirect:/admin/routes";
    }

    @Secured("ADMIN")
    @GetMapping("/events")
    public String showEvents(Model model) {
        List<EventDto> eventList = eventService.getEvents();
        model.addAttribute("events", eventList);
        return "adminpanel/adminevents";
    }
    @Secured("ADMIN")
    @PostMapping("/events/{eventId}/edit")
    public String editEvent(@PathVariable("eventId") Long eventId, @Valid @ModelAttribute EventDto event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "events/modifyevent";
        }
        eventService.updateEvent(event);
        return "redirect:/admin/events";
    }
    @Secured("ADMIN")
    @GetMapping("events/delete-event/{id}")
    public String deleteEvent(@PathVariable long id) {
        eventService.deleteEventById(id);
        return "redirect:/admin/events";
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

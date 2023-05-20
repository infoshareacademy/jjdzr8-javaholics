package com.javaholics.web.controller;

import com.javaholics.web.dto.EventDto;
import com.javaholics.web.repository.RouteRepository;
import com.javaholics.web.repository.UserRepository;
import com.javaholics.web.service.EventService;
import com.javaholics.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/public")
public class EventController {


    private final EventService eventService;
    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    UserService userService;

    public EventController(EventService eventService, RouteRepository routeRepository, UserRepository userRepository) {
        this.eventService = eventService;
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/events")
    public String showEvents(Model model) {
        List<EventDto> eventList = eventService.getEvents();
        model.addAttribute("events", eventList);
        return "events/events";
    }
    @GetMapping("/events/myevents")
    public String showMyRoutes(Model model) {
        Long id;
        String email = eventService.useridName();
        id = userRepository.findByEmail(email).get().getId();
        List<EventDto> eventList = eventService.findEventByUserId(id);
        model.addAttribute("events", eventList);
        return "events/myevents";
    }
    @GetMapping("/events/mysearch")
    public String showMyEventsFilter(@RequestParam(required = false) String localWord, @RequestParam(required = false) String nameWord, @RequestParam(required = false) String descriptionWord, Model model) {
        Long id;
        String email = eventService.useridName();
        id = userRepository.findByEmail(email).get().getId();
        List<EventDto> eventList = eventService.getMyEventSearch(localWord, nameWord, descriptionWord,id);
        model.addAttribute("events", eventList);
        model.addAttribute("localKey", localWord);
        model.addAttribute("nameWord", nameWord);
        model.addAttribute("descriptionWord", descriptionWord);
        return "events/myevents";
    }

    @GetMapping("/events/create")
    public String showCreateEvent(Model model) {
        model.addAttribute("event", new EventDto());
        model.addAttribute("routes",routeRepository.findAll());
        return "events/addevent";
    }

    @PostMapping("/events")
    public String createEvents(@Valid @ModelAttribute EventDto eventDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/events";
        }
        eventService.addEvent(eventDto);
        return "redirect:/public/events";
    }
    @GetMapping("/events/myevents/create")
    public String showCreatemyEvent(Model model) {
        model.addAttribute("event", new EventDto());
        model.addAttribute("routes",routeRepository.findAll());
        return "events/addmyevent";
    }

    @PostMapping("/events/myevents")
    public String createMyEvents(@Valid @ModelAttribute EventDto eventDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/events/myevents";
        }
        eventService.addEvent(eventDto);
        return "redirect:/public/events/myevents";
    }
    @GetMapping("/events/search")
    public String showEvents(@RequestParam(required = false) String localWord, @RequestParam(required = false) String nameWord, @RequestParam(required = false) String descriptionWord, Model model) {
        List<EventDto> eventList = eventService.getEventSearch(localWord, nameWord, descriptionWord);
        model.addAttribute("events", eventList);
        model.addAttribute("localKey", localWord);
        model.addAttribute("nameWord", nameWord);
        model.addAttribute("descriptionWord", descriptionWord);
        return "events/events";
    }

    @GetMapping("/events/{eventId}")
    public String getEventById(@PathVariable("eventId") Long eventId, Model model) {
        EventDto event = eventService.findEventById(eventId);
        model.addAttribute("event", event);
        return "events/modifyevent";
    }

    @PostMapping("/events/{eventId}/edit")
    public String editEvent(@PathVariable("eventId") Long eventId, @Valid @ModelAttribute EventDto event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "events/modifyevent";
        }
        eventService.updateEvent(event);
        return "redirect:/public/events/myevents";
    }

    @GetMapping("events/delete-event/{id}")
    public String deleteEvent(@PathVariable long id) {
        eventService.deleteEventById(id);
        return "redirect:/public/events/myevents";
    }
    @GetMapping("/events/details/{eventId}")
    public String getEventByIdDetils(@PathVariable("eventId") Long eventId, Model model) {
        EventDto event = eventService.findEventById(eventId);
        model.addAttribute("events", event);
        return "events/eventdetails";
    }
    @GetMapping("/events/detailsmain/{eventId}")
    public String getEventByIdDetilsMain(@PathVariable("eventId") Long eventId, Model model) {
        EventDto event = eventService.findEventById(eventId);
        model.addAttribute("events", event);
        return "events/eventdetailsmain";
    }

    @PostMapping("/events/{eventId}/adduser/{userId}")
    @PreAuthorize("isAuthenticated()")
    public String addUserToEvent(@PathVariable("eventId") Long eventId, @PathVariable("userId") Long userId) {
        eventService.addUserToEvent(eventId, userId);
        return "redirect:/public/events/details/" + eventId;
    }
}

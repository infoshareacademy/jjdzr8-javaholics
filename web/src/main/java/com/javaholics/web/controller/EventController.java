package com.javaholics.web.controller;

import com.javaholics.web.dto.EventDto;
import com.javaholics.web.dto.RouteDto;
import com.javaholics.web.repository.RouteRepository;
import com.javaholics.web.service.EventService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/public")
public class EventController {


    private final EventService eventService;
    private final RouteRepository routeRepository;

    public EventController(EventService eventService, RouteRepository routeRepository) {
        this.eventService = eventService;
        this.routeRepository = routeRepository;
    }

    @GetMapping("/events")
    public String showEvents(Model model) {
        List<EventDto> eventList = eventService.getEvents();
        model.addAttribute("events", eventList);
        return "events/events";
    }
    @GetMapping("/events/myevents")
    public String showMyRoutes(Model model) {
        List<EventDto> eventList = eventService.findEventsByCount(12);
        model.addAttribute("events", eventList);
        return "events/myevents";
    }
    @GetMapping("/events/mysearch")
    public String showMyEventsFilter(@RequestParam(required = false) String localWord, @RequestParam(required = false) String nameWord, @RequestParam(required = false) String descriptionWord, Model model) {
        List<EventDto> eventList = eventService.getMyEventSearch(localWord, nameWord, descriptionWord,12);
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
            return "events/addevent";
        }
        eventService.addEvent(eventDto);
        return "redirect:/public/events";
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
        return "redirect:/public/events";
    }

    @GetMapping("events/delete-event/{id}")
    public String deleteEvent(@PathVariable long id) {
        eventService.deleteEventById(id);
        return "redirect:/public/events";
    }
    @GetMapping("/events/details/{eventId}")
    public String getEventByIdDetils(@PathVariable("eventId") Long eventId, Model model) {
        EventDto event = eventService.findEventById(eventId);
        model.addAttribute("events", event);
        return "events/eventdetails";
    }
}

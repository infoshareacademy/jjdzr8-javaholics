package com.javaholics.web.controller;

import com.javaholics.web.repository.Event;
import com.javaholics.web.repository.Events;
import com.javaholics.web.service.EventService;
import com.javaholics.web.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@Controller
public class EventController {

    private FileService fileService;
    private EventService eventService;
    private Events events;

    @Autowired
    public EventController(FileService fileService, EventService eventService, Events events) {
        this.fileService = fileService;
        this.eventService = eventService;
        this.events = events;
    }

    @GetMapping("/events")
    public String showEvents(Model model) {
        List<Event> eventList = eventService.getEvents();
        model.addAttribute("events", eventList);
        return "events/events";
    }

    @GetMapping("/events/{eventId}")
    public String getEventById(@PathVariable("eventId") Long eventId, Model model) {
        Event event = eventService.findEventById(eventId);
        model.addAttribute("event", event);
        return "events/modifyevent";
    }

    @PostMapping("/events/{eventId}/edit")
    public String editEvent(@PathVariable("eventId") Long eventId, @Valid @ModelAttribute Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "events/modifyevent";
        }
        eventService.editEventById(eventId, event);
        return "redirect:/events";
    }

    @GetMapping("events/delete-event/{id}")
    public String deleteEvent(@PathVariable long id) {
        eventService.deleteEventById(id);
        return "redirect:/events";
    }

    @GetMapping("/events/create")
    public String showCreateFormEvent(Model model) {
        Long id = eventService.getCurrentIdWithSaveNextIdToJson();
        model.addAttribute("event", new Event(id, "eventName"));
        return "events/addevent";
    }

    @PostMapping("/events")
    public String createEvents(@Valid @ModelAttribute Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "events/events";
        }
        eventService.addEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/events/get-error")
    public String getEventWithWrongIdAndThrowError() {
        eventService.findEventById(-1L);
        return "events/events";
    }

    @GetMapping("events/save")
    public String saveEvents(){
        eventService.saveEventToJson();
        return "redirect:/events";
    }

}

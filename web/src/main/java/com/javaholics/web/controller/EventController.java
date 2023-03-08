package com.javaholics.web.controller;

import com.javaholics.web.repository.Event;
import com.javaholics.web.repository.Events;
import com.javaholics.web.service.EventService;
import com.javaholics.web.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;



@Controller
public class EventController {

//    private FileService fileService;
    private EventService eventService;
    private Events events;

    @Autowired
    public EventController(FileService fileService, EventService eventService, Events events) {
//        this.fileService = fileService;
        this.eventService = eventService;
        this.events = events;
    }

    @GetMapping("/events")
    public String showEvents(Model model) {
        List<Event> eventList = eventService.getEvents();
        model.addAttribute("events", eventList);
        return "events/events";
    }

    @GetMapping("/events/create")
    public String showCreateEvent(Model model) {
        Long id = eventService.getCurrentIdNoSaveToJson();
        model.addAttribute("event", new Event(id, "eventName"));
        return "events/addevent";
    }

    @PostMapping("/events")
    public String creatEvents(@Valid @ModelAttribute Event event, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "events/events";
        }
        eventService.addEvent(event);
        return "redirect:/events";
    }
}

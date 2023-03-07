package com.javaholics.web.service;
import com.google.gson.JsonObject;
import com.javaholics.web.controller.Menu;
import com.javaholics.web.exception.EventNotFoundException;
import com.javaholics.web.repository.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.*;
import static com.javaholics.web.service.FileService.gson;

import com.javaholics.web.repository.Event;


@Service
public class EventService implements IdNumbers {


    private final List<Event> events;
    private FileService fileService;


    public EventService(FileService fileService) {
        this.fileService = fileService;
        events = fileService.readEventsFromFile().getEvents();
    }

    public List<Event> getEvents() {
        return events;
    }



    public Event findEventById(Long id) {
        return events.stream()
                .filter(event -> event.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EventNotFoundException("Not found: %s".formatted(id)));
    }
    public void editEventById(Long id, Event event) throws ParseException {
        Event eventToEdit = findEventById(id);

        eventToEdit.setId(event.getId());
        eventToEdit.setEventName(event.getEventName());
        eventToEdit.setOwnerOfEvent(event.getOwnerOfEvent());
        eventToEdit.setDescription(event.getDescription());
        eventToEdit.setPlace(event.getPlace());
        eventToEdit.setRegion(event.getRegion());
        eventToEdit.setUsersCount(event.getUsersCount());

    }

    public void saveEventToJson() {
        Events eventsCopy = new Events();
        for (Event event : events) {
            eventsCopy.simpleAdd(event);
        }
        fileService.writeToJsonFile(eventsCopy);
    }

    @Override
    public long getCurrentIdNoSaveToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIdsFromJsonFile();
        long idRoute = iDsNumbers.getIpRoute();
        iDsNumbers.setIpRoute(idRoute+1);
        fileUtils.saveIdsToJsonFile(iDsNumbers);
        return idRoute;
    }

    @Override
    public long getCurrentIdWithSaveNextIdToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIdsFromJsonFile();
        return iDsNumbers.getIpRoute();
    }

}

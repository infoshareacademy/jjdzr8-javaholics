package com.javaholics.web.service;
import com.javaholics.web.domain.RouteDifficulty;
import com.javaholics.web.dto.EventDto;
import com.javaholics.web.exception.EventNotFoundException;
import com.javaholics.web.repository.*;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

import com.javaholics.web.domain.Event;


@Service
@AllArgsConstructor
public class EventService {

    private Dao<Event> eventDao;

    public Collection<Event> getAllEvents(){

        return List.of();
    }
    public void addEvent(EventDto eventDto) {

    }
    /*private final List<Event> events;
    private final FileService fileService;


    public EventService(FileService fileService) {
        this.fileService = fileService;
        events = new ArrayList<Event>(fileService.readEventsFromFile().getEvents().values());
    }

    public List<Event> getEvents() {
        return events;
    }


    public Event findEventById(Long id) {
        return events.stream()
                .filter(event -> Objects.equals(event.getId(), id))
                .findFirst()
                .orElseThrow(() -> new EventNotFoundException("Not found: %s".formatted(id)));
    }
    public void editEventById(Long id, Event event) {
        Event eventToEdit = findEventById(id);

        eventToEdit.setId(event.getId());
        eventToEdit.setEventName(event.getEventName());
        eventToEdit.setOwnerOfEvent(event.getOwnerOfEvent());
        eventToEdit.setDescription(event.getDescription());
        eventToEdit.setPlace(event.getPlace());
        eventToEdit.setRegion(event.getRegion());
        eventToEdit.setUsersCount(event.getUsersCount());
        eventToEdit.setDate(event.getDate());
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void saveEventToJson() {
        Events eventsCopy = new Events();
        for (Event event : events) {
            eventsCopy.simpleAdd(event);
        }
        fileService.writeToJsonFile(eventsCopy);
    }

    public void deleteEventById(long id) {
        Event event = findEventById(id);
        events.remove(event);
    }


    @Override
    public long getCurrentIdNoSaveToJson() {
        FileUtils fileUtils = new FileUtils();
        IDsNumbers iDsNumbers = fileUtils.readIdsFromJsonFile();
        long idEvent = iDsNumbers.getIpEvent();
        iDsNumbers.setIpEvent(idEvent+1);
        fileUtils.saveIdsToJsonFile(iDsNumbers);
        return idEvent;
    }

    @Override
    public long getCurrentIdWithSaveNextIdToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIdsFromJsonFile();
        return iDsNumbers.getIpEvent();
    }

    public List<Event> getEventSearch(String placeKey, String nameKey, String descriptionKey) {
        if (placeKey == null && nameKey == null && descriptionKey == null) {
            return events;
        }
        return events.stream()
                .filter(event-> StringUtils.containsAnyIgnoreCase(event.getPlace(),placeKey))
                .filter(event -> StringUtils.containsIgnoreCase(event.getEventName(), nameKey))
                .filter(event -> StringUtils.containsIgnoreCase(event.getDescription(),descriptionKey))
                .collect(Collectors.toList());
    }
    public List<Event> getEventSearchPlace(String placeKey) {
        return events.stream()
                .filter(event -> StringUtils.containsAnyIgnoreCase(event.getPlace(),placeKey))
                .collect(Collectors.toList());
    }
    public List<Event> getEventSearchName(String nameKey) {
        return events.stream()
                .filter(event -> StringUtils.containsIgnoreCase( event.getEventName(), nameKey ))
                .collect(Collectors.toList() );
    }
    public List<Event> getEventSearchDescription(String descriptionKey) {
        return events.stream()
                .filter(event -> StringUtils.containsIgnoreCase( event.getDescription(), descriptionKey ))
                .collect(Collectors.toList() );
    }
*/
}

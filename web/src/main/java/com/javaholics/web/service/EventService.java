package com.javaholics.web.service;

import com.javaholics.web.domain.Event;
import com.javaholics.web.domain.Route;
import com.javaholics.web.domain.User;
import com.javaholics.web.dto.EventDto;
import com.javaholics.web.exception.RouteNotFoundException;
import com.javaholics.web.mapper.EventMapper;
import com.javaholics.web.repository.EventRepository;
import com.javaholics.web.repository.RouteRepository;
import com.javaholics.web.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EventService {

    private EventRepository eventRepository;
    private EventMapper eventMapper;
    private UserRepository userRepository;
    private RouteRepository routeRepository;


    public List<EventDto> getEvents() {
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }

    public EventDto findEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Not found event with ID: %s".formatted(id)));
        return eventMapper.toDto(event);
    }
    public void addEvent(EventDto eventDto) {
        eventRepository.save(eventMapper.fromDto(eventDto,userRepository.getReferenceById(1l),
                routeRepository.getReferenceById(eventDto.getRoute())));
    }

    @Transactional
    public void updateEvent(EventDto eventDto) {
        Event eventToUpdate = eventRepository.findById(eventDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Cant find event by given id"));
        User user = userRepository.findById(eventDto.getOwnerOfEvent())
                .orElseThrow(() -> new IllegalArgumentException("Cant find Owner of event by given id"));
        Route route = routeRepository.findById(eventDto.getRoute())
                .orElseThrow(() -> new IllegalArgumentException("Cant find Route of event by given id"));
        eventToUpdate.setId(eventDto.getId());
        eventToUpdate.setEventName(eventDto.getEventName());
        eventToUpdate.setOwnerOfEvent(user);
        eventToUpdate.setDescription(eventDto.getDescription());
        eventToUpdate.setRoute(route);
        eventToUpdate.setRegion(eventDto.getRegion());
        eventToUpdate.setUsersCount(eventDto.getUsersCount());
        eventToUpdate.setEventDateTime(eventDto.getEventDateTime());

        eventRepository.save(eventToUpdate);
    }

    public void deleteEventById(long id) {
        eventRepository.deleteById(id);
    }

    /*private final List<Event> events;
    private final FileService fileService;


    public EventService(FileService fileService) {
        this.fileService = fileService;
        events = new ArrayList<Event>(fileService.readEventsFromFile().getEvents().values());
    }




    public Event findEventById(Long id) {
        return events.stream()
                .filter(event -> Objects.equals(event.getId(), id))
                .findFirst()
                .orElseThrow(() -> new EventNotFoundException("Not found: %s".formatted(id)));
    }



    public void deleteEventById(long id) {
        Event event = findEventById(id);
        events.remove(event);
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

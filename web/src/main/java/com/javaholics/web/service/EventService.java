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
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class EventService {

    private EventRepository eventRepository;
    private EventMapper eventMapper;
    private UserRepository userRepository;
    private RouteRepository routeRepository;


    public List<EventDto> getEvents() {
        log.info("Pokaż wszystkie eventy.");
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }
    public String useridName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            return username = ((UserDetails) principal).getUsername();
        } else {
            return username = principal.toString();
        }
    }

    public EventDto findEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Not found event with ID: %s".formatted(id)));
        return eventMapper.toDto(event);
    }
    public List<EventDto> findEventByUserId(Long id) {
        return eventRepository.findEventsByUserId(id)
                .stream()
                .filter(event -> event.getOwnerOfEvent().equals(id))
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }
    public List<EventDto> findEventsByCount(int users_count) {
        return eventRepository.findEventsByCount(users_count)
                .stream()
                .filter(event ->event.getUsersCount().equals(users_count))
                .map(eventMapper::toDto)
                .collect(Collectors.toList());
    }
    public List<EventDto> getMyEventSearch(String placeKey, String nameKey, String descriptionKey,Long id) {
        if (placeKey == null && nameKey == null && descriptionKey == null) {
            return findEventByUserId(id);
        }
        return findEventByUserId(id).stream()
//                .filter(event-> StringUtils.containsAnyIgnoreCase(event.getRegion(),placeKey))
                .filter(event -> StringUtils.containsIgnoreCase(event.getEventName(), nameKey))
                .filter(event -> StringUtils.containsIgnoreCase(event.getDescription(),descriptionKey))
                .collect(Collectors.toList());
    }
    public List<EventDto> getMyEventSearchTest(String placeKey, String nameKey, String descriptionKey,Integer users_count) {
        if (placeKey == null && nameKey == null && descriptionKey == null) {
            return findEventsByCount(users_count);
        }
        return findEventsByCount(users_count).stream()
//                .filter(event-> StringUtils.containsAnyIgnoreCase(event.getRegion(),placeKey))
                .filter(event -> StringUtils.containsIgnoreCase(event.getEventName(), nameKey))
                .filter(event -> StringUtils.containsIgnoreCase(event.getDescription(),descriptionKey))
                .collect(Collectors.toList());
    }
    public void addEvent(EventDto eventDto) {
        Long id;
        String email = useridName();
        id = userRepository.findByEmail(email).get().getId();
        eventRepository.save(eventMapper.fromDto(eventDto,userRepository.getReferenceById(id),
                routeRepository.getReferenceById(eventDto.getRoute())));
    }

    @Transactional
    public void updateEvent(EventDto eventDto) {
        log.debug("Aktualizuj event: {}", eventDto);
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
//        eventToUpdate.setRegion(eventDto.getRegion());
        eventToUpdate.setUsersCount(eventDto.getUsersCount());
        eventToUpdate.setEventDateTime(eventDto.getEventDateTime());
        eventRepository.save(eventToUpdate);
        log.info("Event dodany z sukcesem!");
    }

    public void deleteEventById(long id) {
        log.debug("Usuwanie eventu: {}", id);
        eventRepository.deleteById(id);
        log.info("Event usunięty z sukcesem!");
    }

    public List<EventDto> getEventSearch(String placeKey, String nameKey, String descriptionKey) {
        if (placeKey == null && nameKey == null && descriptionKey == null) {
            return getEvents();
        }
        return getEvents().stream()
//                .filter(event-> StringUtils.containsAnyIgnoreCase(event.getRegion(),placeKey))
                .filter(event -> StringUtils.containsIgnoreCase(event.getEventName(), nameKey))
                .filter(event -> StringUtils.containsIgnoreCase(event.getDescription(),descriptionKey))
                .collect(Collectors.toList());
    }
}

package com.javaholics.web.mapper;

import com.javaholics.web.domain.Event;
import com.javaholics.web.domain.Route;
import com.javaholics.web.domain.User;
import com.javaholics.web.dto.EventDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventMapper {

    public Event fromDto(EventDto eventDto, User user, Route route){
        return Event.builder()
                .id(eventDto.getId())
                .eventName(eventDto.getEventName())
                .description(eventDto.getDescription())
                .eventDateTime(eventDto.getEventDateTime())
                .createDate(eventDto.getCreateDate())
                .region(eventDto.getRegion())
                .usersCount(eventDto.getUsersCount())
                .ownerOfEvent(user)
                .route(route)
                .createDate(LocalDateTime.now())
                .build();
    }

    public EventDto toDto(Event event){
        return EventDto.builder()
                .id(event.getId())
                .eventName(event.getEventName())
//                .place(event.getPlace())
                .route(event.getRoute().getId())
//                .route(1l)
                .description(event.getDescription())
                .eventDateTime(event.getEventDateTime())
//                .createDate(event.getCreateDate())
                .region(event.getRegion())
                .usersCount(event.getUsersCount())
                .ownerOfEvent(1l)
                .build();
    }

}

package com.javaholics.web.mapper;

import com.javaholics.web.domain.Event;
import com.javaholics.web.dto.EventDto;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {

    public Event fromDto(EventDto eventDto){
        return Event.builder()
                .id(eventDto.getId())
                .eventName(eventDto.getEventName())
                .place(eventDto.getPlace())
                .description(eventDto.getDescription())
                .eventDateTime(eventDto.getEventDateTime())
                .createDate(eventDto.getCreateDate())
                .region(eventDto.getRegion())
                .usersCount(eventDto.getUsersCount())
                .ownerOfEvent(eventDto.getOwnerOfEvent())
                .build();
    }

    public EventDto toDto(Event event){
        return EventDto.builder()
                .id(event.getId())
                .eventName(event.getEventName())
                .place(event.getPlace())
                .description(event.getDescription())
                .eventDateTime(event.getEventDateTime())
                .createDate(event.getCreateDate())
                .region(event.getRegion())
                .usersCount(event.getUsersCount())
                .ownerOfEvent(event.getOwnerOfEvent())
                .build();
    }

}

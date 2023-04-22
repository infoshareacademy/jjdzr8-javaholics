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
                .time(eventDto.getTime())
                .region(eventDto.getRegion())
                .build();
    }

    public EventDto toDto(Event event){
        return EventDto.builder()
                .id(event.getId())
                .eventName(event.getEventName())
                .place(event.getPlace())
                .description(event.getDescription())
                .time(event.getTime())
                .region(event.getRegion())
                .build();
    }

}

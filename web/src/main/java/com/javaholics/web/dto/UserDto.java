package com.javaholics.web.dto;

import com.javaholics.web.domain.Event;
import com.javaholics.web.domain.Route;
import com.javaholics.web.domain.SexChoice;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {

    private Long id;

    private List<Event> events;

    private List<Route> routes;

    private String name;

    private String lastName;

    private String login;

    private SexChoice sex;

    private String image;

    private String location;

    private String prefferedRegionEvents;

    private String dectription;

}

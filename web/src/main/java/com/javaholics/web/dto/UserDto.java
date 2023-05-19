package com.javaholics.web.dto;

import com.javaholics.web.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private List<Event> events;

    private List<Route> routes;

    private String name;

    private String lastName;

    private String login;

    private SexChoice sex;

    private String email;

    private String location;

    private Region prefferedRegionEvents;

    private String desctription;

    private UserProvider loginProvider;

    private String password;

    private UserRoles role;

}

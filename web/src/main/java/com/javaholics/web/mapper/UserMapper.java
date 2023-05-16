package com.javaholics.web.mapper;

import com.javaholics.web.config.SecurityConfiguration;
import com.javaholics.web.domain.User;
import com.javaholics.web.domain.UserRoles;
import com.javaholics.web.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Data
public class UserMapper {

    public User fromDto(UserDto userDto){


        return User.builder()
                .id(userDto.getId())
                .events(userDto.getEvents())
                .routes(userDto.getRoutes())
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .login(userDto.getLogin())
                .sex(userDto.getSex())
                .email(userDto.getEmail())
                .location(userDto.getLocation())
                .prefferedRegionEvents(userDto.getPrefferedRegionEvents())
                .desctription(userDto.getDesctription())
                .loginProvider(userDto.getLoginProvider())
                .password(security.encoder().encode(userDto.getPassword()))
                .role(UserRoles.USER)
                .build();
    }

    public UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .events(user.getEvents())
                .routes(user.getRoutes())
                .name(user.getName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .sex(user.getSex())
                .email(user.getEmail())
                .location(user.getLocation())
                .prefferedRegionEvents(user.getPrefferedRegionEvents())
                .desctription(user.getDesctription())
                .loginProvider(user.getLoginProvider())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}

package com.javaholics.web.mapper;

import com.javaholics.web.domain.Route;
import com.javaholics.web.domain.User;
import com.javaholics.web.dto.RouteDto;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Data
public class RouteMapper {

    public Route fromDto(RouteDto routeDto,User user){


        return Route.builder()
                .id(routeDto.getId())
                .name(routeDto.getName())
                .length(routeDto.getLength())
                .locality(routeDto.getLocality())
                .placeStart(routeDto.getPlaceStart())
                .placeStop(routeDto.getPlaceStop())
                .avgRating(routeDto.getAvgRating())
                .difficulty(routeDto.getDifficulty())
                .routeType(routeDto.getType())
                .createDate(LocalDateTime.now())
//                .routeOwner(routeDto.getRouteOwner())
                .region(routeDto.getRegion())
                .routeOwner(user)
                .build();
    }

    public RouteDto toDto(Route route){
        return RouteDto.builder()
                .id(route.getId())
                .name(route.getName())
                .length(route.getLength())
                .locality(route.getLocality())
                .placeStart(route.getPlaceStart())
                .placeStop(route.getPlaceStop())
                .avgRating(route.getAvgRating())
                .difficulty(route.getDifficulty())
                .type(route.getRouteType())
//                .routeOwner(route.getRouteOwner())
                .region(route.getRegion())
                .createDate(route.getCreateDate())
                .routeOwner(route.getRouteOwner().getId().intValue())
                .build();
    }
}

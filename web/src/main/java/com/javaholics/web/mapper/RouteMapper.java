package com.javaholics.web.mapper;

import com.javaholics.web.domain.Route;
import com.javaholics.web.dto.RouteDto;
import org.springframework.stereotype.Service;

@Service
public class RouteMapper {

    public Route fromDto(RouteDto routeDto){
        return Route.builder()
                .id(routeDto.getId())
                .name(routeDto.getName())
                .length(routeDto.getLength())
                .locality(routeDto.getLocality())
                .placeStart(routeDto.getPlaceStart())
                .placeStop(routeDto.getPlaceStop())
                .avgRating(routeDto.getAvgRating())
                .difficulty(routeDto.getDifficulty())
                .type(routeDto.getType())
                .routeOwner(routeDto.getRouteOwner())
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
                .type(route.getType())
                .routeOwner(route.getRouteOwner())
                .build();
    }
}

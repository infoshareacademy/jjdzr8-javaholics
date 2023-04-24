package com.javaholics.web.mapper;

import com.javaholics.web.domain.Route;
import com.javaholics.web.domain.User;
import com.javaholics.web.dto.RouteDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class RouteMapper {

//    @PersistenceContext
//    private final EntityManager entityManager=null;
//    User user = entityManager.find(User.class,1);


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
                .type(routeDto.getType())
                .createDate(routeDto.getCreateDate())
//                .routeOwner(routeDto.getRouteOwner())
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
                .type(route.getType())
//                .routeOwner(route.getRouteOwner())
                .routeOwner(1)
//                .createDate(route.getCreateDate())
                .build();
    }
}

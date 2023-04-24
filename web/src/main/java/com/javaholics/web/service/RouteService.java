package com.javaholics.web.service;

import com.javaholics.web.dto.RouteDto;
import com.javaholics.web.exception.RouteNotFoundException;
import com.javaholics.web.mapper.RouteMapper;
import com.javaholics.web.repository.*;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import com.javaholics.web.domain.Route;

@Service
@AllArgsConstructor
public class RouteService{

    private RouteRepository routeRepository;
    private RouteMapper routeMapper;
    private UserRepository userRepository;


    public List<RouteDto> getRoutes() {
        return routeRepository.findAll()
                .stream()
                .map(routeMapper::toDto)//FIXME
                .collect(Collectors.toList());
    }

    public RouteDto findRouteById(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Not found route with ID: %s".formatted(id)));
        return routeMapper.toDto(route);
    }
    public void addRoute(RouteDto routeDto) {
        //FIXME wrzuca zawsze usera no.1 do zmiany kiedy security
        routeRepository.save(routeMapper.fromDto(routeDto,userRepository.getReferenceById(1l)));
    }

    public void editRouteById(RouteDto routeDto) {
        Route routeToEdit = routeRepository.findById(routeDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Cant find product by given id"));

        routeToEdit.setName(routeToEdit.getName());
        routeToEdit.setLocality(routeToEdit.getLocality());
        routeToEdit.setPlaceStart(routeToEdit.getPlaceStart());
        routeToEdit.setPlaceStop(routeToEdit.getPlaceStop());
        routeToEdit.setDifficulty(routeToEdit.getDifficulty());
        routeToEdit.setRouteFile(routeToEdit.getRouteFile());
        routeToEdit.setRouteOwner(routeToEdit.getRouteOwner());
//        routeToEdit.setRouteOwner(userRepository.getReferenceById(1l));
        routeToEdit.setAvgRating(routeToEdit.getAvgRating());
        routeToEdit.setType(routeToEdit.getType());
        routeToEdit.setLength(routeToEdit.getLength());
        routeToEdit.setCreateDate(routeToEdit.getCreateDate());
        routeRepository.save(routeToEdit);

    }

    public void deleteRouteById(long id) {
        routeRepository.deleteById(id);
    }


  /*

    public List<Route> getRoutesSearch(String lokalKey, String typeKey, String difficulty) {
        if (lokalKey == null && typeKey == null && difficulty == null) {
            return routes;
        }
        return routes.stream()
                .filter(route -> StringUtils.containsIgnoreCase(route.getLocality(), lokalKey))
                .filter(route -> StringUtils.containsIgnoreCase(route.getType(), typeKey))
                .filter(route -> StringUtils.containsIgnoreCase(route.getDifficulty().name(),difficulty))
                .collect(Collectors.toList());
    }
    public List<Route> getRoutesSearchType(String typeKey) {
        return routes.stream()
                .filter(route -> StringUtils.containsIgnoreCase( route.getType(), typeKey))
                .collect(Collectors.toList() );
    }
    public List<Route> getRoutesSearchLocality(String locKey) {
        return routes.stream()
                .filter(route -> StringUtils.containsIgnoreCase( route.getLocality(), locKey ))
                .collect(Collectors.toList() );
    }
    public List<Route> getRoutesSearchDifficulty(String difficulty) {
        return routes.stream()
                .filter(route -> StringUtils.containsIgnoreCase( route.getDifficulty().name(), difficulty ))
                .collect(Collectors.toList() );
    }



}*/
}
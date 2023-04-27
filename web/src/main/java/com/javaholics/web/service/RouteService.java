package com.javaholics.web.service;

import com.javaholics.web.dto.RouteDto;
import com.javaholics.web.exception.RouteNotFoundException;
import com.javaholics.web.mapper.RouteMapper;
import com.javaholics.web.repository.*;
import jakarta.transaction.Transactional;
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
@Transactional
    public void updateRoute(RouteDto routeDto) {
        Route routeToUpdate = routeRepository.findById(routeDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Cant find product by given id"));

        routeToUpdate.setName(routeToUpdate.getName());
        routeToUpdate.setLocality(routeToUpdate.getLocality());
        routeToUpdate.setPlaceStart(routeToUpdate.getPlaceStart());
        routeToUpdate.setPlaceStop(routeToUpdate.getPlaceStop());
        routeToUpdate.setDifficulty(routeToUpdate.getDifficulty());
        routeToUpdate.setRouteFile(routeToUpdate.getRouteFile());
        routeToUpdate.setType(routeToUpdate.getType());
        routeToUpdate.setLength(routeToUpdate.getLength());
        routeRepository.save(routeToUpdate);

    }

    public void deleteRouteById(long id) {
        routeRepository.deleteById(id);
    }



/*    public List<RouteDto> getRoutesSearch(String lokalKey, String typeKey, String difficulty) {
        if (lokalKey == null && typeKey == null && difficulty == null) {
            return getRoutes();
        }
        return getRoutes().stream()
                .filter(route -> StringUtils.containsIgnoreCase(route.getLocality(), lokalKey))
                .filter(route -> StringUtils.containsIgnoreCase(route.getType(), typeKey))
                .filter(route -> StringUtils.containsIgnoreCase(route.getDifficulty().name(),difficulty))
                .collect(Collectors.toList());
    }*/
/*    public List<RouteDto> getRoutesSearchType(String typeKey) {
        return routeRepository.findRoutesByTypeIgnoreCase(typeKey)
                .stream()
                .map(routeMapper::toDto)
                .collect(Collectors.toList());
    }*/
/*    public List<RouteDto> getRoutesSearchLocality(String locKey) {
        return routes.stream()
                .filter(route -> StringUtils.containsIgnoreCase( route.getLocality(), locKey ))
                .collect(Collectors.toList() );
    }
    public List<Route> getRoutesSearchDifficulty(String difficulty) {
        return routes.stream()
                .filter(route -> StringUtils.containsIgnoreCase( route.getDifficulty().name(), difficulty ))
                .collect(Collectors.toList() );
    }*/



}
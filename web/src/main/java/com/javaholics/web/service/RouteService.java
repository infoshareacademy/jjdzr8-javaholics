package com.javaholics.web.service;

import com.javaholics.web.domain.Route;
import com.javaholics.web.domain.User;
import com.javaholics.web.dto.RouteDto;
import com.javaholics.web.exception.RouteNotFoundException;
import com.javaholics.web.mapper.RouteMapper;
import com.javaholics.web.repository.RouteRepository;
import com.javaholics.web.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RouteService {

    private RouteRepository routeRepository;
    private RouteMapper routeMapper;
    private UserRepository userRepository;


    public List<RouteDto> getRoutes() {
        return routeRepository.findAll()
                .stream()
                .map(routeMapper::toDto)
                .collect(Collectors.toList());
    }

    public RouteDto findRouteById(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Not found route with ID: %s".formatted(id)));
        return routeMapper.toDto(route);
    }

    public void addRoute(RouteDto routeDto) {
        //FIXME wrzuca zawsze usera no.1 do zmiany kiedy security
        routeRepository.save(routeMapper.fromDto(routeDto, userRepository.getReferenceById(1l)));
    }

    @Transactional
    public void updateRoute(RouteDto routeDto) {
        Route routeToUpdate = routeRepository.findById(routeDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Cant find route by given id"));
        routeToUpdate.setName(routeDto.getName());
        routeToUpdate.setLocality(routeDto.getLocality());
        routeToUpdate.setPlaceStart(routeDto.getPlaceStart());
        routeToUpdate.setPlaceStop(routeDto.getPlaceStop());
        routeToUpdate.setDifficulty(routeDto.getDifficulty());
        routeToUpdate.setRouteFile(routeDto.getRouteFile());
        routeToUpdate.setRouteType(routeDto.getType());
        routeToUpdate.setLength(routeDto.getLength());
        routeRepository.save(routeToUpdate);
    }

    public void deleteRouteById(long id) {
        routeRepository.deleteById(id);
    }
    public String useridName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            return username = ((UserDetails) principal).getUsername();
        } else {
            return username = principal.toString();
        }
    }
    public List<RouteDto> findRouteByUserId(Long id) {
        return routeRepository.findRoutesByUserId(id)
                .stream()
                .filter(route -> route.getRouteOwner().getId().equals(id))
                .map(routeMapper::toDto)
                .collect(Collectors.toList());
    }
    public List<RouteDto> findRouteByLenght(double length) {
        return routeRepository.findRoutesByLength(length)
                .stream()
                .filter(route -> (route.getLength()==length))
                .map(routeMapper::toDto)
                .collect(Collectors.toList());
    }
    public List<RouteDto> getMyRoutesSearchTest(String lokalKey, String typeKey, String difficulty, double length) {
        if (lokalKey == null && typeKey == null && difficulty == null) {
            return findRouteByLenght(length);
        }
        return findRouteByLenght(length).stream()
                .filter(route -> StringUtils.containsIgnoreCase(route.getLocality(), lokalKey))
                .filter(route -> StringUtils.containsIgnoreCase(route.getType().name(), typeKey))
                .filter(route -> StringUtils.containsIgnoreCase(route.getDifficulty().name(), difficulty))
                .collect(Collectors.toList());
    }
    public List<RouteDto> getMyRoutesSearch(String lokalKey, String typeKey, String difficulty, Long id) {
        if (lokalKey == null && typeKey == null && difficulty == null) {
            return findRouteByUserId(id);
        }
        return findRouteByUserId(id).stream()
                .filter(route -> StringUtils.containsIgnoreCase(route.getLocality(), lokalKey))
                .filter(route -> StringUtils.containsIgnoreCase(route.getType().name(), typeKey))
                .filter(route -> StringUtils.containsIgnoreCase(route.getDifficulty().name(), difficulty))
                .collect(Collectors.toList());
    }


    public List<RouteDto> getRoutesSearch(String lokalKey, String typeKey, String difficulty) {
        if (lokalKey == null && typeKey == null && difficulty == null) {
            return getRoutes();
        }
        return getRoutes().stream()
                .filter(route -> StringUtils.containsIgnoreCase(route.getLocality(), lokalKey))
                .filter(route -> StringUtils.containsIgnoreCase(route.getType().name(), typeKey))
                .filter(route -> StringUtils.containsIgnoreCase(route.getDifficulty().name(), difficulty))
                .collect(Collectors.toList());
    }
//    public List<RouteDto> getRoutesSearchId(Long id) {
//        return getRoutes().stream()
//                .filter(route -> (int)route.getId(), id)
//                .collect(Collectors.toList());
//    }
    public String findbyname() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            return username = ((UserDetails) principal).getUsername();
        } else {
            return username = principal.toString();
        }
    }
}
package com.javaholics.web.repository;

import com.javaholics.web.domain.Event;
import com.javaholics.web.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {

    List<Route> findRoutesByLocality(String locality);
    List<Route> findRoutesByTypeIgnoreCase(String locality);
    List<Route> findRoutesByDifficulty(String difficulty);


}

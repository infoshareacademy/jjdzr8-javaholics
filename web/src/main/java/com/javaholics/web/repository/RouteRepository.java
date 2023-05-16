package com.javaholics.web.repository;

import com.javaholics.web.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
    @Query(value = "SELECT * FROM routes WHERE user_id = :id ", nativeQuery = true)
    List<Route> findRoutesByUserId (@Param("id") Long id);
    @Query(value = "SELECT * FROM routes WHERE length = :length ", nativeQuery = true)
    List<Route> findRoutesByLength(@Param("length") double length);


    List<Route> findRoutesByLocality(String locality);
    List<Route> findRoutesByLocalityIsLikeAndRouteTypeIsLikeAndDifficultyIsLike(String locality, String type, String difficulty);

}

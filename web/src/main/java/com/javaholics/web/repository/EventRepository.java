package com.javaholics.web.repository;

import com.javaholics.web.domain.Event;
import com.javaholics.web.domain.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    @Query(value = "SELECT * FROM events WHERE user_id = :id ", nativeQuery = true)
    List<Event> findEventsByUserId (@Param("id") Long id);
    @Query(value = "SELECT * FROM events WHERE users_count = :users_count ", nativeQuery = true)
    List<Event> findEventsByCount (@Param("users_count") Integer users_count);

}

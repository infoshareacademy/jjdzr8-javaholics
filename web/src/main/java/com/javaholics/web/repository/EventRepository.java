package com.javaholics.web.repository;

import com.javaholics.web.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long>
{
    List<Event> findByEventName(String name);
    List<Event> findAllByPlaceOrEventNameOrDescription(String place, String naem, String description);
}

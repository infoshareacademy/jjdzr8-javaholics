package com.javaholics.web.repository;

import com.javaholics.web.domain.Event;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class EventDao implements Dao<Event>
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Event find(Long id) {
        return entityManager.find(Event.class,id);
    }

    @Override
    public Collection<Event> findAll() {
        return null;
    }

    @Override
    public void save(Event event) {

    }

    @Override
    public Event update(Event event) {
        return null;
    }

    @Override
    public void delete(Event event) {

    }
}

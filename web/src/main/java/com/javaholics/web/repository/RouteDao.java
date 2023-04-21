package com.javaholics.web.repository;

import com.javaholics.web.domain.Route;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public class RouteDao implements Dao<Route>{
    @Override
    public Route find(Long id) {
        return null;
    }

    @Override
    public Collection<Route> findAll() {
        return null;
    }

    @Override
    public void save(Route route) {

    }

    @Override
    public Route update(Route route) {
        return null;
    }

    @Override
    public void delete(Route route) {

    }
}

package com.javaholics.web.repository;

import com.javaholics.web.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public class UserDao implements Dao<User>{
    @Override
    public User find(Long id) {
        return null;
    }

    @Override
    public Collection<User> findAll() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}

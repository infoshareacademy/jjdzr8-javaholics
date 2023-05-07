package com.javaholics.web.repository;

import com.javaholics.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    default List<User> checkIfAlreadyUserExist(final long id) {
        return null;
    }

}

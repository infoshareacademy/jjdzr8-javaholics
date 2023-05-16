package com.javaholics.web.repository;

import com.javaholics.web.domain.User;
import com.javaholics.web.domain.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findFirstByRole(UserRoles role);
}

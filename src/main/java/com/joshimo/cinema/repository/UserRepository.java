package com.joshimo.cinema.repository;

import com.joshimo.cinema.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.name = :name and u.password = :password")
    Optional<User> findUserByNameAndPassword(@Param("name") String name, @Param("password") String password);

}

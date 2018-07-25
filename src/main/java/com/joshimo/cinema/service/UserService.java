package com.joshimo.cinema.service;

import com.joshimo.cinema.enity.User;

public interface UserService {

    User findUserById(Long id);

    User findUserByNameAndPassword(User user);

    User addNewUser(User user);

    void removeUserById(Long id);

}

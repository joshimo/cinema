package com.joshimo.cinema.service.implementation;

import com.joshimo.cinema.enity.User;
import com.joshimo.cinema.exception.NoSuchTicketException;
import com.joshimo.cinema.exception.NoSuchUserException;
import com.joshimo.cinema.repository.UserRepository;
import com.joshimo.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchUserException());
    }

    @Override
    public User findUserByNameAndPassword(User user) {
        return userRepository.findUserByNameAndPassword(user.getName(), user.getPassword()).orElseThrow(() -> new NoSuchUserException());
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeUserById(Long id) {
        userRepository.deleteById(id);
    }
}

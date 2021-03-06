package com.joshimo.cinema.controller;

import com.joshimo.cinema.enity.User;
import com.joshimo.cinema.enity.UserRole;
import com.joshimo.cinema.enity.dto.UserRequest;
import com.joshimo.cinema.enity.dto.UserResponse;
import com.joshimo.cinema.enity.implementation.UserRequestResponseConverter;
import com.joshimo.cinema.exception.PermissionException;
import com.joshimo.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@Scope("session")
@SessionAttributes("user")
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserRequestResponseConverter userConverter;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserConverter(UserRequestResponseConverter userConverter) {
        this.userConverter = userConverter;
    }

    @GetMapping("/show/{id}")
    public UserResponse getUserById(@PathVariable Long id, @SessionAttribute("user") User user) {
        if (!(user.getId().equals(id) || user.getUserRole() == UserRole.ADMIN)) {
            throw new PermissionException();
        }
        User requestedUser = userService.findUserById(id);
        return userConverter.entityToResponse(requestedUser);
    }

    @PostMapping("/add")
    public ResponseEntity addNewUser(@RequestBody UserRequest request) {
        User user = userConverter.requestToEntity(request);
        User saved = userService.addNewUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/remove/{id}")
    public void removeUser(@PathVariable Long id, @SessionAttribute("user") User user) {
        System.out.println("UserController user = " + user);
        if (user.getId().equals(id) || user.getUserRole() == UserRole.ADMIN) {
            userService.removeUserById(id);
        } else {
            throw new PermissionException();
        }
    }
}
package com.joshimo.cinema.controller;

import com.joshimo.cinema.enity.User;
import com.joshimo.cinema.enity.dto.UserRequest;
import com.joshimo.cinema.enity.implementation.UserRequestResponseConverter;
import com.joshimo.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@Scope("session")
@SessionAttributes("user")
public class LoginController {

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

    @PostMapping("/login")
    public String login(@RequestBody UserRequest userRequest, Model model) {
        User logInUser = userConverter.requestToEntity(userRequest);
        User user = userService.findUserByNameAndPassword(logInUser);
        model.addAttribute("user", user);
        return "ok";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        User guestUser = new User();
        guestUser.setName("Guest");
        guestUser.setPassword("");
        User user = userService.findUserByNameAndPassword(guestUser);
        model.addAttribute("user", user);
        return "ok";
    }
}

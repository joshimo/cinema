package com.joshimo.cinema.controller;

import com.joshimo.cinema.enity.User;
import com.joshimo.cinema.enity.dto.UserRequest;
import com.joshimo.cinema.enity.implementation.UserRequestResponseConverter;
import com.joshimo.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Scope("session")
@SessionAttributes(value = "user")
public class LoginController {

    UserService userService;
    UserRequestResponseConverter userConverter;

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
}

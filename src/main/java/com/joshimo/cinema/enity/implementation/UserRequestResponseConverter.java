package com.joshimo.cinema.enity.implementation;

import com.joshimo.cinema.enity.EntityRequestResponseConverter;
import com.joshimo.cinema.enity.User;
import com.joshimo.cinema.enity.UserRole;
import com.joshimo.cinema.enity.dto.UserRequest;
import com.joshimo.cinema.enity.dto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserRequestResponseConverter implements EntityRequestResponseConverter<UserRequest, User, UserResponse> {

    @Override
    public User requestToEntity(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setNotes(request.getNotes());
        user.setUserRole(UserRole.USER);
        return user;
    }

    @Override
    public UserResponse entityToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setNotes(user.getNotes());
        return response;
    }
}
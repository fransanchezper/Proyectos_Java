package com.todocodeacademy.users_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.users_service.dto.UserDTO;
import com.todocodeacademy.users_service.service.IUserService;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService servUsu;

    @GetMapping("/posts/{user_id}")
    public UserDTO getUserAndPosts(@PathVariable Long user_id) {
        UserDTO user = servUsu.getUserAndPosts(user_id);
        return user;
    }
    
}

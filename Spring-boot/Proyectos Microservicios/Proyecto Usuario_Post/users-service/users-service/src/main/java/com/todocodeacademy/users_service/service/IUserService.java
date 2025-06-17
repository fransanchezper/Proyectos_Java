package com.todocodeacademy.users_service.service;

import com.todocodeacademy.users_service.dto.UserDTO;

public interface IUserService {

    public UserDTO getUserAndPosts(Long user_id);
}

package com.todocodeacademy.users_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.users_service.dto.PostDTO;
import com.todocodeacademy.users_service.dto.UserDTO;
import com.todocodeacademy.users_service.model.User;
import com.todocodeacademy.users_service.repository.IPostAPI;
import com.todocodeacademy.users_service.repository.IUserRepository;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepo;

    @Autowired
    private IPostAPI apiPosts;

    @Override
    public UserDTO getUserAndPosts(Long user_id) {
        //datos del usuario de la base de datos
        User user = userRepo.findById(user_id).orElse(null);

        // Una vez que tengo los datosnecesito los POSTEOS
        //Traigo posteos desde la API de posteos
        List<PostDTO> postList = apiPosts.getPostsByUserBy(user_id);
        //Unificar datos del usuario + Posteos
        UserDTO userDTO = new UserDTO(user.getUser_id(), user.getName(), user.getLastname(), user.getCellphone(), postList);

       return userDTO;
    }

    
}

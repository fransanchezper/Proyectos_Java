package com.todocodeacademy.users_service.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todocodeacademy.users_service.dto.PostDTO;

@FeignClient(name = "posts-service")    // no hace falta poner la URL por que con eureka nos permite al llamarse igual que el proyecto
public interface IPostAPI {

    @GetMapping("/posts/{user_id}")
    public List<PostDTO> getPostsByUserBy(@PathVariable("user_id") Long user_id);
        
     

}

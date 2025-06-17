package com.todocodeacademy.post_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.post_service.model.Post;
import com.todocodeacademy.post_service.service.IPostService;


@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostService postServi;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/{user_id}")
    public List<Post> getPostByUserId(@PathVariable Long user_id) {
        System.out.println("--------Estoy en el puerto  "+serverPort);
        return postServi.getPostsByUser(user_id) ;
    }
    
}

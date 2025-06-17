package com.todocodeacademy.post_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.post_service.model.Post;
import com.todocodeacademy.post_service.repository.IPostRepository;

@Service
public class PostService implements IPostService{

    @Autowired
    private IPostRepository repoPost;

    public List<Post> getPostsByUser(Long user_id){
        return repoPost.findPostByUserId(user_id);
    }
}

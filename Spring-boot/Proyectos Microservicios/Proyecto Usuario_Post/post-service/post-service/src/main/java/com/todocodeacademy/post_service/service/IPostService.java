package com.todocodeacademy.post_service.service;

import java.util.List;

import com.todocodeacademy.post_service.model.Post;

public interface IPostService {

    public List<Post> getPostsByUser(Long user_id);
}

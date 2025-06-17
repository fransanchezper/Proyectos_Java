package com.todocodeacademy.post_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.post_service.model.Post;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long>{
    
    @Query("SELECT p FROM Post p WHERE p.user_id =:user_id")
    List<Post> findPostByUserId(Long user_id);
}

package com.todocodeacademy.users_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.users_service.model.User;
@Repository
public interface IUserRepository extends JpaRepository<User,Long>{

    
}

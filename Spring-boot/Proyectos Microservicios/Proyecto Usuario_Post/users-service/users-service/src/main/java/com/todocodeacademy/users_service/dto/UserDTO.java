package com.todocodeacademy.users_service.dto;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class UserDTO {

    private Long user_id;
    private String name;
    private String lastname;
    private String cellphone;
    private List<PostDTO> postsList;

}

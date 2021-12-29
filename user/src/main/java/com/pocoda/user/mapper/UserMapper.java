package com.pocoda.user.mapper;

import com.pocoda.user.database.model.User;
import com.pocoda.user.model.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse userToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .password(user.getPassword())
                .city(user.getCity())
                .build();
    }
}

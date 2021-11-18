package com.pocoda.user.service.implementation;

import com.pocoda.user.model.User;
import com.pocoda.user.model.request.UserRequest;
import com.pocoda.user.model.response.UserResponse;
import com.pocoda.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<User> users;

    public UserServiceImpl() {
        users = Collections.singletonList(User.builder()
                .id(1L)
                .username("admin")
                .firstName("Adam")
                .lastName("Adminowicz")
                .password("21232f297a57a5a743894a0e4a801fc3")
                .build());
    }

    @Override
    public UserResponse getById(Long userId) {
        var user = users.stream().filter(item -> item.getId().equals(userId)).findFirst().orElseThrow();
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();
    }

    @Override
    public UserResponse getByUsername(String username) {
        var user = users.stream().filter(item -> item.getUsername().equals(username)).findFirst().orElseThrow();
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();
    }

    @Override
    public UserResponse create(UserRequest request) {
        var id = (long) users.size();
        var user = User.builder()
                .id(id)
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .build();
        users.add(user);

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();
    }
}

package com.pocoda.user.service.implementation;

import com.pocoda.user.database.model.User;
import com.pocoda.user.database.repository.UserRepository;
import com.pocoda.user.model.request.UserRequest;
import com.pocoda.user.model.response.UserResponse;
import com.pocoda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse getById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .password(user.getPassword())
                .build();
    }

    @Override
    public UserResponse getByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .password(user.getPassword())
                .build();
    }

    @Override
    public UserResponse create(UserRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .password(request.getPassword())
                .build();
        userRepository.save(user);

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .password(user.getPassword())
                .build();
    }
}

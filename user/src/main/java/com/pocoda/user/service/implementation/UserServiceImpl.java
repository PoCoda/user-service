package com.pocoda.user.service.implementation;

import com.pocoda.user.database.model.User;
import com.pocoda.user.database.repository.UserRepository;
import com.pocoda.user.mapper.UserMapper;
import com.pocoda.user.model.City;
import com.pocoda.user.model.request.UpdateCityRequest;
import com.pocoda.user.model.request.UserRequest;
import com.pocoda.user.model.response.UserResponse;
import com.pocoda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponse getById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return userMapper.userToUserResponse(user);
    }

    @Override
    public UserResponse getByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        return userMapper.userToUserResponse(user);
    }

    @Override
    public UserResponse create(UserRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .password(request.getPassword())
                .city(request.getCity())
                .build();
        userRepository.save(user);

        return userMapper.userToUserResponse(user);
    }

    @Override
    public UserResponse updateCity(UpdateCityRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow();
        user.setCity(request.getCity());
        userRepository.save(user);

        return userMapper.userToUserResponse(user);
    }
}

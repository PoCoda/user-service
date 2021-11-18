package com.pocoda.user.service;

import com.pocoda.user.model.request.UserRequest;
import com.pocoda.user.model.response.UserResponse;

public interface UserService {
    UserResponse getById(Long userId);

    UserResponse getByUsername(String username);

    UserResponse create(UserRequest request);
}

package com.pocoda.user.controller;

import com.pocoda.user.model.request.UserRequest;
import com.pocoda.user.model.response.UserResponse;
import com.pocoda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getById(@PathVariable("userId") Long userId) {
        var result = userService.getById(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponse> getByUsername(@PathVariable("username") String username) {
        var result = userService.getByUsername(username);
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        var result = userService.create(request);
        return ResponseEntity.ok(result);
    }
}

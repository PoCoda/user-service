package com.pocoda.user.model.response;

import com.pocoda.user.model.City;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private City city;
}

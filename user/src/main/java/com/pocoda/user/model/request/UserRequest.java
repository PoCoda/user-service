package com.pocoda.user.model.request;

import com.pocoda.user.model.City;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class UserRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private City city;
}

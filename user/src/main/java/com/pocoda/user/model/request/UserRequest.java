package com.pocoda.user.model.request;

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
}

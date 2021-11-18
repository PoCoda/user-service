package com.pocoda.user.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
}

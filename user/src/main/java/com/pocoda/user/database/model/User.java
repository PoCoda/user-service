package com.pocoda.user.database.model;

import com.pocoda.user.model.City;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "city", nullable = false)
    @Enumerated(EnumType.STRING)
    private City city;
}

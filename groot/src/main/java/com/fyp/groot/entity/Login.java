package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private OffsetDateTime lastLogin;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String emailId;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private OffsetDateTime userSince;

    @Column
    private String status;

    @OneToMany(mappedBy = "user")
    private List<User> userUsers;


}

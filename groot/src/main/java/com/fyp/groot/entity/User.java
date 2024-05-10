package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(nullable = false, updatable = false)
    private String devideUsed;

    @Column
    private String firebaseId;

    @Column
    private Boolean isActive;

    @Column
    private String password;

    @Column(name = "\"role\"", columnDefinition = "longtext")
    private String role;

    @Column
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Admin> userAdmins;

    @ManyToMany
    @JoinTable(
            name = "Businessowner",
            joinColumns = @JoinColumn(name = "devideUsed"),
            inverseJoinColumns = @JoinColumn(name = "planId")
    )
    private List<Plan> businessownerPlans;

    @OneToMany(mappedBy = "user")
    private List<Event> userEvents;

    @OneToMany(mappedBy = "user")
    private List<Personalinterest> userPersonalinterests;

    @OneToMany(mappedBy = "user")
    private List<Review> userReviews;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Login user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "culture_id")
    private Culture culture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;

    

}

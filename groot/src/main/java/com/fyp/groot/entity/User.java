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
import java.util.Set;


@Entity
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
    private Set<Admin> userAdmins;

    @ManyToMany
    @JoinTable(
            name = "Businessowner",
            joinColumns = @JoinColumn(name = "devideUsed"),
            inverseJoinColumns = @JoinColumn(name = "planId")
    )
    private Set<Plan> businessownerPlans;

    @OneToMany(mappedBy = "user")
    private Set<Event> userEvents;

    @OneToMany(mappedBy = "user")
    private Set<Personalinterest> userPersonalinterests;

    @OneToMany(mappedBy = "user")
    private Set<Review> userReviews;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Login user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "culture_id")
    private Culture culture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;

    public String getDevideUsed() {
        return devideUsed;
    }

    public void setDevideUsed(final String devideUsed) {
        this.devideUsed = devideUsed;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(final String firebaseId) {
        this.firebaseId = firebaseId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(final Boolean isActive) {
        this.isActive = isActive;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Set<Admin> getUserAdmins() {
        return userAdmins;
    }

    public void setUserAdmins(final Set<Admin> userAdmins) {
        this.userAdmins = userAdmins;
    }

    public Set<Plan> getBusinessownerPlans() {
        return businessownerPlans;
    }

    public void setBusinessownerPlans(final Set<Plan> businessownerPlans) {
        this.businessownerPlans = businessownerPlans;
    }

    public Set<Event> getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(final Set<Event> userEvents) {
        this.userEvents = userEvents;
    }

    public Set<Personalinterest> getUserPersonalinterests() {
        return userPersonalinterests;
    }

    public void setUserPersonalinterests(final Set<Personalinterest> userPersonalinterests) {
        this.userPersonalinterests = userPersonalinterests;
    }

    public Set<Review> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(final Set<Review> userReviews) {
        this.userReviews = userReviews;
    }

    public Login getUser() {
        return user;
    }

    public void setUser(final Login user) {
        this.user = user;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(final Culture culture) {
        this.culture = culture;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(final University university) {
        this.university = university;
    }

}

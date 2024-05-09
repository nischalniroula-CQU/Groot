package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;


@Entity
public class University {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer universityId;

    @Column
    private String universityName;

    @Column
    private String city;

    @Column
    private String location;

    @Column
    private String address;

    @OneToMany(mappedBy = "university")
    private Set<User> universityUsers;

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(final Integer universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(final String universityName) {
        this.universityName = universityName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public Set<User> getUniversityUsers() {
        return universityUsers;
    }

    public void setUniversityUsers(final Set<User> universityUsers) {
        this.universityUsers = universityUsers;
    }

}

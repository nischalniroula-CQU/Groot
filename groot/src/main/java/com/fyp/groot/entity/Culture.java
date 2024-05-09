package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;


@Entity
public class Culture {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cultureId;

    @Column
    private String cultureName;

    @Column
    private String status;

    @OneToMany(mappedBy = "culture")
    private Set<Business> cultureBusinesses;

    @OneToMany(mappedBy = "culture")
    private Set<User> cultureUsers;

    public Integer getCultureId() {
        return cultureId;
    }

    public void setCultureId(final Integer cultureId) {
        this.cultureId = cultureId;
    }

    public String getCultureName() {
        return cultureName;
    }

    public void setCultureName(final String cultureName) {
        this.cultureName = cultureName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Set<Business> getCultureBusinesses() {
        return cultureBusinesses;
    }

    public void setCultureBusinesses(final Set<Business> cultureBusinesses) {
        this.cultureBusinesses = cultureBusinesses;
    }

    public Set<User> getCultureUsers() {
        return cultureUsers;
    }

    public void setCultureUsers(final Set<User> cultureUsers) {
        this.cultureUsers = cultureUsers;
    }

}

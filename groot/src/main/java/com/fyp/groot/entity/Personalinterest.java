package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Set;


@Entity
public class Personalinterest {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interestId;

    @OneToMany(mappedBy = "interest")
    private Set<Interestlibrary> interestInterestlibraries;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getInterestId() {
        return interestId;
    }

    public void setInterestId(final Integer interestId) {
        this.interestId = interestId;
    }

    public Set<Interestlibrary> getInterestInterestlibraries() {
        return interestInterestlibraries;
    }

    public void setInterestInterestlibraries(final Set<Interestlibrary> interestInterestlibraries) {
        this.interestInterestlibraries = interestInterestlibraries;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

}

package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;


@Entity
public class Plan {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    @Column
    private String planName;

    @Column
    private Double price;

    @ManyToMany(mappedBy = "businessownerPlans")
    private Set<User> businessownerUsers;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(final Integer planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(final String planName) {
        this.planName = planName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public Set<User> getBusinessownerUsers() {
        return businessownerUsers;
    }

    public void setBusinessownerUsers(final Set<User> businessownerUsers) {
        this.businessownerUsers = businessownerUsers;
    }

}

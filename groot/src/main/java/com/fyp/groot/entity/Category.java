package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;


@Entity
public class Category {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<Business> categoryBusinesses;

    @OneToMany(mappedBy = "category")
    private Set<Event> categoryEvents;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(final Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Business> getCategoryBusinesses() {
        return categoryBusinesses;
    }

    public void setCategoryBusinesses(final Set<Business> categoryBusinesses) {
        this.categoryBusinesses = categoryBusinesses;
    }

    public Set<Event> getCategoryEvents() {
        return categoryEvents;
    }

    public void setCategoryEvents(final Set<Event> categoryEvents) {
        this.categoryEvents = categoryEvents;
    }

}

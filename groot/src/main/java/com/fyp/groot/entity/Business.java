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
public class Business {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer businessId;

    @Column
    private String name;

    @Column
    private String subtitle;

    @Column(length = 5000)
    private String basicDetails;

    @Column
    private String contactMethod;

    @Column
    private String phoneNumber;

    @Column
    private String emailId;

    @Column
    private String location;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String priceRange;

    @Column
    private String status;

    @Column
    private String addOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "culture_id")
    private Culture culture;

    @OneToMany(mappedBy = "business")
    private Set<Businesstiming> businessBusinesstimings;

    @OneToMany(mappedBy = "business")
    private Set<Event> businessEvents;

    @OneToMany(mappedBy = "post")
    private Set<Imagelibrary> postImagelibraries;

    @OneToMany(mappedBy = "business")
    private Set<Review> businessReviews;
    
    //@OneToMany(mappedBy = "")
    //private Long ownerID;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(final Integer businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(final String subtitle) {
        this.subtitle = subtitle;
    }

    public String getBasicDetails() {
        return basicDetails;
    }

    public void setBasicDetails(final String basicDetails) {
        this.basicDetails = basicDetails;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public void setContactMethod(final String contactMethod) {
        this.contactMethod = contactMethod;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(final String priceRange) {
        this.priceRange = priceRange;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getAddOn() {
        return addOn;
    }

    public void setAddOn(final String addOn) {
        this.addOn = addOn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(final Culture culture) {
        this.culture = culture;
    }

    public Set<Businesstiming> getBusinessBusinesstimings() {
        return businessBusinesstimings;
    }

    public void setBusinessBusinesstimings(final Set<Businesstiming> businessBusinesstimings) {
        this.businessBusinesstimings = businessBusinesstimings;
    }

    public Set<Event> getBusinessEvents() {
        return businessEvents;
    }

    public void setBusinessEvents(final Set<Event> businessEvents) {
        this.businessEvents = businessEvents;
    }

    public Set<Imagelibrary> getPostImagelibraries() {
        return postImagelibraries;
    }

    public void setPostImagelibraries(final Set<Imagelibrary> postImagelibraries) {
        this.postImagelibraries = postImagelibraries;
    }

    public Set<Review> getBusinessReviews() {
        return businessReviews;
    }

    public void setBusinessReviews(final Set<Review> businessReviews) {
        this.businessReviews = businessReviews;
    }

}

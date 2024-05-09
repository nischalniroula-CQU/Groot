package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Product {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer promoId;

    @Column
    private Integer linkedId;

    @Column
    private String productTitle;

    @Column
    private String productDescription;

    @Column
    private Double price;

    @Column
    private String status;

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(final Integer promoId) {
        this.promoId = promoId;
    }

    public Integer getLinkedId() {
        return linkedId;
    }

    public void setLinkedId(final Integer linkedId) {
        this.linkedId = linkedId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(final String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(final String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}

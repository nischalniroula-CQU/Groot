package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class BusinessTiming {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timingId;

    @Column
    private String monday;

    @Column
    private String tuesday;

    @Column
    private String wednesday;

    @Column
    private String thursday;

    @Column
    private String friday;

    @Column
    private String saturday;

    @Column
    private String sunday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Business business;

}

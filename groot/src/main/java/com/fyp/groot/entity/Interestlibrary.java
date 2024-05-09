package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Interestlibrary {

    @Id
    @Column(nullable = false, updatable = false)
    private String interestLibraryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interest_id")
    private Personalinterest interest;

    public String getInterestLibraryId() {
        return interestLibraryId;
    }

    public void setInterestLibraryId(final String interestLibraryId) {
        this.interestLibraryId = interestLibraryId;
    }

    public Personalinterest getInterest() {
        return interest;
    }

    public void setInterest(final Personalinterest interest) {
        this.interest = interest;
    }

}

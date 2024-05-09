package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Tag {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    @Column
    private Integer linkedId;

    @Column
    private String tag;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(final Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getLinkedId() {
        return linkedId;
    }

    public void setLinkedId(final Integer linkedId) {
        this.linkedId = linkedId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(final String tag) {
        this.tag = tag;
    }

}

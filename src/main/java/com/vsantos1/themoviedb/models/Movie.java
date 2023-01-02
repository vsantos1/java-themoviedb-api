package com.vsantos1.themoviedb.models;


import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    private String description;

    private String imageUrl;

    @Column(name = "minimum_age")
    private Integer minimumAge;
    private String genre;

    private String summary;

    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")

    private Date updatedAt;


    public Movie(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

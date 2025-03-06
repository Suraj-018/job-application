package com.example.job.company.entity;

import com.example.job.job.entity.Job;
import com.example.job.review.entity.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "company_table")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Job> jobs;
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public Company setReviews(List<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public Company setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public Company setJobs(List<Job> jobs) {
        this.jobs = jobs;
        return this;
    }

    public Company(Long id, String name, String description, List<Job> jobs, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.jobs = jobs;
        this.reviews = reviews;
    }
}

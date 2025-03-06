package com.example.job.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String salary;
    private String location;

    public Long getId() {
        return id;
    }

    public Job setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Job setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Job setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getSalary() {
        return salary;
    }

    public Job setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Job setLocation(String location) {
        this.location = location;
        return this;
    }

    public Job() {
    }

    public Job(Long id, String title, String description, String salary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.location = location;
    }
}

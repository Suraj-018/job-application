package com.example.job.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<com.example.job.entity.Job, Long> {

}

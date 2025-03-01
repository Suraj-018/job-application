package com.example.job.Service;

import com.example.job.Entity.Job;
import java.util.List;

public interface JobService {

    List<Job> findAllJobs();

    void createJob(Job job);

    Job findJobById(int id);

    boolean updateJobById(Long id, Job updatedJob);

    boolean deleteJobById(Long id);
}

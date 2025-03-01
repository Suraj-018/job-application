package com.example.job.Service;

import com.example.job.Entity.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService{
    List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Job> findAllJobs() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job findJobById(int id) {
        for(Job job: jobs){
            if(job.getId() == id){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        for(Job currentJob: jobs){
            if (currentJob.getId().equals(id)){
                currentJob.setTitle(updatedJob.getTitle());
                currentJob.setDescription(updatedJob.getDescription());
                currentJob.setSalary(updatedJob.getSalary());
                currentJob.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}

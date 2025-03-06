package com.example.job.Service;

import com.example.job.Repository.JobRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.job.entity.Job;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobServiceImpl implements JobService{
    JobRepository jobRepository;
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    @Override
    public List<Job> findAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()){
            Job currentJob = optionalJob.get();
            currentJob.setTitle(updatedJob.getTitle());
            currentJob.setDescription(updatedJob.getDescription());
            currentJob.setSalary(updatedJob.getSalary());
            currentJob.setLocation(updatedJob.getLocation());

            jobRepository.save(currentJob);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}

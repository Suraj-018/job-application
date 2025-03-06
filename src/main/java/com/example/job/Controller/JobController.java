package com.example.job.Controller;

import com.example.job.entity.Job;
import com.example.job.Service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long id){
        Job job = jobService.findJobById(id);
        if(job!=null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createJob")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/updateJob/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job){
        boolean updated = jobService.updateJobById(id, job);
        if(updated)
            return new ResponseEntity<>("Job updated successfully", HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteJob/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted)
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
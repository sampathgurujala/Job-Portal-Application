package com.sampath.JobPortal.service;

import com.sampath.JobPortal.model.JobPost;
import com.sampath.JobPortal.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost)
    {
        jobRepo.addJobPost(jobPost);
    }

    public List<JobPost> getAllJobs()
    {
       return jobRepo.getAllJobs();
    }

    public JobPost getJob(int postId) {
        return jobRepo.getJob(postId);
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.updateJob(jobPost);
    }

    public int deleteJob(int postId) {
        return jobRepo.deleteJob(postId);
    }
}

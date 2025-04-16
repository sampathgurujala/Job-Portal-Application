package com.sampath.JobPortal.controller;


import com.sampath.JobPortal.model.JobPost;
import com.sampath.JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
    @Autowired
    private JobService jobService;


    @GetMapping("jobPosts")
    public List<JobPost> getAllPosts()
    {
        return jobService.getAllJobs();
    }

    @GetMapping(path="jobPost/{postId}",produces = "application/json")
    public JobPost getJob(@PathVariable("postId") int postId)
    {
        return jobService.getJob(postId);
    }

    @PostMapping(path = "jobPost", consumes = "application/json")
    public JobPost addJob(@RequestBody JobPost jobPost)
    {
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());

    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
       jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public ResponseEntity<String> deleteJob(@PathVariable("postId") int postId)
    {
        int statusCode = jobService.deleteJob(postId);

        if (statusCode == 200) {
            return ResponseEntity.ok("Successfully Deleted");
        }
        return ResponseEntity.status(404).body("Deletion Failed");

    }

}

package com.sampath.JobPortal.controller;

import com.sampath.JobPortal.model.JobPost;
import com.sampath.JobPortal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @RequestMapping({"/","home"})
    public String home()
    {
        return "home";
    }

    @RequestMapping("viewalljobs")
    public String viewAllJobs(Model model)
    {
        model.addAttribute("jobPosts",jobService.getAllJobs());
        return "viewalljobs";
    }

    @RequestMapping("addjob")
    public String addJob()
    {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(@ModelAttribute("jobPost") JobPost jobPost){
        jobService.addJob(jobPost);
        return "success";
    }


}

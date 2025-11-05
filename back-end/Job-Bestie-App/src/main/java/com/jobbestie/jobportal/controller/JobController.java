package com.jobbestie.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobbestie.jobportal.entity.JobEntity;
import com.jobbestie.jobportal.entity.JobSemiDTO;
import com.jobbestie.jobportal.service.JobService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500") //to make front-end to access this Rest api without blocking by Cors policy
public class JobController {
	
	@Autowired
	JobService jobService;
	
	//To get required data for cards design
	@GetMapping()
	public List<JobSemiDTO> getSemiDataJobs(){
		return jobService.getSemiDataJobs();
	}
	
	@GetMapping("/all")
	public List<JobEntity> getAllJobs(){
		return jobService.getAllJobs();
	}
	
	
	@PostMapping("/add")
	public String addJobDetails(@RequestBody JobEntity jobEntity) {
		jobService.addJob(jobEntity);
		return "Successfully Added";
	}
	}

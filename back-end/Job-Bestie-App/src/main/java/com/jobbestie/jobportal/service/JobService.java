package com.jobbestie.jobportal.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jobbestie.jobportal.entity.JobEntity;
import com.jobbestie.jobportal.entity.JobSemiDTO;
import com.jobbestie.jobportal.repository.JobRepository;
@Service
public class JobService implements JobServiceInterf {

	@Autowired
	JobRepository jobRepository;
	
	@Value("${server.port}")
	private String serverPort;
	
	@Override
	public List<JobSemiDTO> getSemiDataJobs() {
		List<JobSemiDTO> jobs = jobRepository.getSemiDataJobs();
			
		return jobs.stream().map( job -> {
			String logoUrl = "http://localhost:" + serverPort + "/api/logos/" + job.getLogo();
			job.setLogo(logoUrl);
			return job;
		}).collect(Collectors.toList());
	}
	
	@Override
	public List<JobEntity> getAllJobs() {
		List<JobEntity> jobs = jobRepository.findAll();
			
		return jobs.stream().map( job -> {
			String logoUrl = "http://localhost:" + serverPort + "/api/logos/" + job.getCompanyEntity().getLogo();
			job.getCompanyEntity().setLogo(logoUrl);
			return job;
		}).collect(Collectors.toList());
	}
	
	
	public void addJob(JobEntity jobEntity) {
		jobRepository.save(jobEntity);
	}
	

}

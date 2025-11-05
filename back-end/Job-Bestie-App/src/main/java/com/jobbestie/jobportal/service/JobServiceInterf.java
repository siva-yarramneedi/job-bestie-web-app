package com.jobbestie.jobportal.service;

import java.util.List;

import com.jobbestie.jobportal.entity.JobEntity;
import com.jobbestie.jobportal.entity.JobSemiDTO;

public interface JobServiceInterf {
	public List<JobSemiDTO> getSemiDataJobs();
	
	public List<JobEntity> getAllJobs();

	public void addJob(JobEntity jobEntity);
	
}

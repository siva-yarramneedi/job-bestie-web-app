package com.jobbestie.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobbestie.jobportal.entity.JobEntity;
import com.jobbestie.jobportal.entity.JobSemiDTO;
@Repository
public interface JobRepository extends JpaRepository<JobEntity,Long>{
	
	@Query(value = "SELECT j.id, j.posted_date, j.description, j.title, c.logo FROM job j JOIN company c ON j.company_entity_id = c.id", nativeQuery = true)
	List<JobSemiDTO> getSemiDataJobs();


}

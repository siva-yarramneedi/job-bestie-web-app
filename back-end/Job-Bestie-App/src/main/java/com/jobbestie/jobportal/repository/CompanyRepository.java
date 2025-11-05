package com.jobbestie.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobbestie.jobportal.entity.CompanyEntity;
@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity,Long>{

}

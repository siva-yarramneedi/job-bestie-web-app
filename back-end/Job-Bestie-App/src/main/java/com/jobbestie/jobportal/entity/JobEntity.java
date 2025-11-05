package com.jobbestie.jobportal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "job")
public class JobEntity {	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id; 
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    private CompanyEntity companyEntity;
	    
	    @Column(nullable = false)
	    private String postedDate;
	    
	    @Column(nullable = false)
	    private String location;
	    
	    @Column(nullable = false)
	    private String title;
	    
	    @Column(nullable = false)
	    private String designation;
	    
	    @Column(nullable = false)
	    private String type;
	    
	    @Column(nullable = false, columnDefinition = "TEXT")
	    private String description;
	    
	    @Column(nullable = false, columnDefinition = "TEXT")
	    private String rolesAndResponsibilities;
	    
	    @Column(nullable = false, columnDefinition = "TEXT")
	    private String requirements;
	    
	    @Column(nullable = false)
	    private int exp_min;
	    
	    @Column(nullable = false)
	    private int exp_max;
	    
	    @Column(nullable = false)
	    private String qualification;
	    
	    @Column(nullable = false)
	    private String percentageCriteria;
	    
	    @Column(nullable = false)
	    private int yearFrom;
	    
	    @Column(nullable = false)
	    private int yearTo;
	    
	    @Column(nullable = false)
	    private String applyLink;
	}

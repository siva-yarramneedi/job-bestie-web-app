package com.jobbestie.jobportal.entity;

import lombok.Data;

@Data
public class JobSemiDTO {
	
	private long id;
	private String postedDate;
	private String description;
	private String title;
	private String logo;
	public JobSemiDTO(Long id, String postedDate, String description, String title, String logo) {
        this.id = id;
        this.postedDate = postedDate;
        this.description = description;
        this.title = title;
        this.logo = logo;
    }
}

package com.desi.application.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tagList", schema = "master")
public class TagList {
	
	private Integer id;
	
	private String title;
	
	private String metaTitle;
	
	private String slug;
	
	private String createdOn;
	
	private Integer proponent;
	
	private Boolean active;
	
	private Boolean deleted;
	
	TagList(){
		this.active=true;
		this.deleted=false;
	}
}

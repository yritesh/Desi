package com.desi.application.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "category", schema = "master")
public class Category {

	private Integer id;
	
	
	private String title;
	
	
	private String metaTitle;
	
	
	private String slug;
	
	
	private String description;
	
	
	private Integer proponent;
	
	private Boolean active;
	
	private Boolean deleted;
	
	public Category() {
		this.active=true;
		this.deleted=false;
	}
}

package com.desi.application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "category", schema = "master")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private String title;
	
	
	private String metaTitle;
	
	
	private String slug;
	
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User proponent;
	
	private Boolean active;
	
	private Boolean deleted;
	
	public Category() {
		this.active=true;
		this.deleted=false;
	}
}

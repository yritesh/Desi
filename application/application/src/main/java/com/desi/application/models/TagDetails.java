package com.desi.application.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tagDetails", schema = "master")
public class TagDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String title;
	
	private String metaTitle;
	
	private String slug;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "tagDetails")
	private Tags tags;
	
	private Boolean active;
	
	private Boolean deleted;
	
	TagDetails(){
		this.active=true;
		this.deleted=false;
	}
}

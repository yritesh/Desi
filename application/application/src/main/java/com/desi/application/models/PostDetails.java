package com.desi.application.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "postDetails", schema = "master")
public class PostDetails {
	
	private Integer id;
	
	
	private String title;
	
	
	private String metaTitle;
	
	
	private String slug;
	
	
	private String summary;
	
	
	private String content;
	
	
	private Integer viewCount;
	
	
	private String postedDate;
	
	
	private Integer user;
	
	
	private Integer categoryId;
	
	
	private Integer olderVersion;
	
}

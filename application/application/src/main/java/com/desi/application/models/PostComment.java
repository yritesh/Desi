package com.desi.application.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "postComment", schema = "master")
public class PostComment {
	
	private Integer id;
	
	
	private Integer post;
	
	
	private Integer user;
	
	
	private String createdOn;
	
	
	private Boolean active;
	
	private Boolean deleted;
	
	PostComment(){
		
		this.active=true;
		this.deleted=false;
	}
	
}

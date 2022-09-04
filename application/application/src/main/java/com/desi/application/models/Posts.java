package com.desi.application.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "posts", schema = "master")
public class Posts {
	
	private Integer id;
	
	
	private Integer contentId;
	
	
	private Boolean active;
	
	
	private Boolean deleted;
	
	
	Posts(){
		this.active=true;
		this.deleted=false;
	}
}

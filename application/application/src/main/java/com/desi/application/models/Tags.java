package com.desi.application.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tags", schema = "master")
public class Tags {
	
	private Integer post;
	
	
	private Integer tag;
	
	
	private Boolean active;
	
	private Boolean deleted;
	
	Tags(){
		this.active=true;
		this.deleted=false;
	}
}

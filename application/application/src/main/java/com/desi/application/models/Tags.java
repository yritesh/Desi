package com.desi.application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@Table(name = "tags", schema = "master")
public class Tags {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "postId")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name = "tagDetailsId")
	private TagDetails tagDetails;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@Where(clause = "user.role = 'ADMIN'")
	private User user;
	
	private Boolean active;
	
	private Boolean deleted;
	
	Tags(){
		this.active=true;
		this.deleted=false;
	}
}

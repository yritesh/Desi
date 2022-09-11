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
@Table(name = "postComment", schema = "master")
public class PostComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "postId")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	private Boolean active;
	
	private Boolean deleted;
	
	public PostComment(){
		
		this.active=true;
		this.deleted=false;
	}
	
}

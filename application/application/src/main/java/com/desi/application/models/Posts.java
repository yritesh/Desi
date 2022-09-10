package com.desi.application.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "posts", schema = "master")
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer bookmarkCount;  
	
	private Boolean active;
	
	
	private Boolean deleted;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private List<PostComment> comment;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private List<Bookmark> bookmark;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private List<Tags> tags;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "post")
	private PostDetails details;
	
	Posts(){
		this.active=true;
		this.deleted=false;
	}
}

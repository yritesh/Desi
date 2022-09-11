package com.desi.application.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "post", schema = "master")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "postDetailsId")
	private PostDetails postDetails;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	private Integer bookmarkCount;  
	
	private Boolean active;
	
	
	private Boolean deleted;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private List<PostComment> comment;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private List<Bookmark> bookmark;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	private List<Tags> tags;
	
	Post(){
		this.active=true;
		this.deleted=false;
	}
}

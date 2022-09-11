package com.desi.application.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "postDetails", schema = "master")
public class PostDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "postDetails")
	private Post post;
	
	
	private String title;
	
	
	private String metaTitle;
	
	
	private String slug;
	
	
	private String summary;
	
	@Lob
	private String content;
	
	
	private Integer viewCount;
	
}

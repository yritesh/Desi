package com.desi.application.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@Table(name = "category", schema = "master")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private String title;
	
	
	private String metaTitle;
	
	
	private String slug;
	
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@Where(clause = "user.role = 'ADMIN'")
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "category")
	private Post post;
	
	private Boolean active;
	
	private Boolean deleted;
	
	public Category() {
		this.active=true;
		this.deleted=false;
	}
}

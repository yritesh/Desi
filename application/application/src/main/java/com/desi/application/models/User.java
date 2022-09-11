package com.desi.application.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.desi.application.utilityClasses.AdminRoles;

import lombok.Data;

@Data
@Entity
@Table(name = "user", schema = "master")
public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 32, columnDefinition = "varchar(32) default 'SUBSCRIBER'")
	@Enumerated(value = EnumType.STRING)
	private AdminRoles role = AdminRoles.SUBSCRIBER;

	@OneToOne
	@JoinColumn(name = "profileId")
	private Profile profile;
	
	private Boolean isActive;
	
	private Boolean isDeleted;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Post> post;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<PostComment> comment;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Tags> tags;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Bookmark> bookmark;
	
	
	User(){
		this.isActive=true;
		this.isDeleted=false;
	}
}

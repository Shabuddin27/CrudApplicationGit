package com.shab.projects.crud_app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class SkillsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String skillName;

	@ManyToMany
	@JoinTable(
	        name = "user_skills",  // Join table name
	        joinColumns = @JoinColumn(name = "skill_id"),  // Foreign key to SkillsEntity
	        inverseJoinColumns = @JoinColumn(name = "user_id")  // Foreign key to UserEntity
	    )
	@JsonIgnore
	private List<UserEntity> user;

	public SkillsEntity() {
		super();
	}

	public SkillsEntity(Long id, String skillName, List<UserEntity> user) {
		super();
		this.id = id;
		this.skillName = skillName;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public List<UserEntity> getUser() {
		return user;
	}

	public void setUser(List<UserEntity> user) {
		this.user = user;
	}

}
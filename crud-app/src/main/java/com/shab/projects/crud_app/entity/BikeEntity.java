package com.shab.projects.crud_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BikeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bikeModel;
	private String bikeType;

	@ManyToOne
	@JoinColumn(name = "user_id")

	@JsonIgnore
	private UserEntity user;

	public BikeEntity() {
		super();
	}

	public BikeEntity(int id, String bikeModel, String bikeType, UserEntity user) {
		super();
		this.id = id;
		this.bikeModel = bikeModel;
		this.bikeType = bikeType;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBikeModel() {
		return bikeModel;
	}

	public void setBikeModel(String bikeModel) {
		this.bikeModel = bikeModel;
	}

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}

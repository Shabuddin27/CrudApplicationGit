package com.shab.projects.crud_app.dto;

public class BikeDTO {

	private int id;
	private String bikeModel;
	private String bikeType;

	public BikeDTO() {
		super();
	}

	public BikeDTO(int id, String bikeModel, String bikeType) {
		super();
		this.id = id;
		this.bikeModel = bikeModel;
		this.bikeType = bikeType;

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

}

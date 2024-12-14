package com.shab.projects.crud_app.dto;

public class ContactDTO {

	private int id;
	private int phoneNumber;
	private String email;

	public ContactDTO() {
		super();
	}

	public ContactDTO(int id, int phoneNumber, String email) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

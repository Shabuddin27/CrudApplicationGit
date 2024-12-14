package com.shab.projects.crud_app.dto;

import java.util.*;

public class UserDTO {

	private int id;
	private String name;
	private int age;
	private String city;
	private String country;
	private ContactDTO contactDto;
	private List<BikeDTO> bikeDto;
	private List<SkillsDTO> skillsDto;


	public UserDTO() {
		super();
	}

	

	public UserDTO(int id, String name, int age, String city, String country, ContactDTO contactDto,
			List<BikeDTO> bikeDto, List<SkillsDTO> skillsDto) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
		this.country = country;
		this.contactDto = contactDto;
		this.bikeDto = bikeDto;
		this.skillsDto = skillsDto;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ContactDTO getContactDto() {
		return contactDto;
	}

	public void setContactDto(ContactDTO contactDto) {
		this.contactDto = contactDto;
	}

	public List<BikeDTO> getBikeDto() {
		return bikeDto;
	}

	public void setBikeDto(List<BikeDTO> bikeDto) {
		this.bikeDto = bikeDto;
	}



	public List<SkillsDTO> getSkillsDto() {
		return skillsDto;
	}



	public void setSkillsDto(List<SkillsDTO> skillsDto) {
		this.skillsDto = skillsDto;
	}



}

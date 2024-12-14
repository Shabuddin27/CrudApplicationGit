package com.shab.projects.crud_app.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String city;
	private String country;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private ContactEntity contactEntity;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<BikeEntity> bikeEntity;


	@ManyToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<SkillsEntity> skillsEntity;

	public UserEntity() {
		super();
	}



	public UserEntity(int id, String name, int age, String city, String country, ContactEntity contactEntity,
			List<BikeEntity> bikeEntity, List<SkillsEntity> skillsEntity) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
		this.country = country;
		this.contactEntity = contactEntity;
		this.bikeEntity = bikeEntity;
		this.skillsEntity = skillsEntity;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ContactEntity getContactEntity() {
		return contactEntity;
	}

	public void setContactEntity(ContactEntity contactEntity) {
		this.contactEntity = contactEntity;
	}

	public List<BikeEntity> getBikeEntity() {
		return bikeEntity;
	}

	public void setBikeEntity(List<BikeEntity> bikeEntity) {
		this.bikeEntity = bikeEntity;
	}



	public List<SkillsEntity> getSkillsEntity() {
		return skillsEntity;
	}



	public void setSkillsEntity(List<SkillsEntity> skillsEntity) {
		this.skillsEntity = skillsEntity;
	}



}

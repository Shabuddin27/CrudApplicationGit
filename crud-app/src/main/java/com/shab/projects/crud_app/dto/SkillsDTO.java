package com.shab.projects.crud_app.dto;

public class SkillsDTO {

	private Long id;
	private String skillName;

	public SkillsDTO() {
		super();
	}

	public SkillsDTO(Long id, String skillName) {
		super();
		this.id = id;
		this.skillName = skillName;
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

}
